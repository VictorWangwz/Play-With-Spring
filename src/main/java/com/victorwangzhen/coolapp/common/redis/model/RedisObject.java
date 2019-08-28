package com.victorwangzhen.coolapp.common.redis.model;

import lombok.Builder;
import lombok.Data;


/**
 * redis data object wrapper
 * @param <T>
 */
@Data
@Builder
public class RedisObject<T> {

    private T object;

    public RedisObject(T object){
        this.object = object;
    }
}
