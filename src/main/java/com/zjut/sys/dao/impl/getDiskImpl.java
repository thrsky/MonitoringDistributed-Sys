package com.zjut.sys.dao.impl;

import com.zjut.sys.dao.getDisk;
import com.zjut.sys.dto.DiskReadDto;
import com.zjut.sys.dto.DiskWriteDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static com.zjut.sys.utils.getInfoFromData.getDiskReadFromData;
import static com.zjut.sys.utils.getInfoFromData.getDiskWriteFromData;

/**
 * Created by thRShy on 2017/6/7.
 */
public class getDiskImpl implements getDisk {

    @Autowired
    private getDataImpl getData;
    List<String> data=null;
    List<DiskReadDto> diskReadDtos;
    List<DiskWriteDto> diskWriteDtos;
    DiskWriteDto writeDto;
    DiskReadDto readDto;
    public List<DiskWriteDto> get15minuteDiskWrite(String ip) {
        getData=new getDataImpl();
        diskWriteDtos=new ArrayList<DiskWriteDto>(15);
        data=getData.get15Minutes(ip);
        for(String da:data){
            writeDto=getDiskWriteFromData(da);
            diskWriteDtos.add(writeDto);
        }
        return diskWriteDtos;
    }

    public List<DiskReadDto> get15minuteDiskRead(String ip) {
        getData=new getDataImpl();
        diskReadDtos=new ArrayList<DiskReadDto>(15);
        data=getData.get15Minutes(ip);
        for(String da:data){
            readDto=getDiskReadFromData(da);
            diskReadDtos.add(readDto);
        }
        return diskReadDtos;
    }

    public DiskReadDto getDiskRead(String ip) {
        getData=new getDataImpl();
        DiskReadDto readDto=null;
        String da=getData.get1Data(ip);
        readDto=getDiskReadFromData(da);
        return readDto;
    }

    public List<DiskWriteDto> getOneDayDiskWrite(String ip) {
        getData=new getDataImpl();
        diskWriteDtos=new ArrayList<DiskWriteDto>(144);
        getData=new getDataImpl();
        data=getData.getOneDayData(ip);
        for(String s:data){
            writeDto=getDiskWriteFromData(s);
            diskWriteDtos.add(writeDto);
        }
        return diskWriteDtos;
    }

    public List<DiskReadDto> getOneDayDiskRead(String ip) {
        getData=new getDataImpl();
        diskReadDtos=new ArrayList<DiskReadDto>(144);
        getData=new getDataImpl();
        data=getData.getOneDayData(ip);
        for(String s:data){
            readDto=getDiskReadFromData(s);
            diskReadDtos.add(readDto);
        }
        return diskReadDtos;
    }

    public DiskWriteDto getDiskWrite(String ip) {
        getData=new getDataImpl();
        DiskWriteDto writeDto=null;
        String da=getData.get1Data(ip);
        writeDto=getDiskWriteFromData(da);
        return writeDto;
    }
}
