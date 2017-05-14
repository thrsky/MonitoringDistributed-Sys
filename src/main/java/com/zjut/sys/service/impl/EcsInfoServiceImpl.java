package com.zjut.sys.service.impl;

import com.zjut.sys.dao.EcsInfoMapper;
import com.zjut.sys.dao.EcsMapper;
import com.zjut.sys.pojo.Ecs;
import com.zjut.sys.pojo.EcsInfo;
import com.zjut.sys.service.EcsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by thRShy on 2017/5/6.
 */

@Service
public class EcsInfoServiceImpl implements EcsInfoService {

    @Autowired
    private EcsInfoMapper ecsInfoMapper;

    public EcsInfo getEscInfo(String ip) {
        return ecsInfoMapper.selectEcsInfoByIp(ip);
    }
}
