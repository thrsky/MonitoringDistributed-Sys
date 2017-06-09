package com.zjut.sys.util;

import com.zjut.sys.pojo.WarnMessage;
import com.zjut.sys.service.MessageCenterService;
import com.zjut.sys.service.impl.MessageCenterServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by xjy on 2017/6/4.
 */
@Slf4j
@Service
public class Timer {
    private ScheduledExecutorService scheduler = Executors
            .newScheduledThreadPool(1);

    public void executeTimer() {
        Runnable task = new Runnable() {
            public void run() {
                //具体操作
                log.info("Timer[][][]executeTimer[][][]timer is run");

            }
        };
        if (scheduler.isShutdown()) {
            scheduler = Executors.newScheduledThreadPool(1);
        }
        scheduler.scheduleAtFixedRate(task, 10, 30, TimeUnit.SECONDS);
    }

    public void stop(){
        scheduler.shutdown();
    }

}
