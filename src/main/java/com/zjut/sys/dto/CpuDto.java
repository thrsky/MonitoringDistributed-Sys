package com.zjut.sys.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by xjy on 2017/5/14.
 */
@Data
public class CpuDto {
    private Date time;
    private double usage;
}
