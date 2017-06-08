package com.zjut.sys.web;

import com.zjut.sys.dao.getCpuData;
import com.zjut.sys.dao.impl.*;
import com.zjut.sys.dto.*;
import com.zjut.sys.pojo.EcsInfo;
import com.zjut.sys.pojo.WarnMessage;
import com.zjut.sys.service.MessageCenterService;
import com.zjut.sys.service.impl.EcsInfoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
     *  系统负载 可用
     * @param ip
     * @param mode
     * @return
     */
    @GetMapping(value = "{ip}/sysLoad/info/{mode}")
    @ResponseBody
    public List<SysLoadAverageDto> getSysLoadAverage(@PathVariable("ip") String ip,
                                               @PathVariable("mode") String mode){
        List<SysLoadAverageDto> res=null;
        getSysLoadAverageImpl getSysLoadAverage=new getSysLoadAverageImpl();
        if(mode.equals("15minutes")){
            res=getSysLoadAverage.get15minutesSysLoad(ip);
        }else if(mode.equals("OneDay")){
            res=getSysLoadAverage.getOneDaySysLoad(ip);
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
        List<CpuDto> res = null;
        getCpuData getCpuData=new getCpuDataImpl();
        if(mode.equals("15minutes")){
            res=getCpuData.get15MinCpu(ip);
        }else if(mode.equals("OneDay")){
            res=getCpuData.get1DaysCpu(ip);
        }
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
        List<MemoryDto> res=null;
        getMemoryImpl getMemory=new getMemoryImpl();
        if(mode.equals("15minutes")){
            res=getMemory.get15MinMen(ip);
        }else if(mode.equals("OneDay")){
            res=getMemory.get1Day(ip);
        }
        return res;
    }

    /**
     * net receive 可用
     * @param ip
     * @param mode
     * @return
     */
    @GetMapping(value = "{ip}/net/info/receive/{mode}")
    @ResponseBody
    public List<netInDto> getNetInData(@PathVariable("ip")String ip,
                                       @PathVariable("mode")String mode){
        getNetImpl getNet=new getNetImpl();
        List<netInDto> res=null;
        if(mode.equals("15minutes")){
            res=getNet.get15MinuteNetIn(ip);
        }else if(mode.equals("OneDay")){
            res=getNet.getOneDayNetIn(ip);
        }
        return res;
    }

    /**
     * net send 可用
     * @param ip
     * @param mode
     * @return
     */
    @GetMapping(value = "{ip}/net/info/send/{mode}")
    @ResponseBody
    public List<netOutDto> getNetOutData(@PathVariable("ip") String ip,
                                         @PathVariable("mode") String mode){
        getNetImpl getNet=new getNetImpl();
        List<netOutDto> res=null;
        if(mode.equals("15minutes")){
            res=getNet.get15MinuteNetOut(ip);
        }else if(mode.equals("OneDay")){
            res=getNet.getOneDayNetOut(ip);
        }
        return res;
    }

    //可用
    @GetMapping(value = "{ip}/disk/info/read/{mode}")
    @ResponseBody
    public List<DiskReadDto> getDiskReadData(@PathVariable("ip") String ip,
                                            @PathVariable("mode") String mode){
        getDiskImpl getDisk=new getDiskImpl();
        List<DiskReadDto> res=null;
        if(mode.equals("15minutes")){
            res= getDisk.get15minuteDiskRead(ip);
        }else if(mode.equals("OneDay")){
            res=getDisk.getOneDayDiskRead(ip);
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
        List<DiskWriteDto> res=null;
        if(mode.equals("15minutes")){
            res=getDisk.get15minuteDiskWrite(ip);
        }else if(mode.equals("OneDay")){
            res=getDisk.getOneDayDiskWrite(ip);
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
        return "redirect:messageCenter";
    }

    @GetMapping(value = "warnMessage/{id}/delete")
    public String deleteWarnMessage(@PathVariable("id") long id) {
        messageCenterService.deleteWarnMessage(id);
        return "redirect:messageCenter";
    }

    @PostMapping(value = "warnMessage/create")
    public String  createWarnMessage(WarnMessage warnMessage) {
        log.info("warnMessage={}", warnMessage);
        messageCenterService.updateWarnMessage(warnMessage);
        return "redirect:messageCenter";
    }
}
