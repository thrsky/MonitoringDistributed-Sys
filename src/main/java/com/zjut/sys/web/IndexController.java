package com.zjut.sys.web;

import com.zjut.sys.dto.EcsBriefDto;
import com.zjut.sys.pojo.Ecs;
import com.zjut.sys.pojo.WarnMessage;
import com.zjut.sys.service.EcsInfoServer;
import com.zjut.sys.service.MessageCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by thRShy on 2017/5/14.
 */

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    MessageCenterService messageCenterService;
    @Autowired
    EcsInfoServer ecsInfoServer;

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(Model model){
        return "index";
    }

    @RequestMapping(value = "charts/",method = RequestMethod.GET)
    public String charts(Model model){
        return "charts";
    }

    /**
     * 显示单个服务器的信息
     * @param ip
     * @param model
     * @return
     */
    @RequestMapping(value = "{ip}/info",method = RequestMethod.GET)
    public String serverInfo(@PathVariable("ip")String ip, Model model){
        Ecs ecsBriefDto = ecsInfoServer.getEscInfo(ip);
        model.addAttribute("server",ecsBriefDto);
        return "info";
    }

    /**
     * 显示服务器列表
     * @param model
     * @return
     */
    @RequestMapping(value = "serverList",method = RequestMethod.GET)
    public String serverList(Model model){
        List<Ecs> serverList=ecsInfoServer.getEcsList();
        model.addAttribute("serverList",serverList);
        return "serverList";
    }

    @RequestMapping(value = "messageCenter",method = RequestMethod.GET)
    public String messageCenter(Model model){
        List<WarnMessage> warnMessageList = messageCenterService.getWarnMessages();
        model.addAttribute("list",warnMessageList);
        List<Ecs> serverList=ecsInfoServer.getEcsList();
        model.addAttribute("serverList",serverList);

        return "messageCenter";
    }

}
