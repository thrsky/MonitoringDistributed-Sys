package com.zjut.sys.dao;

import com.zjut.sys.pojo.WarnMessage;

import java.util.List;

/**
 * Created by xjy on 2017/6/3.
 */
public interface WarnMessageMapper {
    long create(WarnMessage warnMessage);

    WarnMessage findById(long id);

    List<WarnMessage> getAll();

    boolean update(WarnMessage warnMessage);

    boolean delete(long id);
}
