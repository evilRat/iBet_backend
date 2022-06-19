package com.evil.ibet.service;

import com.evil.ibet.domain.UserSite;

import java.math.BigDecimal;
import java.util.List;

public interface UserSiteService {

    List<UserSite> getUserBetSitesByUserId(Integer userId);

    UserSite getUserBetSiteByUserIdAndSiteId(Integer userId, Integer siteId);

    int updateUserBalanceByUserIdBetSiteId(Integer userId, Integer betSiteId, BigDecimal amount);
}
