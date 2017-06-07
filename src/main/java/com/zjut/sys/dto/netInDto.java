package com.zjut.sys.dto;

import java.util.Date;

/**
 * Created by thRShy on 2017/6/7.
 */
public class netInDto {
    private double netIn;
    private Date date;

    public netInDto() {
    }

    public double getNetIn() {
        return netIn;
    }

    public void setNetIn(double netIn) {
        this.netIn = netIn;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "netInDto{" +
                "netInDto=" + netIn +
                ", date=" + date +
                '}';
    }
}
