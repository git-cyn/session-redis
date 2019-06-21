package com.cyn.controller;

import com.cyn.domain.User;
import com.cyn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/api/user")
public class LoginController
{
    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("/login")
    public String login(HttpServletRequest request, String account, String password) throws Exception {
        User user = userService.findUserByAccountAndPassword(account, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loginUserId", user.getUserId());
            redisTemplate.opsForValue().set("loginUser:" + user.getUserId(), session.getId());
            return  "登录成功！";
        } else {
            throw new Exception("账户名或密码错误！");
        }
    }

    @RequestMapping(value = "/getUserInfo")
    public String get(long userId) throws Exception {
        User user = userService.findUserByUserId(userId);
        if (user != null) {
            return "查询成功！";
        } else {
            throw new Exception("用户不存在！");
        }
    }
}
