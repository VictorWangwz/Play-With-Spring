package com.victorwangzhen.coolapp.controller;


import com.victorwangzhen.coolapp.delegate.UserServiceDelegate;
import com.victorwangzhen.coolapp.repsitory.entity.User;
import com.victorwangzhen.coolapp.repsitory.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserServiceDelegate userServiceDelegate;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SessionRegistry sessionRegistry;


    @GetMapping("/jpa/user/{id}")
    public User getUser(HttpServletRequest httpServletRequest, @PathVariable("id") String id){

        return userServiceDelegate.getUser(id, null, null);
    }

    @RequestMapping(path = "/login-page")
    public String login(HttpServletRequest httpServletRequest){
        return "Success";
    }

    @PostMapping("/save")
    public boolean createUser(HttpServletRequest httpServletRequest, @RequestBody User user){
        return userServiceDelegate.createUser(user);

    }

    @GetMapping("/mybatis/user")
    public List<User> getUserByMybatis(HttpServletRequest httpServletRequest){
        return userServiceDelegate.getUserV2();
    }


}
