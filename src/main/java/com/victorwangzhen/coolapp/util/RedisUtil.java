package com.victorwangzhen.coolapp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class RedisUtil {

    private static JedisConnectionFactory jedisConnectionFactory;


    private RedisUtil(){

    }

    private static RedisUtil INSTANCE = new RedisUtil();


    public static Jedis getJedis(){
        return (Jedis) INSTANCE.getJedisConnectionFactory().getConnection().getNativeConnection();
    }

    private JedisConnectionFactory getJedisConnectionFactory(){
        if(jedisConnectionFactory == null){
            jedisConnectionFactory
                    = (JedisConnectionFactory) SpringContextUtil
                    .getApplicationContext().getBean("jedisConnectionFactory");
        }

        return jedisConnectionFactory;
    }

    public static void close(Jedis jedis){
        if(jedis != null){
            jedis.close();
        }
    }

}
