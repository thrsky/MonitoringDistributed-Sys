package com.zjut.sys.util;

import com.zjut.sys.service.MessageCenterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xjy on 2017/6/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
public class EmailTest {
    @Autowired
    private MessageCenterService messageCenterService;
    @Test
    public void sendMail() throws Exception {
//        messageCenterService.sendEmail();
    }

}