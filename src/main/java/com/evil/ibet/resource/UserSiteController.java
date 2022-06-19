package com.evil.ibet.resource;

import com.evil.ibet.domain.BetSite;
import com.evil.ibet.domain.CommonResponse;
import com.evil.ibet.domain.Response;
import com.evil.ibet.domain.UserSite;
import com.evil.ibet.service.BetSiteService;
import com.evil.ibet.service.UserSiteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("wechat")
public class UserSiteController {

    @Resource
    private UserSiteService userSiteService;

    @GetMapping(value = "userSite", produces = "application/json;charset=UTF-8")
    public @ResponseBody Response getUserSiteById(@RequestParam Integer userId, @RequestParam Integer siteId) {
        return CommonResponse.success(userSiteService.getUserBetSiteByUserIdAndSiteId(userId, siteId));
    }

}
