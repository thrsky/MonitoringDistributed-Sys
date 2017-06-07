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
        List<String> data=getData.get15Minutes(ip);
        List<MemoryDto> res=new ArrayList<MemoryDto>();
        MemoryDto memoryDto;
        for(int i=0;i<data.size();i++){
            memoryDto=new MemoryDto();
            memoryDto=getMemFromData(data.get(i));
            res.add(memoryDto);
        }
        return res;
    }

    public List<MemoryDto> get1Day(String ip) {
        return null;
    }
}
