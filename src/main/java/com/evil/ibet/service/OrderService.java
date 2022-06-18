package com.evil.ibet.service;

import com.evil.ibet.domain.Order;

import java.util.List;

public interface OrderService {

    Order saveOrder(Order order);

    List<Order> getOrderByUserId(String userId);

}
