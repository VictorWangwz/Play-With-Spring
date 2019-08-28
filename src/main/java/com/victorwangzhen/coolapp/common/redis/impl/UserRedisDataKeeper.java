package com.victorwangzhen.coolapp.common.redis.impl;

import com.victorwangzhen.coolapp.common.redis.RedisDataKeeper;
import com.victorwangzhen.coolapp.model.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class UserRedisDataKeeper extends RedisDataKeeper {


    @Override
    protected Class getTClass() {
        return User.class;
    }
}
