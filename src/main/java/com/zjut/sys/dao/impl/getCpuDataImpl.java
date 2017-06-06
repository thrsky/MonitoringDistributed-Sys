package com.zjut.sys.dao.impl;

import com.zjut.sys.dao.getCpuData;
import com.zjut.sys.dto.CpuDto;
import com.zjut.sys.utils.getInfoFromData;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by thRShy on 2017/5/19.
 */
public class getCpuDataImpl implements getCpuData {

    @Autowired
    private getDataImpl getData=new getDataImpl();

    public CpuDto[] get1DaysCpu(String ip) {
        //TODO
        return null;
    }

    /**
     * 从目前往前的15分钟的数据，返回的列表中，第0个为前一分钟，第1个为前2分钟.....
     * @param ip
     * @return
     */
    public CpuDto[] get15MinCpu(String ip) {
        List<String> data= getData.get15Minutes(ip);
        CpuDto[] res=new CpuDto[15];
        CpuDto cpuDto=null;
        for(int i=0;i<15;i++){
            cpuDto=new CpuDto();
            cpuDto.setUsage(getInfoFromData.getCpuFromData(data.get(i)));
            cpuDto.setTime(getInfoFromData.getDateFromData(data.get(i)));
            res[i]=cpuDto;
        }
        return res;
    }

    public static void main(String[] args) {
        getCpuDataImpl getCpuData=new getCpuDataImpl();
        CpuDto[] res=getCpuData.get15MinCpu("115.159.206.169");
        System.out.println(res[3]);
        System.out.println(res[13]);
        System.out.println(res[14]);
    }

}
