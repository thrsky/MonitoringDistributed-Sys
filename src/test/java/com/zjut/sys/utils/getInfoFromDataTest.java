package com.zjut.sys.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by thRShy on 2017/6/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
public class getInfoFromDataTest {

    @Autowired
    private getInfoFromData getInfoFromData;

    @Test
    public void getCpuFromData() throws Exception {

        String data="MonitorData{SystemLoadAverage=0.2, ip='115.159.206.169', osName='Linux', memTotal=0.97, memUsed=0.9, cpuUsedRate=0.02, diskCapacityTotal=19, diskCapacityUsed=10, diskRead_kbps=0, diskWrite_kbps=0, netReceive_kbps=21, netSend_kbps=17, date=2017-06-06 18:46:17.122}";
        System.out.println(getInfoFromData.getCpuFromData(data));

    }


}