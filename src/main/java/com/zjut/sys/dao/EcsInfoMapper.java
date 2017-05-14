package com.zjut.sys.dao;

import com.zjut.sys.pojo.EcsInfo;

public interface EcsInfoMapper {
    int insert(EcsInfo record);

    int insertSelective(EcsInfo record);
}