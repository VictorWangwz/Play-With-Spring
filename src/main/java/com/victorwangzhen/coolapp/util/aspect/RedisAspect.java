package com.victorwangzhen.coolapp.util.aspect;


import com.victorwangzhen.coolapp.common.redis.impl.UserRedisDataKeeper;
import com.victorwangzhen.coolapp.util.RedisUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * AOP for redis
 */
@Aspect
@Component
public class RedisAspect {


    /**
     * pointcut matching all methods in RedisDataKeeper
     */
    @Pointcut("execution(public * com.victorwangzhen.coolapp.common.redis.RedisDataKeeper.*(..))")
    public void pointcut(){}


    /**
     * Around Aspect to open and close jedis
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("pointcut()")
    public Object jedisConnection(ProceedingJoinPoint joinPoint) throws Throwable{
        UserRedisDataKeeper userRedisDataKeeper = (UserRedisDataKeeper) joinPoint.getTarget();

        userRedisDataKeeper.setJedis(RedisUtil.getJedis());

        Object returnValue = joinPoint.proceed();

        RedisUtil.close(userRedisDataKeeper.getJedis());

        userRedisDataKeeper.setJedis(null);

        return returnValue;


    }
}
