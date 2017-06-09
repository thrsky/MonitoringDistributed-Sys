package com.zjut.sys.utils;

import com.zjut.sys.dto.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thRShy on 2017/6/6.
 */
public class getInfoFromData {

    /**
     * 从数据中提取出CPU的相关信息
     * @param data
     * @return
     */
    public static CpuDto getCpuFromData(String data){
        String expr="cpuUsedRate=(.*?),";
        Pattern pattern=Pattern.compile(expr);
        Matcher matcher=pattern.matcher(data);
        CpuDto cpuDto=new CpuDto();
        if(matcher.find()){
            cpuDto.setUsage(Double.parseDouble(matcher.group(1)));
            cpuDto.setTime(getDateFromData(data));
        }
        return cpuDto;

    }

    public static Date getDateFromData(String data){
        Date res=null;
        String expr="date=(.*?)}";
        Pattern pattern=Pattern.compile(expr);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Matcher matcher=pattern.matcher(data);
        if(matcher.find()){
            String ma=matcher.group(1);
            try {
                res=formatter.parse(ma);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return res;

    }

    public static MemoryDto getMemFromData(String data){
        MemoryDto memoryDto=new MemoryDto();
        String expr="memTotal=(.*?), memUsed=(.*?),";
        Pattern pattern=Pattern.compile(expr);
        Matcher matcher=pattern.matcher(data);
        if(matcher.find()){
            memoryDto.setMenToal(Double.parseDouble(matcher.group(1)));
            memoryDto.setMenUsed(Double.parseDouble(matcher.group(2)));
            memoryDto.setRate(memoryDto.getMenUsed()/memoryDto.getMenToal());
            memoryDto.setDate(getDateFromData(data));
        }
        return memoryDto;
    }

    public static netInDto getNetInFromData(String data){
        netInDto netInDto=new netInDto();
        String expr="netReceive_kbps=(.*?),";
        Pattern pattern=Pattern.compile(expr);
        Matcher matcher=pattern.matcher(data);
        if(matcher.find()){
            netInDto.setNetIn(Double.parseDouble(matcher.group(1)));
            netInDto.setDate(getDateFromData(data));
        }
        return netInDto;
    }

    public static netOutDto getNetOutFromData(String data){
        netOutDto netOutDto=new netOutDto();
        String expr="netSend_kbps=(.*?),";
        Pattern pattern=Pattern.compile(expr);
        Matcher matcher=pattern.matcher(data);
        if(matcher.find()){
            netOutDto.setNetOut(Double.parseDouble(matcher.group(1)));
            netOutDto.setDate(getDateFromData(data));
        }
        return netOutDto;
    }

    public static DiskReadDto getDiskReadFromData(String data){
        DiskReadDto diskReadDto=new DiskReadDto();
        String expr="diskRead_kbps=(.*?),";
        Pattern pattern=Pattern.compile(expr);
        Matcher matcher=pattern.matcher(data);
        if(matcher.find()){
            diskReadDto.setRead(Double.parseDouble(matcher.group(1)));
            diskReadDto.setDate(getDateFromData(data));
        }
        return diskReadDto;
    }

    public static DiskWriteDto getDiskWriteFromData(String data){
        DiskWriteDto diskWriteDto=new DiskWriteDto();
        String expr="diskWrite_kbps=(.*?),";
        Pattern pattern=Pattern.compile(expr);
        Matcher matcher=pattern.matcher(data);
        if(matcher.find()){
            diskWriteDto.setWrite(Double.parseDouble(matcher.group(1)));
            diskWriteDto.setDate(getDateFromData(data));
        }
        return diskWriteDto;
    }

    public static SysLoadAverageDto getSysLoadFromData(String data){
        SysLoadAverageDto sysLoadAverageDto=new SysLoadAverageDto();
        String expr="SystemLoadAverage=(.*?),";
        Pattern pattern=Pattern.compile(expr);
        Matcher matcher=pattern.matcher(data);
        if(matcher.find()){
            sysLoadAverageDto.setLoad(Double.parseDouble(matcher.group(1)));
            sysLoadAverageDto.setDate(getDateFromData(data));
        }
        return sysLoadAverageDto;
    }


    public static void main(String[] args) {
        String data="MonitorData{SystemLoadAverage=0.2, ip='115.159.206.169', osName='Linux', memTotal=0.97, memUsed=0.9, cpuUsedRate=0.02, diskCapacityTotal=19, diskCapacityUsed=10, diskRead_kbps=0, diskWrite_kbps=0, netReceive_kbps=21, netSend_kbps=17, date=2017-06-06 18:46:17.122}";
        MemoryDto a=getMemFromData(data);
        System.out.println(a);

    }
}
