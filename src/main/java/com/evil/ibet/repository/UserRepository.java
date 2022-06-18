package com.evil.ibet.repository;

import com.evil.ibet.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("select bean from User bean where bean.wxOpenId = ?1")
    User selectUserByWxOpenId(String wxOpenId);

}
