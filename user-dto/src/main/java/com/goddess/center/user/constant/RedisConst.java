package com.goddess.center.user.constant;

/**
 * redis静态配置
 * @author 失败女神
 * @email: 18733123202@163.com
 * @date 2021/4/7 下午4:30
 * @Copyright © 女神帮
 */
public class RedisConst {



    public static String mq = "user:mq:key";


    public static String getRedisKey(String type, String key) {
        return type+SEPARATE+key;
    }

    public static String getRedisKey(String type, String key, String groupId){
        return type + SEPARATE + key + SEPARATE + groupId;
    }

    /**
     * 分隔符
     */
    public static String SEPARATE = ":";
}