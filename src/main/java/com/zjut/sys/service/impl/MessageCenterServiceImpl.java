package com.zjut.sys.service.impl;

import com.zjut.sys.dao.WarnMessageMapper;
import com.zjut.sys.pojo.WarnMessage;
import com.zjut.sys.service.MessageCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xjy on 2017/6/3.
 */
@Service
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
}
