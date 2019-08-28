package com.victorwangzhen.coolapp.controller;


import com.victorwangzhen.coolapp.common.redis.impl.UserRedisDataKeeper;
import com.victorwangzhen.coolapp.common.redis.model.RedisObject;
import com.victorwangzhen.coolapp.model.jpa.dao.UserDao;
import com.victorwangzhen.coolapp.model.entity.User;
import com.victorwangzhen.coolapp.model.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/jpa/user")
    public String getUser(HttpServletRequest httpServletRequest){
        if(userDao.findAll().size() != 0){
            User user = userDao.findAll().get(0);
            return user.getId();
        }
        return "wrong";

    }

    @PostMapping("/save")
    public boolean createUser(HttpServletRequest httpServletRequest){
        //do not use anonymous inner class to create user, cuz this cls does have @entity after compiling.
        User user = new User();
        user.setId("test");
        user.setPassword("pwd");
        user.setUsername("name");

        Object rst = userDao.save(user);



        return true;

    }

    @GetMapping("/mybatis/user")
    public int getUserByMybatis(HttpServletRequest httpServletRequest){
        List<User> userList = userMapper.getAll();

        return  userList.size();
    }


    @Autowired
    private UserRedisDataKeeper redisDataKeeper;

    @GetMapping("/jedis")
    public boolean getJedis(HttpServletRequest httpServletRequest){

        User user = new User();
        user.setId("test");
        user.setPassword("pwd2");
        user.setUsername("name");

        RedisObject redisObject = redisDataKeeper.get("test");

        long rst = redisDataKeeper.set("test", new RedisObject(user));

        RedisObject redisObject1 = redisDataKeeper.get("test");

        return true;

    }
}
