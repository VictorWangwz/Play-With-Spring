package com.victorwangzhen.coolapp.delegate;

import com.victorwangzhen.coolapp.repsitory.entity.User;

import java.util.List;

public interface UserServiceDelegate {

    boolean createUser(User user);

    User getUser(String id, String username, String email);

    List<User> getUserV2();

}
