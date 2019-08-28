package com.victorwangzhen.coolapp.common.redis;

import com.alibaba.fastjson.JSONObject;
import com.victorwangzhen.coolapp.common.redis.model.RedisObject;
import com.victorwangzhen.coolapp.util.JsonUtil;
import redis.clients.jedis.Jedis;


public abstract class RedisDataKeeper implements IRedisDataKeeper<Object> {

    private String dbname;

    private Jedis jedis;

    public RedisDataKeeper(){
        this.dbname = getTClass().getSimpleName();
    }

    public void setJedis(Jedis jedis){
        this.jedis = jedis;
    }

    public Jedis getJedis(){
        return this.jedis;
    }


    @Override
    public RedisObject get(String key) {


        RedisObject rst = null;

        if(jedis.hexists(dbname, key)){

            JSONObject jsonObject = (JSONObject) JSONObject.parse(jedis.hget(dbname, key));

            String json = ((JSONObject)jsonObject.get("object")).toJSONString();


            rst = new RedisObject(JsonUtil.jsonToObject(json, getTClass()));
        }


        return rst;
    }

    @Override
    public long set(String key, RedisObject value) {

        Long rst = jedis.hset(dbname, key, JsonUtil.objectToJson(value));


        return rst ;
    }

    abstract protected Class getTClass();



}
