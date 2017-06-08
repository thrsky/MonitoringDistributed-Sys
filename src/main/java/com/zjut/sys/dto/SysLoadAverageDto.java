package com.zjut.sys.dto;

import java.util.Date;

/**
 *  系统平均负载
 * Created by thRShy on 2017/6/7.
 */
public class SysLoadAverageDto {
    private double load;
    private Date date;

    public SysLoadAverageDto() {
    }

    @Override
    public String toString() {
        return "SysLoadAverageDto{" +
                "load=" + load +
                ", date=" + date +
                '}';
    }

    public double getLoad() {
        return load;
    }

    public void setLoad(double load) {
        this.load = load;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
