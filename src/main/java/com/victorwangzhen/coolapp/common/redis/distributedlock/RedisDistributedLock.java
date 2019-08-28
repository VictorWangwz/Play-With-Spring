package com.victorwangzhen.coolapp.common.redis.distributedlock;

import com.victorwangzhen.coolapp.util.RedisUtil;
import redis.clients.jedis.Jedis;

import java.util.Collections;

public class RedisDistributedLock {

    private String key;


    /**
     * must be unique
     */
    private String value;

    public RedisDistributedLock(String key, String value){
        this.key = key;
        this.value = value;
    }

    /**
     * expireTime in million second
     * @param expireTime
     * @return
     * @throws Exception
     */

    public boolean lock(int expireTime) throws Exception{
        Jedis jedis = RedisUtil.getJedis();

        String result = jedis.set(
                key,
                value,
                LockConstants.SET_IF_NOT_EXIST,
                LockConstants.SET_WITH_EXPIRED_TIME,
                expireTime
        );

        if(LockConstants.LOCK_SUCCESS.equals(result)){
            return true;
        }

        return false;
    }


    /**
     * unlcok with lua script for atomicity
     * @return
     */
    public boolean unlock(){
        Jedis jedis = RedisUtil.getJedis();

        try{


            String script = "if redis.call('get', KEY[1]) == ARGV[1] then return redis.call('del',KEY[1]) else return 0 end";
            Object result = jedis.eval(script, Collections.singletonList(key), Collections.singletonList(value));

            if(LockConstants.RELEASE_SUCCESS.equals(result)){
                return true;
            }

            return false;

        }catch (Exception e){
            return false;
        }
    }
}
