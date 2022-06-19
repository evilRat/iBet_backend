package com.evil.ibet.service;

import com.evil.ibet.domain.BetSite;
import com.evil.ibet.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    void saveUser(User user);

    User getUserByWxOpenId(String wxOpenId);

    User getUserById(String wxOpenId);

    User updateUserById(User user);
}
