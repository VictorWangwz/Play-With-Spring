package com.victorwangzhen.coolapp.common.redis.impl;

import com.victorwangzhen.coolapp.common.redis.RedisDataKeeper;
import com.victorwangzhen.coolapp.repsitory.entity.User;


public class UserRedisDataKeeper extends RedisDataKeeper {


    @Override
    protected Class getTClass() {
        return User.class;
    }
}
