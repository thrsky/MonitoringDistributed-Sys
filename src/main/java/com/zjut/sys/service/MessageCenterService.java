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

    boolean stopWarmMessage(long id);

    boolean startwarnMessage(long id);
    long create(WarnMessage warnMessage);

    /**
     * 对所有ip进行轮询，查看是否超额
     * @return 超额的服务器详情
     */
    List<WarnMessage> shouldSendEmail();

    /**
     * 对报警的服务器发送信息
     */
    void sendEmail();

}
