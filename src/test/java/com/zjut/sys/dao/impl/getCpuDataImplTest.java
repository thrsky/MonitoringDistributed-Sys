package com.zjut.sys.dao.impl;

import com.zjut.sys.dto.CpuDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by thRShy on 2017/6/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
public class getCpuDataImplTest {

    @Resource
    private getCpuDataImpl getCpuData;
    @Test
    public void get15MinCpu() throws Exception {
        CpuDto[] res=getCpuData.get15MinCpu("115.159.206.169");
        System.out.println(res);

    }

}