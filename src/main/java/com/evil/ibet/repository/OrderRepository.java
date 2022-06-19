package com.evil.ibet.repository;

import com.evil.ibet.domain.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {

    @Query("select bean from Order bean where bean.userId = ?1")
    List<Order> selectOrdersByUserId(Integer userId);

    @Query("select bean from Order bean where bean.userId = ?1 and bean.siteId = ?2")
    List<Order> selectOrdersByUserIdAndSiteId(Integer userId, Integer siteId);

}
