package com.zjut.sys.web;

import com.zjut.sys.pojo.Ecs;
import com.zjut.sys.service.impl.EcsInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by thRShy on 2017/5/6.
 */
@Controller
@RequestMapping("/api")
public class ApiController {


    @Autowired
    private EcsInfoServiceImpl ecsInfoService;

    @GetMapping(value = "/{ip}/info")
    @ResponseBody
    public String getInfo(@PathVariable("ip") String ip, Model model){
        Ecs ecs=ecsInfoService.getEscInfo(ip);
        model.addAttribute("info",ecs);
        return "info";
    }
}
