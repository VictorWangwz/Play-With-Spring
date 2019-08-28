package com.victorwangzhen.coolapp.common.configuration;


import com.victorwangzhen.coolapp.common.redis.impl.UserRedisDataKeeper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

import javax.validation.Valid;

@Configuration
public class RedisConfiguration {


    @Bean
    public JedisConnectionFactory jedisConnectionFactory(
            JedisPoolConfig jedisPoolConfig,
            RedisStandaloneConfiguration redisStandaloneConfiguration
    ){
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisStandaloneConfiguration);

        jedisConnectionFactory.setPoolConfig(jedisPoolConfig);

        return jedisConnectionFactory;

    }

    @Configuration
    public static class JedisConfig{


        @Value("${spring.redis.host:127.0.0.1}")
        private String host;

        @Value("${spring.redis.port:6379}")
        private Integer port;

        @Value("${spring.redis.password:}")
        private String password;

        @Value("${spring.redis.database:0}")
        private Integer database;

        @Value("${spring.redis.jedis.pool.max-idle:8}")
        private Integer maxIdle;

        @Value("${spring.redis.jedis.pool.min-idle:0}")
        private Integer minIdle;

        @Value("${spring.redis.jedis.pool.max-active:8}")
        private Integer maxTotal;

        @Value("${spring.redis.jedis.pool.max-wait:-1}")
        private Integer maxWaitMills;


        @Bean
        public RedisStandaloneConfiguration jedisConfig(){
            RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
            redisStandaloneConfiguration.setDatabase(database);
            redisStandaloneConfiguration.setHostName(host);
            redisStandaloneConfiguration.setPort(port);
            redisStandaloneConfiguration.setPassword(password);
            return redisStandaloneConfiguration;
        }

        @Bean
        public JedisPoolConfig jedisPoolConfig(){
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxIdle(maxIdle);
            jedisPoolConfig.setMaxTotal(maxTotal);
            jedisPoolConfig.setMaxWaitMillis(maxWaitMills);
            jedisPoolConfig.setMinIdle(minIdle);
            return jedisPoolConfig;
        }
    }

    @Bean
    public UserRedisDataKeeper userRedisDataKeeper(){
        return new UserRedisDataKeeper();
    }
}
