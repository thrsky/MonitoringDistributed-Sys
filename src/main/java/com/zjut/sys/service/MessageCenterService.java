package com.zjut.sys.service;

/**
 * 消息中心
 * Created by xjy on 2017/5/15.
 */
public interface MessageCenterService {
    public boolean sendEmail(String email,String msg);
    public boolean sendSms(String phone,String msg);
}
