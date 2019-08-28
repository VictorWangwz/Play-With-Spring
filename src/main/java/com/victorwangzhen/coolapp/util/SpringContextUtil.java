package com.victorwangzhen.coolapp.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;


public class SpringContextUtil {

    private static ApplicationContext applicationContext;


    public static void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }


    public static ApplicationContext getApplicationContext(){
        return SpringContextUtil.applicationContext;
    }
}
