package com.zjut.sys.dao;

import com.zjut.sys.dto.CpuDto;
import sun.plugin2.gluegen.runtime.CPU;

import java.util.List;

/**
 * Created by thRShy on 2017/5/19.
 */
public interface getCpuData {
    public List<CpuDto> get1DaysCpu(String ip);

    public List<CpuDto> get15MinCpu(String ip);

    public CpuDto get1Cpu(String ip);
}
