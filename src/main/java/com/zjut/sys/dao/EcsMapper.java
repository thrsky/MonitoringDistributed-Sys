package com.zjut.sys.dao;

import com.zjut.sys.pojo.Ecs;

public interface EcsMapper {
    int deleteByPrimaryKey(String ecsIp);

    int insert(Ecs record);

    int insertSelective(Ecs record);

    Ecs selectByPrimaryKey(String ecsIp);

    int updateByPrimaryKeySelective(Ecs record);

    int updateByPrimaryKey(Ecs record);
}