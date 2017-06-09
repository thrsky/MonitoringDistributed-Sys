package com.zjut.sys.dao;

import com.zjut.sys.pojo.WarnMessage;

import java.util.List;

public interface WarnMessageMapper {
    int insert(WarnMessage record);

    int insertSelective(WarnMessage record);

    long create(WarnMessage message);

    List<WarnMessage> getAll();

    WarnMessage findById(long id);

    WarnMessage findByIp(String ip);

    boolean update(WarnMessage warnMessage);

    boolean delete(long id);

    boolean stopMessage(long id);
}