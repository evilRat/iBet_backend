package com.evil.ibet.resource;

import com.evil.ibet.domain.BetSite;
import com.evil.ibet.domain.CommonResponse;
import com.evil.ibet.domain.Response;
import com.evil.ibet.domain.UserSite;
import com.evil.ibet.service.BetSiteService;
import com.evil.ibet.service.UserSiteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("wechat")
public class BetSiteController {

    @Resource
    private UserSiteService userSiteService;

    @Resource
    private BetSiteService betSiteService;

    @RequestMapping(value = "betSites", produces = "application/json;charset=UTF-8")
    public @ResponseBody Response betSites(Integer userId) {
        Integer rtnCode = 999;
        String rtnMessage = "获取用户投注站信息失败：接口调用异常";
        List<BetSite> betSitesList = null;
        if (null != userId) {
            List<UserSite> userBetSitesByUserId = userSiteService.getUserBetSitesByUserId(userId);
            if (userBetSitesByUserId.isEmpty()) {
                return CommonResponse.failure("根据用户ID没有找到投注站信息");
            }
            betSitesList = betSiteService.getBetSiteByIdList(userBetSitesByUserId.stream().map(UserSite::getSiteId).collect(Collectors.toList()));
            if (betSitesList != null && !betSitesList.isEmpty()) {
                rtnCode = 0;
                rtnMessage = "获取用户投注站信息成功";
                betSitesList.forEach(e -> {
                    e.setBetTypeList((Arrays.stream(e.getBetTypes().split(",")).map(Integer::valueOf).collect(Collectors.toList())));
                });
            } else {
                rtnCode = 1;
                rtnMessage = "您还没有在投注站充值！";
            }
        } else {
            rtnCode = 1;
            rtnMessage = "获取用户投注站信息失败：userId="+userId;
        }
        return CommonResponse.success(rtnCode, rtnMessage, betSitesList);
    }

}
