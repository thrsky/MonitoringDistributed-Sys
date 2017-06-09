package com.zjut.sys.web;

import com.zjut.sys.dao.getCpuData;
import com.zjut.sys.dao.impl.*;
import com.zjut.sys.dto.*;
import com.zjut.sys.pojo.Ecs;
import com.zjut.sys.pojo.WarnMessage;
import com.zjut.sys.service.EcsInfoServer;
import com.zjut.sys.service.MessageCenterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    private MessageCenterService messageCenterService;
    @Autowired
    private EcsInfoServer ecsInfoServer;


    @GetMapping(value = "/{ip}/info")
    @ResponseBody
    public Ecs getInfo(@PathVariable("ip") String ip, Model model) {
        Ecs ecs = ecsInfoServer.getEscInfo(ip);
        return ecs;
    }

    /**
     *  系统负载 可用
     * @param ip
     * @param mode
     * @return
     */
    @GetMapping(value = "{ip}/sysLoad/info/{mode}")
    @ResponseBody
    public List<SysLoadAverageDto> getSysLoadAverage(@PathVariable("ip") String ip,
                                               @PathVariable("mode") String mode){
        List<SysLoadAverageDto> res=new ArrayList<SysLoadAverageDto>();
        getSysLoadAverageImpl getSysLoadAverage=new getSysLoadAverageImpl();
        if(mode.equals("2h")){
            res=getSysLoadAverage.get15minutesSysLoad(ip);
        }else if(mode.equals("1d")){
            res=getSysLoadAverage.getOneDaySysLoad(ip);
        }else if(mode.equals("1m")){
            res.add(getSysLoadAverage.getSysLoad(ip));
        }
        return res;
    }

    /**
     * CPU相关接口 可用
     * @param ip
     * @param mode
     * @return
     */
    @GetMapping(value = "/{ip}/cpu/info/{mode}")
    @ResponseBody
    public List<CpuDto> getCpuData(@PathVariable("ip") String ip,
                                   @PathVariable("mode") String mode){
        List<CpuDto> res = new ArrayList<CpuDto>();
        getCpuData getCpuData=new getCpuDataImpl();
        log.info("cpu mvc s={}",new Date());
        if(mode.equals("2h")){
            res=getCpuData.get15MinCpu(ip);
        }else if(mode.equals("1d")){
            res=getCpuData.get1DaysCpu(ip);
        }else if(mode.equals("1m")){
            res.add(getCpuData.get1Cpu(ip));
        }
        log.info("cpu mvc e={}",new Date());
        return res;
    }


    /**
     * 内存 - 可用
     * @param ip
     * @param mode
     * @return
     */
    @GetMapping(value = "/{ip}/memory/info/{mode}")
    @ResponseBody
    public List<MemoryDto> getMemoryData(@PathVariable("ip") String ip,
                                         @PathVariable("mode") String mode
    ) {
        List<MemoryDto> res=new ArrayList<MemoryDto>();
        getMemoryImpl getMemory=new getMemoryImpl();
        if(mode.equals("2h")){
            res=getMemory.get15MinMen(ip);
        }else if(mode.equals("1d")){
            res=getMemory.get1Day(ip);
        }else if(mode.equals("1m")){
            res.add(getMemory.getMemory(ip));
        }
        return res;
    }

    /**
     * net receive 可用
     * @param ip
     * @param mode
     * @return
     */
    @GetMapping(value = "{ip}/net/info/read/{mode}")
    @ResponseBody
    public List<netInDto> getNetInData(@PathVariable("ip")String ip,
                                       @PathVariable("mode")String mode){
        getNetImpl getNet=new getNetImpl();
        List<netInDto> res=new ArrayList<netInDto>();
        if(mode.equals("2h")){
            res=getNet.get15MinuteNetIn(ip);
        }else if(mode.equals("1d")){
            res=getNet.getOneDayNetIn(ip);
        }else if(mode.equals("1m")){
            res.add(getNet.getNetIn(ip));
        }
        return res;
    }

    /**
     * net send 可用
     * @param ip
     * @param mode
     * @return
     */
    @GetMapping(value = "{ip}/net/info/write/{mode}")
    @ResponseBody
    public List<netOutDto> getNetOutData(@PathVariable("ip") String ip,
                                         @PathVariable("mode") String mode){
        getNetImpl getNet=new getNetImpl();
        List<netOutDto> res=new ArrayList<netOutDto>();
        if(mode.equals("2h")){
            res=getNet.get15MinuteNetOut(ip);
        }else if(mode.equals("1d")){
            res=getNet.getOneDayNetOut(ip);
        }else if(mode.equals("1m")){
            res.add(getNet.getNetOut(ip));
        }
        return res;
    }

    //可用
    @GetMapping(value = "{ip}/disk/info/read/{mode}")
    @ResponseBody
    public List<DiskReadDto> getDiskReadData(@PathVariable("ip") String ip,
                                            @PathVariable("mode") String mode){
        getDiskImpl getDisk=new getDiskImpl();
        List<DiskReadDto> res=new ArrayList<DiskReadDto>();
        if(mode.equals("2h")){
            res= getDisk.get15minuteDiskRead(ip);
        }else if(mode.equals("1d")){
            res=getDisk.getOneDayDiskRead(ip);
        }else if(mode.equals("1m")){
            res.add(getDisk.getDiskRead(ip));
        }
        return res;
    }

    /**
     *  可用
     * @param ip
     * @param mode
     * @return
     */
    @GetMapping(value = "{ip}/disk/info/write/{mode}")
    @ResponseBody
    public List<DiskWriteDto> getDiskWriteData(@PathVariable("ip") String ip,
                                              @PathVariable("mode") String mode){
        getDiskImpl getDisk=new getDiskImpl();
        List<DiskWriteDto> res=new ArrayList<DiskWriteDto>();
        if(mode.equals("2h")){
            res=getDisk.get15minuteDiskWrite(ip);
        }else if(mode.equals("1d")){
            res=getDisk.getOneDayDiskWrite(ip);
        }else if(mode.equals("1m")){
            res.add(getDisk.getDiskWrite(ip));
        }
        return res;
    }

    @GetMapping(value = "warnMessage/{id}")
    @ResponseBody
    public WarnMessage getWarnMessageById(@PathVariable("id") long id) {
        return messageCenterService.findById(id);
    }

    @PostMapping(value = "warnMessage/update")
    public String updateWarnMessage(WarnMessage warnMessage) {
        log.info("warnMessage={}", warnMessage);
        messageCenterService.updateWarnMessage(warnMessage);
        return "redirect:/messageCenter";
    }

    @GetMapping(value = "warnMessage/{id}/delete")
    public String deleteWarnMessage(@PathVariable("id") long id) {
        messageCenterService.deleteWarnMessage(id);
        return "redirect:/messageCenter";
    }

    @GetMapping(value = "warnMessage/{id}/stop")
    public String stopWarmMessage(@PathVariable("id") long id){
        messageCenterService.stopWarmMessage(id);
        return "redirect:/messageCenter";
    }

    @GetMapping(value = "warnMessage/{id}/start")
    public String startWarmMessage(@PathVariable("id") long id){
        messageCenterService.startwarnMessage(id);
        return "redirect:/messageCenter";
    }

    @PostMapping(value = "warnMessage/create")
    public String  createWarnMessage(WarnMessage warnMessage) {
        log.info("warnMessage={}", warnMessage);
        messageCenterService.create(warnMessage);
        return "redirect:/messageCenter";
    }
}
