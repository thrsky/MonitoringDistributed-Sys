package com.zjut.sys.dao.impl;

import com.zjut.sys.dao.getData;
import com.zjut.sys.enums.redisValue;
import com.zjut.sys.utils.redisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by thRShy on 2017/6/6.
 */
public class getDataImpl implements getData {

    private Logger logger= LoggerFactory.getLogger(this.getClass());
    private Jedis jedis;
    public List<String > get15Minutes(String ip) {
        try{
            jedis= redisUtil.getJedis();
        }catch (Exception e){
            logger.error(redisValue.REDIS_ERROR.getData());
        }
        List<String> res= jedis.lrange(ip,0,14);
        return res;
    }

    public List<String> getOneDayData(String ip) {
        try{
            jedis= redisUtil.getJedis();
        }catch (Exception e){
            logger.error(redisValue.REDIS_ERROR.getData());
        }
        List<String> res=null;
        return res;
    }

    public List<String> getSevenDayData(String ip) {
        return null;
    }

    public List<String> getHalfMonthData(String ip) {
        return null;
    }

}
