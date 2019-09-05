package com.victorwangzhen.coolapp.delegate;

import com.victorwangzhen.coolapp.repsitory.entity.UserEntity;

import java.util.List;

public interface UserServiceDelegate {

    boolean createUser(UserEntity userEntity);

    UserEntity getUser(String id, String username, String email);

    List<UserEntity> getUserV2();

}
