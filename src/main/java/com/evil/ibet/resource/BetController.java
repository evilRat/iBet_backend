package com.evil.ibet.resource;

import com.alibaba.fastjson.JSON;
import com.evil.ibet.domain.BetSite;
import com.evil.ibet.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("wechat")
public class BetController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "betSites", produces = "application/json;charset=UTF-8")
    public @ResponseBody String betSites(String userId) {
        String rtnCode = "999";
        String rtnMessage = "获取用户投注站信息失败：接口调用异常";
        List<BetSite> betSitesList = null;
        Map resultMap = new HashMap();
        if (!StringUtils.isEmpty(userId)) {
            betSitesList = userService.getUserBetSitesByUserId(userId);
            if (betSitesList != null) {
                rtnCode = "0";
                rtnMessage = "获取用户投注站信息成功";
            } else {
                rtnCode = "1";
                rtnMessage = "您还没有在投注站充值！";
            }
        } else {
            rtnCode = "1";
            rtnMessage = "获取用户投注站信息失败：userId="+userId;
        }
        for (BetSite betSite: betSitesList) {
            betSite.setBetTypes(betSite.getBetTypes().replace(",", ""));
        }
        resultMap.put("rtnCode", rtnCode);
        resultMap.put("rtnMessage", rtnMessage);
        resultMap.put("betSites",betSitesList);
        return JSON.toJSONString(resultMap);
    }

}
