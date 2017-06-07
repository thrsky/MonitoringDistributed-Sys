package com.zjut.sys.dao;

import com.zjut.sys.dto.DiskReadDto;
import com.zjut.sys.dto.DiskWriteDto;

import java.util.List;

/**
 * Created by thRShy on 2017/6/7.
 */
public interface getDisk {
    public List<DiskWriteDto> get15minuteDiskWrite(String ip);
    public List<DiskReadDto> get15minuteDiskRead(String ip);

    public List<DiskWriteDto> getOneDayDiskWrite(String ip);
    public List<DiskReadDto> getOneDayDiskRead(String ip);

}
