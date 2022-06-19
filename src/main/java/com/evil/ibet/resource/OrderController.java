package com.evil.ibet.resource;

import com.alibaba.fastjson.JSON;
import com.evil.ibet.domain.Order;
import com.evil.ibet.service.OrderService;
import com.evil.ibet.service.UserService;
import com.evil.ibet.service.UserSiteService;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("order")
public class OrderController {

    @Resource
    private OrderService orderService;
    @Resource
    private UserService userService;
    @Resource
    private UserSiteService userSiteService;

    @RequestMapping(value = "userOrder", produces = "application/json;charset=UTF-8")
    public @ResponseBody String getUserOrder(String userId) {

        String rtnCode = "999";
        String rtnMessage = "调用接口失败 order/newOrder";
        Map resultMap = new HashMap();

        List<Order> orderList = orderService.getOrderByUserId(userId);
        if (orderList == null || orderList.size() ==0) {
            rtnCode = "1";
            rtnMessage = "您最近五天没有订单";
        } else {
            rtnCode = "0";
            rtnMessage = "成功";
        }
        resultMap.put("rtnCode", rtnCode);
        resultMap.put("rtnMessage", rtnMessage);
        resultMap.put("userOrderList", orderList);
        return JSON.toJSONString(resultMap);
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
            Order order = Order.builder().id(userId).betSiteId(betSiteId).betId(betId).redBalls(redBalls).blueBalls(blueBalls).times(times).build();
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
