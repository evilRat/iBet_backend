package com.evil.ibet.service.impl;

import com.evil.ibet.domain.BetSite;
import com.evil.ibet.domain.User;
import com.evil.ibet.repository.UserRepository;
import com.evil.ibet.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
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

}
