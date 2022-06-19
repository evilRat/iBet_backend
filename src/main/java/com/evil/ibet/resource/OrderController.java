package com.evil.ibet.resource;

import com.alibaba.fastjson.JSON;
import com.evil.ibet.domain.*;
import com.evil.ibet.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
@RequestMapping("order")
public class OrderController {

    @Resource
    private OrderService orderService;
    @Resource
    private UserSiteService userSiteService;

    @Resource
    private BetSiteService betSiteService;

    @Resource
    private BetService betService;

    @GetMapping("getByUserAndSite")
    public @ResponseBody Response getUserOrder(@RequestParam Integer userId, @RequestParam Integer siteId) {
        // todo 分页
        List<Order> orderList = orderService.getOrderByUserIdAndSiteId(userId, siteId);
        if (orderList.isEmpty()) {
            return CommonResponse.success();
        }
        // 获取相关投注站信息
        List<BetSite> betSiteByIdList = betSiteService.getBetSiteByIdList(orderList.stream().map(Order::getSiteId).collect(Collectors.toList()));
        Map<Integer, BetSite> betSiteMap = betSiteByIdList.stream().collect(Collectors.toMap(BetSite::getId, Function.identity(), (e1, e2) -> e1));
        // 获取玩法信息
        List<Bet> betList = betService.getBetByIdList(orderList.stream().map(Order::getBetId).collect(Collectors.toList()));
        Map<Integer, Bet> betMap = betList.stream().collect(Collectors.toMap(Bet::getId, Function.identity(), (e1, e2) -> e1));
        orderList.forEach(o -> {
            o.setSiteName(betSiteMap.get(o.getSiteId()).getSiteName());
            o.setBetName(betMap.get(o.getBetId()).getBetName());
            o.setRedList(Arrays.stream(o.getRedBalls().split(",")).map(Integer::parseInt).collect(Collectors.toList()));
            if (StringUtils.hasText(o.getBlueBalls())) {
                o.setBlueList(Arrays.stream(o.getBlueBalls().split(",")).map(Integer::parseInt).collect(Collectors.toList()));
            }
        });
        return CommonResponse.success(orderList);
    }

    @Transactional
    @RequestMapping(value = "newOrder", produces = "application/json;charset=UTF-8")
    public @ResponseBody String createOrder(Integer userId, Integer betSiteId, Integer betId, String redBalls, String blueBalls, Integer times) {
        // todo 挪到application中
        String rtnCode = "999";
        String rtnMessage = "调用接口失败 order/newOrder";
        Map resultMap = new HashMap();

        if (!StringUtils.isEmpty(userId) && !StringUtils.isEmpty(betSiteId)
                && !StringUtils.isEmpty(redBalls) && !StringUtils.isEmpty(blueBalls) && !StringUtils.isEmpty(times)) {
            Order order = Order.builder().id(userId).siteId(betSiteId).betId(betId).redBalls(redBalls).blueBalls(blueBalls).times(times).build();
            Order addOrder = orderService.saveOrder(order);
            if (addOrder != null) {
                userSiteService.updateUserBalanceByUserIdBetSiteId(userId, betSiteId, BigDecimal.valueOf(2*times));
            }
            rtnCode = "0"; //成功
            rtnMessage = "下单成功";
        } else {
            rtnCode = "1"; //失败 参数不全
            rtnMessage = "创建order失败，由于参数不全";
        }
        resultMap.put("rtnCode", rtnCode);
        resultMap.put("rtnMessage", rtnMessage);
        return JSON.toJSONString(resultMap);
    }

}
