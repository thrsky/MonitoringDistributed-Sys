package com.zjut.sys.dao;

import com.zjut.sys.dto.netInDto;
import com.zjut.sys.dto.netOutDto;

import java.util.List;

/**
 * Created by thRShy on 2017/6/7.
 */
public interface getNet {
    public List<netInDto> get15MinuteNetIn(String ip);
    public List<netOutDto> get15MinuteNetOut(String ip);
    public netInDto getNetIn(String ip);
    public List<netInDto> getOneDayNetIn(String ip);
    public List<netOutDto> getOneDayNetOut(String ip);
    public netOutDto getNetOut(String ip);
}
