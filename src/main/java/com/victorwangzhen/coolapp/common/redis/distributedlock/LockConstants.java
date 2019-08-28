package com.victorwangzhen.coolapp.common.redis.distributedlock;


/**
 * distributed lock constants
 */
public abstract class LockConstants {

    /**
     * lock success flag
     */

    public static final String LOCK_SUCCESS = "OK";

    /**
     * release success flag
     */

    public static final Long RELEASE_SUCCESS = 1L;

    /**
     * if lock does not exist
     */

    public static final String SET_IF_NOT_EXIST = "NK";

    /**
     * if lock exist
     */

    public static final String SET_IF_EXIST = "XX";

    /**
     * if expired
     */

    public static final String SET_WITH_EXPIRED_TIME = "PX";
}
