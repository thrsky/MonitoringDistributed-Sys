package com.zjut.sys.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thRShy on 2017/6/6.
 */
public class getInfoFromData {

    public static double getCpuFromData(String data){
        String expr="cpuUsedRate=(.*?),";
        double res=0.0;
        Pattern pattern=Pattern.compile(expr);
        Matcher matcher=pattern.matcher(data);
        if(matcher.find()){
            res=Double.parseDouble(matcher.group(1));
        }
        return res;

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

    public static void main(String[] args) {
        String data="MonitorData{SystemLoadAverage=0.2, ip='115.159.206.169', osName='Linux', memTotal=0.97, memUsed=0.9, cpuUsedRate=0.02, diskCapacityTotal=19, diskCapacityUsed=10, diskRead_kbps=0, diskWrite_kbps=0, netReceive_kbps=21, netSend_kbps=17, date=2017-06-06 18:46:17.122}";
        double a=getCpuFromData(data);
        System.out.println(a);

    }
}
