package com.zjut.sys.service.impl;

import com.zjut.sys.dao.EcsMapper;
import com.zjut.sys.pojo.Ecs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by thRShy on 2017/5/6.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
                        "classpath:spring/spring-server.xml"})
public class EcsInfoServiceImplTest {

    @Autowired
    private EcsMapper ecsMapper;
    @Test
    public void getEscInfo() throws Exception {
        Ecs ecs=new Ecs();
        ecs=ecsMapper.selectByPrimaryKey("192.168.1.1");
        System.out.println(ecs);
    }

}