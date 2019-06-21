package com.cyn.service;

import com.cyn.domain.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

/**
 * Created by cyn on 2019/6/21.
 */
public interface UserService {

    User findUserByAccountAndPassword(String account, String password);

    User findUserByUserId(long userId);
}
