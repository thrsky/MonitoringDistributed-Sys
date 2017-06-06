package com.zjut.sys.dao.impl;

import com.zjut.sys.dao.getCpuData;
import com.zjut.sys.dto.CpuDto;
import com.zjut.sys.utils.getInfoFromData;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thRShy on 2017/5/19.
 */
public class getCpuDataImpl implements getCpuData {

    @Autowired
    private getDataImpl getData=new getDataImpl();

    public List<CpuDto> get1DaysCpu(String ip) {
        //TODO
        return null;
    }

    /**
     * 从目前往前的15分钟的数据，返回的列表中，第0个为前一分钟，第1个为前2分钟.....
     * @param ip
     * @return
     */
    public List<CpuDto> get15MinCpu(String ip) {
        List<String> data= getData.get15Minutes(ip);
        List<CpuDto> res = new ArrayList<CpuDto>(15);
        CpuDto cpuDto=null;
        for(int i=0;i<data.size();i++){
            cpuDto=new CpuDto();
            cpuDto.setUsage(getInfoFromData.getCpuFromData(data.get(i)));
            cpuDto.setTime(getInfoFromData.getDateFromData(data.get(i)));
            res.add(cpuDto);
//            res[i]=cpuDto;
        }
        return res;
    }


}
