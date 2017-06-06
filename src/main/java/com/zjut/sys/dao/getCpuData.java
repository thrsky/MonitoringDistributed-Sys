package com.zjut.sys.dao;

import com.zjut.sys.dto.CpuDto;

/**
 * Created by thRShy on 2017/5/19.
 */
public interface getCpuData {
    public CpuDto[] get1DaysCpu(String ip);

    public CpuDto[] get15MinCpu(String ip);
}
