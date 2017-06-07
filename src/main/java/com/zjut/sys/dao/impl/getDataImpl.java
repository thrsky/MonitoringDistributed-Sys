package com.zjut.sys.dao.impl;

import com.zjut.sys.dao.getData;
import com.zjut.sys.enums.redisValue;
import com.zjut.sys.utils.redisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
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

    /**
     *  获取一天时间内的服务器数据 - 可运行
     * @param ip
     * @return
     */
    public List<String> getOneDayData(String ip) {
        List<String> res= new ArrayList<String>() ;
        try{
            jedis= redisUtil.getJedis();
        }catch (Exception e){
            logger.error(redisValue.REDIS_ERROR.getData());
        }
        String data;
        for(int i=0;i<24*60;i=i+10){
            data=jedis.lindex(ip,i);
            if(data!=null)
                res.add(data);
            else{
//                System.out.println("index is: "+i+" not found");
            }
        }
        return res;
    }

    public List<String> getSevenDayData(String ip) {
        return null;
    }

    public List<String> getHalfMonthData(String ip) {
        return null;
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
