package com.victorwangzhen.coolapp.repsitory.mybatis;

import com.victorwangzhen.coolapp.repsitory.entity.UserEntity;
import com.victorwangzhen.coolapp.repsitory.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoV2 {

    @Autowired
    private UserMapper userMapper;

    public List<UserEntity> getUser(){
        List<UserEntity> userEntityList = userMapper.getAll();

        return userEntityList;
    }


}
