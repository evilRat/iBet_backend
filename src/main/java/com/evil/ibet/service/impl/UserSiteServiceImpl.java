package com.evil.ibet.service.impl;

import com.evil.ibet.domain.UserSite;
import com.evil.ibet.repository.UserSiteRepository;
import com.evil.ibet.service.UserSiteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class UserSiteServiceImpl implements UserSiteService {

    @Resource
    UserSiteRepository userSiteRepository;

    public List<UserSite> getUserBetSitesByUserId(Integer userId) {
        return userSiteRepository.selectUserBetSitesByUserId(userId);
    }

    @Override
    public UserSite getUserBetSiteByUserIdAndSiteId(Integer userId, Integer siteId) {
        return userSiteRepository.selectUserBetSitesByUserIdAndSiteId(userId, siteId);
    }

    public int updateUserBalanceByUserIdBetSiteId(Integer userId, Integer betSiteId, BigDecimal amount) {
        return userSiteRepository.updateUserBalanceByUserIdBetSiteId(userId, betSiteId, amount);
    }

}
