package com.cyn.service.impl;

import com.cyn.domain.User;
import com.cyn.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by cyn on 2019/6/21.
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User findUserByAccountAndPassword(String account, String password) {
        return null;
    }

    @Override
    public User findUserByUserId(long userId) {
        return null;
    }
}
