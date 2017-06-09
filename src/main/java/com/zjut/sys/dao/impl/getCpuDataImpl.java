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
        List<String> data=getData.getOneDayData(ip);
        List<CpuDto> res=new ArrayList<CpuDto>(144);
        CpuDto cpuDto=null;
        for(String da:data){
            cpuDto=getInfoFromData.getCpuFromData(da);
            res.add(cpuDto);
        }
        return res;
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
        for(String da:data){
            cpuDto=getInfoFromData.getCpuFromData(da);
            res.add(cpuDto);
        }
        return res;
    }

    public CpuDto get1Cpu(String ip) {
        String data=getData.get1Data(ip);
        CpuDto cpuDto=null;
        cpuDto=getInfoFromData.getCpuFromData(data);
        return cpuDto;
    }

}
