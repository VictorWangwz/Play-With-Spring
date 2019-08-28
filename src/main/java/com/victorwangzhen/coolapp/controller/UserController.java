package com.victorwangzhen.coolapp.controller;


import com.victorwangzhen.coolapp.common.redis.impl.UserRedisDataKeeper;
import com.victorwangzhen.coolapp.common.redis.model.RedisObject;
import com.victorwangzhen.coolapp.model.jpa.dao.UserDao;
import com.victorwangzhen.coolapp.model.entity.User;
import com.victorwangzhen.coolapp.model.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/jpa/user/{id}")
    public User getUser(HttpServletRequest httpServletRequest, @PathVariable("id") String id){
        if(userDao.existsById(id)){
            User user = userDao.findById(id).get();
            return user;
        }
        return null;

    }

    @PostMapping("/save")
    public boolean createUser(HttpServletRequest httpServletRequest, @RequestBody User user){
        //do not use anonymous inner class to create user, cuz this cls does have @entity after compiling.

        Object rst = userDao.save(user);

        return rst != null;

    }

    @GetMapping("/mybatis/user")
    public List<User> getUserByMybatis(HttpServletRequest httpServletRequest){
        List<User> userList = userMapper.getAll();

        return  userList;
    }


}
