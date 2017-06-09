package com.zjut.sys.dao;

import com.zjut.sys.dto.MemoryDto;

import java.util.List;

/**
 *  获取内存
 * Created by thRShy on 2017/6/7.
 */
public interface getMemory {
    public List<MemoryDto> get15MinMen(String ip);
    public List<MemoryDto> get1Day(String ip);
    public MemoryDto getMemory(String ip);
}
