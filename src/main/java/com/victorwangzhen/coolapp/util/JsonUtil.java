package com.victorwangzhen.coolapp.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


/**
 * JSON Util
 */
public class JsonUtil {

    /**
     * convert object to json string
     * @param object
     * @return
     */
    public static String objectToJson(Object object){
        String jsonObject = JSON.toJSONString(object);
        return jsonObject;
    }


    /**
     * convert jsonObject to Object
     * @param json
     * @param clazz
     * @return
     */
    public static Object jsonToObject(String json, Class clazz){


        Object object = JSONObject.parseObject(json, clazz);

        return object;
    }
}
