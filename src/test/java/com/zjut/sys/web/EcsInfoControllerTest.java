package com.zjut.sys.web;

import com.zjut.sys.pojo.Ecs;
import com.zjut.sys.service.impl.EcsInfoServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by thRShy on 2017/5/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
public class EcsInfoControllerTest {

    private EcsInfoServiceImpl service;
    @Test
    public void getInfo() throws Exception {
        Ecs ecs=new Ecs();
        ecs = service.getEscInfo("192.168.1.1");
        System.out.println(ecs);
    }

}