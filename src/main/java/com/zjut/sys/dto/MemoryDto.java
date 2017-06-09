package com.zjut.sys.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by xjy on 2017/5/15.
 */
@Data
public class MemoryDto {
    private double total;
    private double used;
    private double rate;
    private Date time;
}
