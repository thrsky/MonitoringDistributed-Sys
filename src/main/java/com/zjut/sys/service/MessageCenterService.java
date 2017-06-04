package com.zjut.sys.service;

import com.zjut.sys.pojo.WarnMessage;

import java.util.List;

/**
 * 消息中心
 * Created by xjy on 2017/5/15.
 */
public interface MessageCenterService {
    public boolean sendEmail(String email, String msg);

    public boolean sendSms(String phone, String msg);

    public List<WarnMessage> getWarnMessages();

    public WarnMessage findById(long id);

}
