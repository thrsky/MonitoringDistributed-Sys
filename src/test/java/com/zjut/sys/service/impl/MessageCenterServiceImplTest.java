package com.zjut.sys.service.impl;

import com.zjut.sys.pojo.WarnMessage;
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
public class MessageCenterServiceImplTest {

    @Autowired
    private MessageCenterServiceImpl messageCenterService;

    @Test
    public void create() throws Exception {
        WarnMessage message=new WarnMessage();
        message.setEmail("1491474343@qq.com");
        message.setIp("121.42.14.159");
        message.setWarnLine(0.01);
        message.setType(1);
        System.out.println(messageCenterService.create(message));
    }

    @Test
    public void shouldSendEmail() throws Exception {
        List<WarnMessage> res=messageCenterService.shouldSendEmail();
        System.out.println(res.size());
        for(WarnMessage message:res)
            System.out.println(message);
    }

}