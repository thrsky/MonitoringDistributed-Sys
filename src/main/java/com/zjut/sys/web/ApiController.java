package com.zjut.sys.web;

import com.zjut.sys.dto.CpuDto;
import com.zjut.sys.dto.DiskDto;
import com.zjut.sys.dto.MemoryDto;
import com.zjut.sys.pojo.EcsInfo;
import com.zjut.sys.pojo.WarnMessage;
import com.zjut.sys.service.MessageCenterService;
import com.zjut.sys.service.impl.EcsInfoServiceImpl;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RequestMapping("/api")
public class ApiController {


    @Autowired
    private EcsInfoServiceImpl ecsInfoService;
    @Autowired
    private MessageCenterService messageCenterService;

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
    @GetMapping(value = "{ip}/{type}/info/{num}/{timetype}")
    @ResponseBody
    public List<CpuDto> getData(@PathVariable("ip") String ip,
                                @PathVariable("type") String type,
                                @PathVariable("timetype") String timetype,
                                @PathVariable("num") String num,
                                Model model) {

        List<CpuDto> list = new ArrayList<CpuDto>();
        for (int i = 0; i < 1; i++) {
            CpuDto cpuDto = new CpuDto();
            cpuDto.setTime(new Date());
            cpuDto.setUsage(0.1 + Math.random() / 20);
            list.add(cpuDto);
        }
        return list;
    }

    @GetMapping(value = "{ip}/cpu/info/{num}/{timetype}")
    @ResponseBody
    public List<CpuDto> getCpuData(@PathVariable("ip") String ip,
                                   @PathVariable("num") String num,
                                   @PathVariable("timetype") String timetype
    ) {
        return null;
    }

    @GetMapping(value = "{ip}/memory/info/{num}/{timetype}")
    @ResponseBody
    public List<MemoryDto> getMemoryData(@PathVariable("ip") String ip,
                                         @PathVariable("num") String num,
                                         @PathVariable("timetype") String timetype
    ) {
        return null;
    }

    @GetMapping(value = "{ip}/disk/info/{num}/{timetype}")
    @ResponseBody
    public List<DiskDto> getDiskData(@PathVariable("ip") String ip,
                                     @PathVariable("num") String num,
                                     @PathVariable("timetype") String timetype
    ) {
        return null;
    }

    @GetMapping(value = "warnMessage/{id}")
    @ResponseBody
    public WarnMessage getWarnMessageById(@PathVariable("id") long id) {
        return messageCenterService.findById(id);
    }

    @GetMapping(value = "warnMessage/update")
    public void updateWarnMessage(WarnMessage warnMessage) {
        log.info("warnMessage={}",warnMessage);
//        return ""
    }
}
