package com.zjut.sys.dao;

import com.zjut.sys.pojo.WarnMessage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xjy on 2017/6/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)//配置spring和junit整合，让junit启动时加载springIOC容器
@ContextConfiguration({"classpath:spring/spring-dao.xml"})//告诉ju
public class WarnMessageMapperTest {
    @Autowired
    WarnMessageMapper warnMessageMapper;

    @Test
    public void create() {
        WarnMessage warnMessage = new WarnMessage();
        warnMessage.setTitle("test");
        warnMessage.setWarnline(0.97);
        warnMessage.setType(WarnMessage.TYPE.larger.value());

        warnMessageMapper.create(warnMessage);
    }

    @Test
    public void findById() {
        Assert.assertNotNull(warnMessageMapper.findById(1L));
        Assert.assertNull(warnMessageMapper.findById(-1L));
    }

    @Test
    public void  update(){
        WarnMessage warnMessage = warnMessageMapper.findById(1L);
        warnMessage.setWarnline(0.02);
        warnMessage.setTitle("hello");
        Assert.assertTrue(warnMessageMapper.update(warnMessage));
        Assert.assertEquals(warnMessageMapper.findById(1L).getWarnline(),warnMessage.getWarnline(),1);
    }

    @Test
    public void delete(){
        WarnMessage warnMessage = new WarnMessage();
        warnMessage.setTitle("hhh");
        long id = warnMessageMapper.create(warnMessage);
        Assert.assertNotNull(warnMessageMapper.findById(id));
        Assert.assertTrue(warnMessageMapper.delete(id));
        Assert.assertNull(warnMessageMapper.findById(id));
    }
}