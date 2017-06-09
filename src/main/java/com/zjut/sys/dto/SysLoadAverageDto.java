package com.zjut.sys.dto;

import lombok.Data;

import java.util.Date;

/**
 *  系统平均负载
 * Created by thRShy on 2017/6/7.
 */
@Data
public class SysLoadAverageDto {
    private double usage;
    private Date time;
}
