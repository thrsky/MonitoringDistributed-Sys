package com.zjut.sys.dto;

import java.util.Date;

/**
 * Created by thRShy on 2017/6/7.
 */
public class netOutDto {
    private double netOut;
    private Date date;

    public netOutDto() {
    }

    @Override
    public String toString() {
        return "netOutDto{" +
                "netOutDto=" + netOut +
                ", date=" + date +
                '}';
    }

    public double getNetOut() {
        return netOut;
    }

    public void setNetOut(double netOut) {
        this.netOut = netOut;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
