package com.zjut.sys.service.impl;

import com.zjut.sys.dao.EcsMapper;
import com.zjut.sys.pojo.Ecs;
import com.zjut.sys.service.EcsInfoServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by thRShy on 2017/6/9.
 */
@Service
public class EcsInfoServerImpl implements EcsInfoServer {

    @Autowired
    private EcsMapper ecsMapper;

    public List<Ecs> getEcsList() {
        List<Ecs> res=ecsMapper.findAllEcs();
        return res;
    }

    public Ecs getEscInfo(String ip) {
        return ecsMapper.selectByPrimaryKey(ip);
    }
}
