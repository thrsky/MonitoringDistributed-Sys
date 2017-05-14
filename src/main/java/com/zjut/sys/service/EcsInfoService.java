package com.zjut.sys.service;

import com.zjut.sys.pojo.EcsInfo;

/**
 * Created by thRShy on 2017/5/6.
 */
public interface EcsInfoService {

    public EcsInfo getEscInfo(String ip);

    /**
     * 运行状态
     * @param ip
     * @return true:运行中;false:未运行
     */
    public Boolean getEscStatus(String ip);

}
