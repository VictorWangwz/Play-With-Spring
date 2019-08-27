package com.victorwangzhen.coolapp.Controller;


import com.victorwangzhen.coolapp.model.dao.UserDao;
import com.victorwangzhen.coolapp.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class userController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/")
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

        System.out.println(rst);

        return true;

    }
}
