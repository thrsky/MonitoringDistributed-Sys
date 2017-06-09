package com.zjut.sys.service;

import com.zjut.sys.pojo.Ecs;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by thRShy on 2017/6/9.
 */
@Service
public interface EcsInfoServer {
    public List<Ecs> getEcsList();
    public Ecs getEscInfo(String ip);
}
