package com.zjut.sys.dto;

import java.util.Date;

/**
 * Created by xjy on 2017/5/14.
 */
public class CpuDto {
    private Date time;
    private double usage;

    public double getUsage() {
        return usage;
    }

    public void setUsage(double usage) {
        this.usage = usage;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "CpuDto{" +
                "time=" + time +
                ", usage=" + usage +
                '}';
    }
}
