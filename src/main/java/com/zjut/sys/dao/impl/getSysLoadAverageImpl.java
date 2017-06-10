package com.zjut.sys.dao.impl;

import com.zjut.sys.dao.getSysLoadAverage;
import com.zjut.sys.dto.SysLoadAverageDto;

import java.util.ArrayList;
import java.util.List;

import static com.zjut.sys.utils.getInfoFromData.getSysLoadFromData;

/**
 * 系统负载
 * Created by thRShy on 2017/6/7.
 */
public class getSysLoadAverageImpl  implements getSysLoadAverage {

    private static getDataImpl getData=new getDataImpl();
    List<SysLoadAverageDto> loadAverageDtos;
    SysLoadAverageDto averageDto;
    List<String> data=null;

    public List<SysLoadAverageDto> get15minutesSysLoad(String ip) {
        loadAverageDtos=new ArrayList<SysLoadAverageDto>();
        data=getData.get15Minutes(ip);
        for(String s:data){
            averageDto=getSysLoadFromData(s);
            loadAverageDtos.add(averageDto);
        }
        return loadAverageDtos;
    }

    public List<SysLoadAverageDto> getOneDaySysLoad(String ip) {
        loadAverageDtos=new ArrayList<SysLoadAverageDto>(144);
        data=getData.getOneDayData(ip);
        for(String s:data){
            averageDto=getSysLoadFromData(s);
            loadAverageDtos.add(averageDto);
        }
        return loadAverageDtos;
    }

    public SysLoadAverageDto getSysLoad(String ip) {
        getData=new getDataImpl();
        SysLoadAverageDto averageDto;
        String da=getData.get1Data(ip);
        averageDto=getSysLoadFromData(da);
        return averageDto;
    }
}
