package com.victorwangzhen.coolapp.common.redis;

import com.victorwangzhen.coolapp.common.redis.model.RedisObject;

public interface IRedisDataKeeper<T> {

    RedisObject<T> get(String key);

    long set(String key, RedisObject<T> value);
}
