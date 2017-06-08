package com.zjut.sys.dao.impl;

import com.zjut.sys.dao.getNet;
import com.zjut.sys.dto.netInDto;
import com.zjut.sys.dto.netOutDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import static com.zjut.sys.utils.getInfoFromData.getNetInFromData;
import static com.zjut.sys.utils.getInfoFromData.getNetOutFromData;


/**
 * Created by thRShy on 2017/6/7.
 */
public class getNetImpl implements getNet {

    @Autowired
    private getDataImpl getData;
    List<String> data;
    List<netInDto> inDtos;
    List<netOutDto> outDtos;
    public List<netInDto> get15MinuteNetIn(String ip) {
        getData=new getDataImpl();
        inDtos=new ArrayList<netInDto>(15);
        data=getData.get15Minutes(ip);
        netInDto netInDto=null;
        for(String da:data){
            netInDto=getNetInFromData(da);
            inDtos.add(netInDto);
        }
        return inDtos;
    }

    public List<netOutDto> get15MinuteNetOut(String ip) {
        getData=new getDataImpl();
        outDtos=new ArrayList<netOutDto>(15);
        data=getData.get15Minutes(ip);
        netOutDto netOutDto=null;
        for(String da:data){
            netOutDto=getNetOutFromData(da);
            outDtos.add(netOutDto);
        }
        return outDtos;
    }

    public List<netInDto> getOneDayNetIn(String ip) {
        inDtos=new ArrayList<netInDto>(144);
        getData=new getDataImpl();
        data=getData.getOneDayData(ip);
        netInDto netInDto=null;
        for(String da:data){
            netInDto=getNetInFromData(da);
            inDtos.add(netInDto);
        }
        return inDtos;
    }

    public List<netOutDto> getOneDayNetOut(String ip) {
        outDtos=new ArrayList<netOutDto>(144);
        getData=new getDataImpl();
        data=getData.getOneDayData(ip);
        netOutDto netOutDto=null;
        for(String da:data){
            netOutDto=getNetOutFromData(da);
            outDtos.add(netOutDto);
        }
        return outDtos;
    }
}
