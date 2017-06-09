package com.zjut.sys.dao;

import com.zjut.sys.pojo.Ecs;

import java.util.List;

public interface EcsMapper {
    int deleteByPrimaryKey(String ip);

    int insert(Ecs record);

    int insertSelective(Ecs record);

    Ecs selectByPrimaryKey(String ip);

    int updateByPrimaryKeySelective(Ecs record);

    int updateByPrimaryKey(Ecs record);

    List<Ecs> findAllEcs();
}