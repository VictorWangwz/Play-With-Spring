package com.victorwangzhen.coolapp.delegate.impl;

import com.victorwangzhen.coolapp.delegate.UserServiceDelegate;
import com.victorwangzhen.coolapp.repsitory.entity.UserEntity;
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
    public boolean createUser(UserEntity userEntity) {
        //do not use anonymous inner class to create userEntity, cuz this cls does have @entity after compiling.

        Object rst = userDao.save(userEntity);

        return rst != null;
    }

    @Override
    public UserEntity getUser(String id, String username, String email) {
        if(userDao.existsById(id)){
            UserEntity userEntity = userDao.findById(id).get();
            return userEntity;
        }
        return null;
    }

    public List<UserEntity> getUserV2(){
        return userDaoV2.getUser();
    }
}
