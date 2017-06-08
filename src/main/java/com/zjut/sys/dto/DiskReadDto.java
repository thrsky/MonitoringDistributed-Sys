package com.zjut.sys.dto;

import java.util.Date;

/**
 * Created by thRShy on 2017/6/7.
 */
public class DiskReadDto {
    private double read;
    private Date date;

    public DiskReadDto() {
    }

    @Override
    public String toString() {
        return "DiskReadDto{" +
                "read=" + read +
                ", date=" + date +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getRead() {
        return read;
    }

    public void setRead(double read) {
        this.read = read;
    }
}
