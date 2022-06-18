package com.evil.ibet.service;

import com.evil.ibet.domain.BetSite;
import com.evil.ibet.domain.User;
import com.evil.ibet.entity.BetSite;
import com.evil.ibet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User getUserByWxOpenId(String wxOpenId) {
        return userRepository.selectUserByWxOpenId(wxOpenId);
    }

    public User getUserById(String id) {
        return userRepository.findById(Integer.parseInt(id)).orElse(null);
    }

    public User updateUserById(User user) {
        return userRepository.save(user);
    }

    public List<BetSite> getUserBetSitesByUserId(String userId) {
        return userRepository.selectUserBetSitesByUserId(userId);
    }

    public int updateUserBalanceByUserIdBetSiteId(Map map) {
        return userRepository.updateUserBalanceByUserIdBetSiteId(map);
    }

}
