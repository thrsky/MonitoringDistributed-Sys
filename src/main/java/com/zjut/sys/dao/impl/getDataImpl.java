package com.zjut.sys.dao.impl;

import com.zjut.sys.dao.getData;
import com.zjut.sys.enums.redisValue;
import com.zjut.sys.utils.redisUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by thRShy on 2017/6/6.
 */
@Slf4j
public class getDataImpl implements getData {

    private Logger logger= LoggerFactory.getLogger(this.getClass());
    private Jedis jedis;
    public List<String > get15Minutes(String ip) {
        try{
            jedis= redisUtil.getJedis();
        }catch (Exception e){
            logger.error(redisValue.REDIS_ERROR.getData());
        }
        List<String> res= jedis.lrange(ip,0,255);
        return res;
    }

    /**
     *  获取一天时间内的服务器数据 - 可运行
     * @param ip
     * @return
     */
    public List<String> getOneDayData(String ip) {
        try{
            jedis= redisUtil.getJedis();
        }catch (Exception e){
            logger.error(redisValue.REDIS_ERROR.getData());
        }
        List<String> data = new ArrayList<String>(1440);

        log.info("redis s={}",new Date());
        data=jedis.lrange(ip,0,60*24);
        log.info("redis e={}",new Date());
        return data;
    }

    public String get1Data(String ip) {
        try{
            jedis=redisUtil.getJedis();
        }catch (Exception e){
            logger.error(redisValue.REDIS_ERROR.getData());
        }
        String data=jedis.lindex(ip,0);
        return data;
    }


    public static void main(String[] args) {
        String ip="115.159.206.169";
        getDataImpl getData=new getDataImpl();
        List<String> res=getData.getOneDayData(ip);
        System.out.println(res.size());
        for(String r:res){
            System.out.println(r);
        }
    }
}
