package com.zjut.sys.dao.impl;

import com.zjut.sys.dao.getSysLoadAverage;
import com.zjut.sys.dto.SysLoadAverageDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.zjut.sys.utils.getInfoFromData.getSysLoadFromData;

/**
 * 系统负载
 * Created by thRShy on 2017/6/7.
 */
public class getSysLoadAverageImpl  implements getSysLoadAverage {

    @Autowired
    private getDataImpl getData;
    List<SysLoadAverageDto> loadAverageDtos;
    SysLoadAverageDto averageDto;
    List<String> data=null;

    public List<SysLoadAverageDto> get15minutesSysLoad(String ip) {
        data=getData.get15Minutes(ip);
        for(String s:data){
            averageDto=getSysLoadFromData(ip);
            loadAverageDtos.add(averageDto);
        }
        return loadAverageDtos;
    }

    public List<SysLoadAverageDto> getOneDaySysLoad(String ip) {
        data=getData.getOneDayData(ip);
        for(String s:data){
            averageDto=getSysLoadFromData(ip);
            loadAverageDtos.add(averageDto);
        }
        return loadAverageDtos;
    }
}
