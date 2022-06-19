package com.evil.ibet.resource;

import com.evil.ibet.domain.Bet;
import com.evil.ibet.domain.CommonResponse;
import com.evil.ibet.domain.Response;
import com.evil.ibet.service.BetService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("wechat")
public class BetController {

    @Resource
    private BetService betService;

    @GetMapping(value = "bet", produces = "application/json;charset=UTF-8")
    public @ResponseBody Response getBetByIds(@RequestParam String ids) {
        if (!StringUtils.hasText(ids)) {
            return CommonResponse.failure("id不能为空");
        }
        List<Integer> idList = Arrays.stream(ids.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        if (null == idList || idList.isEmpty()) {
            return CommonResponse.failure("id不能为空");
        }
        List<Bet> betSiteByIdList = betService.getBetByIdList(idList);
        return CommonResponse.success(betSiteByIdList);
    }

    @GetMapping("bet/{id}")
    public @ResponseBody Response getBetById(@PathVariable("id") Integer id) {
        return CommonResponse.success(betService.getBetById(id));
    }

}
