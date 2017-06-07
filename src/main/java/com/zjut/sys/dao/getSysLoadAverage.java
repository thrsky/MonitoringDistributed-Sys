package com.zjut.sys.dao;

import com.zjut.sys.dto.SysLoadAverageDto;

import java.util.List;

/**
 * 获取系统平均负载
 * Created by thRShy on 2017/6/7.
 */
public interface getSysLoadAverage {
    public List<SysLoadAverageDto> get15minutesSysLoad(String ip);
    public List<SysLoadAverageDto> getOneDaySysLoad(String ip);
}
