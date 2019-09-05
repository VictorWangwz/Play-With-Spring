package com.victorwangzhen.coolapp.controller;


import com.victorwangzhen.coolapp.delegate.UserServiceDelegate;
import com.victorwangzhen.coolapp.repsitory.entity.UserEntity;
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
    private SessionRegistry sessionRegistry;


    @GetMapping("/jpa/user/{id}")
    public UserEntity getUser(HttpServletRequest httpServletRequest, @PathVariable("id") String id){

        return userServiceDelegate.getUser(id, null, null);
    }

    @PostMapping("/save")
    public boolean createUser(HttpServletRequest httpServletRequest, @RequestBody UserEntity userEntity){
        return userServiceDelegate.createUser(userEntity);

    }

    @GetMapping("/mybatis/user")

    public List<UserEntity> getUserByMybatis(HttpServletRequest httpServletRequest){
        return userServiceDelegate.getUserV2();
    }


}
