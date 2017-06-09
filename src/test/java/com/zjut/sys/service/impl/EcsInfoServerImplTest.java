package com.zjut.sys.service.impl;

import com.zjut.sys.pojo.Ecs;
import com.zjut.sys.service.EcsInfoServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by thRShy on 2017/6/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
public class EcsInfoServerImplTest {

    @Autowired
    private EcsInfoServer ecsInfoServer;
    @Test
    public void getEcsList() throws Exception {

        List<Ecs> res=ecsInfoServer.getEcsList();
        for(Ecs e:res)
            System.out.println(e);
    }

}