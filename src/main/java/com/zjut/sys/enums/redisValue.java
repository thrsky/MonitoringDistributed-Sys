package com.zjut.sys.enums;

import static com.zjut.sys.utils.constantValue.redisIp;
import static com.zjut.sys.utils.constantValue.redisPasswd;
import static com.zjut.sys.utils.constantValue.redisPort;

/**
 * Created by thRShy on 2017/6/6.
 */
public enum redisValue{

    REDIS_IP(1,redisIp),
    REDIS_PORT(2,redisPort),
    REDIS_PASSWD(3,redisPasswd),
    REDIS_ERROR(-1,"连接redis失败"),
    REDIS_INPUT_ERROR(-2,"数据存储至redis失败"),
    REDIS_GET_ERROR(-3,"数据获取失败");
    private int state;
    private String data;

    redisValue(int state, String data) {
        this.state = state;
        this.data = data;
    }

    public int getState() {
        return state;
    }

    public String getData() {
        return data;
    }
}
