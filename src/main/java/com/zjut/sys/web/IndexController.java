package com.zjut.sys.web;

import com.zjut.sys.dto.EcsBriefDto;
import com.zjut.sys.pojo.WarnMessage;
import com.zjut.sys.service.MessageCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thRShy on 2017/5/14.
 */

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    MessageCenterService messageCenterService;

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
        EcsBriefDto ecsBriefDto = new EcsBriefDto();
        ecsBriefDto.setCpu("1Ghz");
        ecsBriefDto.setDisk("500G");
        ecsBriefDto.setIp("127.0.0.1");
        ecsBriefDto.setMemory("1G");
        ecsBriefDto.setName("test");
        ecsBriefDto.setStatus("running");
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

        List<EcsBriefDto> list = new ArrayList<EcsBriefDto>();
        for(int i=0;i<10;i++){
            EcsBriefDto ecsBriefDto = new EcsBriefDto();
            ecsBriefDto.setCpu("1Ghz");
            ecsBriefDto.setDisk("500G");
            ecsBriefDto.setIp("127.0.0.1");
            ecsBriefDto.setMemory("1G");
            ecsBriefDto.setName("test");
            ecsBriefDto.setStatus("running");
            list.add(ecsBriefDto);
        }
        model.addAttribute("list",list);
        return "serverList";
    }

    @RequestMapping(value = "messageCenter",method = RequestMethod.GET)
    public String messageCenter(Model model){
        List<WarnMessage> warnMessageList = messageCenterService.getWarnMessages();
        model.addAttribute(warnMessageList);
        return "messageCenter";
    }

}
