package com.zjut.sys.dao;

import com.zjut.sys.pojo.EcsDetail;

public interface EcsDetailMapper {
    int deleteByPrimaryKey(String ip);

    int insert(EcsDetail record);

    int insertSelective(EcsDetail record);

    EcsDetail selectByPrimaryKey(String ip);

    int updateByPrimaryKeySelective(EcsDetail record);

    int updateByPrimaryKey(EcsDetail record);
}