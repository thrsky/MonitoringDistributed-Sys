package com.zjut.sys.web;

import com.zjut.sys.dto.CpuDto;
import com.zjut.sys.pojo.EcsInfo;
import com.zjut.sys.service.impl.EcsInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public EcsInfo getInfo(@PathVariable("ip") String ip, Model model) {
        EcsInfo ecsInfo = ecsInfoService.getEscInfo(ip);
        return ecsInfo;
    }

    /**
     * @param ip
     * @param model
     * @return
     */
    @GetMapping(value = "{ip}/{type}/info/{timetype}/{num}")
    @ResponseBody
    public List<CpuDto> getData(@PathVariable("ip") String ip,
                                @PathVariable("type") String type,
                                @PathVariable("timetype") String timetype,
                                @PathVariable("num") String num,
                                Model model) {
        List<CpuDto> list = new ArrayList<CpuDto>();
        CpuDto cpuDto = new CpuDto();
        cpuDto.setTime(new Date());
        cpuDto.setUsage(0.95);
        list.add(cpuDto);
        return list;
    }
}
