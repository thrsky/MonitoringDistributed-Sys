package com.zjut.sys.service.impl;

import com.zjut.sys.pojo.WarnMessage;
import com.zjut.sys.service.MessageCenterService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xjy on 2017/6/3.
 */
@Service
public class MessageCenterServiceImpl implements MessageCenterService {
    public boolean sendEmail(String email, String msg) {
        return false;
    }

    public boolean sendSms(String phone, String msg) {
        return false;
    }

    public List<WarnMessage> getWarnMessages() {
        return new ArrayList<WarnMessage>();
    }

    public WarnMessage findById(long id) {
        WarnMessage warnMessage = new WarnMessage();
        warnMessage.setId(13);
        warnMessage.setStatus(true);
        warnMessage.setTitle("hello world");
        warnMessage.setType(WarnMessage.TYPE.larger.value());
        warnMessage.setWarnLine(0.89);
        return warnMessage;
    }
}
