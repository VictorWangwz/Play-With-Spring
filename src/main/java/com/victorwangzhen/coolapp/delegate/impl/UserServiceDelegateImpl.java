package com.victorwangzhen.coolapp.delegate.impl;

import com.victorwangzhen.coolapp.delegate.UserServiceDelegate;
import com.victorwangzhen.coolapp.repsitory.entity.User;
import com.victorwangzhen.coolapp.repsitory.jpa.dao.UserDao;
import com.victorwangzhen.coolapp.repsitory.mybatis.UserDaoV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceDelegateImpl implements UserServiceDelegate {


    @Autowired
    private UserDao userDao;

    @Autowired
    private UserDaoV2 userDaoV2;


    @Override
    public boolean createUser(User user) {
        //do not use anonymous inner class to create user, cuz this cls does have @entity after compiling.

        Object rst = userDao.save(user);

        return rst != null;
    }

    @Override
    public User getUser(String id, String username, String email) {
        if(userDao.existsById(id)){
            User user = userDao.findById(id).get();
            return user;
        }
        return null;
    }

    public List<User> getUserV2(){
        return userDaoV2.getUser();
    }
}
