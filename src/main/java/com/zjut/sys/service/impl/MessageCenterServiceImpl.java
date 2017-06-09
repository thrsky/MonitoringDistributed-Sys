package com.zjut.sys.service.impl;

import com.zjut.sys.dao.WarnMessageMapper;
import com.zjut.sys.pojo.WarnMessage;
import com.zjut.sys.service.MessageCenterService;
import com.zjut.sys.util.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xjy on 2017/6/3.
 */
@Service
@Slf4j
public class MessageCenterServiceImpl implements MessageCenterService {
    @Autowired
    WarnMessageMapper warnMessageMapper;

    public boolean sendEmail(String email, String msg) {
        return false;
    }

    public boolean sendSms(String phone, String msg) {
        return false;
    }

    public List<WarnMessage> getWarnMessages() {
        return warnMessageMapper.getAll();
    }

    public WarnMessage findById(long id) {
        WarnMessage warnMessage = warnMessageMapper.findById(id);
        return warnMessage;
    }

    public boolean updateWarnMessage(WarnMessage warnMessage) {
        return warnMessageMapper.update(warnMessage);
    }

    public boolean deleteWarnMessage(long id) {
        return warnMessageMapper.delete(id);
    }

    public long create(WarnMessage warnMessage) {
        return warnMessageMapper.create(warnMessage);
    }

    public List<WarnMessage> shouldSendEmail() {
        //拉下服务器列表
        //轮询服务器列表，判断有没有异常

        return null;
    }

    public void sendEmail() {
        try {
            MessageCenterService messageCenterService = new MessageCenterServiceImpl();
            List<WarnMessage> warnMessageList = messageCenterService.shouldSendEmail();
            for (WarnMessage warnMessage : warnMessageList) {
                String rece = warnMessage.getEmail();
                String title = warnMessage.getTitle();
                String content = "你的服务器"+ warnMessage.getItem() + "用量大于" + warnMessage.getWarnLine();
                Email.sendMail("15957180610@163.com", "15957180610@163.com", "xujunyu520",
                        rece,
                        title,
                        content);
            }
        } catch (Exception e) {
            log.error("send mail fail , cause={}", e.getMessage());
        }
    }
}
