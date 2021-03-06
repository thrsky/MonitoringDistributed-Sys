package com.zjut.sys.dao.impl;

import com.zjut.sys.dao.getMemory;
import com.zjut.sys.dto.MemoryDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static com.zjut.sys.utils.getInfoFromData.getMemFromData;

/**
 * 获取内存相关数据
 * Created by thRShy on 2017/6/7.
 */
public class getMemoryImpl implements getMemory {

    @Autowired
    private getDataImpl getData;

    public List<MemoryDto> get15MinMen(String ip) {
        getData=new getDataImpl();
        List<String> data=getData.get15Minutes(ip);
        List<MemoryDto> res=new ArrayList<MemoryDto>();
        MemoryDto memoryDto;
        for(int i=0;i<data.size();i++){
            memoryDto=getMemFromData(data.get(i));
            res.add(memoryDto);
        }
        return res;
    }

    public List<MemoryDto> get1Day(String ip) {
        getData=new getDataImpl();
        List<String> data=getData.getOneDayData(ip);
        List<MemoryDto> res=new ArrayList<MemoryDto>(144);
        MemoryDto memoryDto;
        for(String da:data){
            memoryDto=getMemFromData(da);
            res.add(memoryDto);
        }
        return res;
    }

    public MemoryDto getMemory(String ip) {
        getData=new getDataImpl();
        MemoryDto memoryDto=null;
        String da=getData.get1Data(ip);
        memoryDto=getMemFromData(da);
        return memoryDto;
    }
}
