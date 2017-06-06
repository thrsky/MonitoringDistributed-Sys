package com.zjut.sys.utils;

import com.zjut.sys.enums.redisValue;
import redis.clients.jedis.Jedis;

/**
 * Created by thRShy on 2017/6/6.
 */
public final class redisUtil {

    private static Jedis jedis;

    public static Jedis getJedis(){
        try{
            jedis=new Jedis(redisValue.REDIS_IP.getData());
            jedis.auth(redisValue.REDIS_PASSWD.getData());
        }catch (Exception e){
            System.out.println(redisValue.REDIS_ERROR.getData());
        }
        return jedis;
    }
}
