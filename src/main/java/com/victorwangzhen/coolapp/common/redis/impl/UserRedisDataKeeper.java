package com.victorwangzhen.coolapp.common.redis.impl;

import com.victorwangzhen.coolapp.common.redis.RedisDataKeeper;
import com.victorwangzhen.coolapp.repsitory.entity.UserEntity;


public class UserRedisDataKeeper extends RedisDataKeeper {


    @Override
    protected Class getTClass() {
        return UserEntity.class;
    }
}
