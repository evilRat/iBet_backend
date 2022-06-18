package com.evil.ibet.wechat.service;

import com.evil.ibet.entity.BetSite;
import com.evil.ibet.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    void saveUser(User user);

    User getUserByWxOpenId(String wxOpenId);

    User getUserById(String wxOpenId);

    int updateUserById(User user);

    List<BetSite> getUserBetSitesByUserId(String userId);

    int updateUserBalanceByUserIdBetSiteId(Map map);
}
