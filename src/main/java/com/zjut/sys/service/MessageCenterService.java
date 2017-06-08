package com.zjut.sys.service;

import com.zjut.sys.pojo.WarnMessage;

import java.util.List;

/**
 * 消息中心
 * Created by xjy on 2017/5/15.
 */
public interface MessageCenterService {
    boolean sendEmail(String email, String msg);

    boolean sendSms(String phone, String msg);

    List<WarnMessage> getWarnMessages();

    WarnMessage findById(long id);

    boolean updateWarnMessage(WarnMessage warnMessage);

    boolean deleteWarnMessage(long id);

    long create(WarnMessage warnMessage);

}
