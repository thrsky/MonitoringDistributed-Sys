package com.zjut.sys.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by xjy on 2017/6/4.
 */
@Slf4j
public class TimerListener implements ServletContextListener {

    Timer timer=null;

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        log.info("========timer run=======");
        timer = new Timer();
        timer.executeTimer();
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
