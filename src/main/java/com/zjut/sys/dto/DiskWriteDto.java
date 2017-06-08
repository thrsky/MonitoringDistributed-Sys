package com.zjut.sys.dto;

import java.util.Date;

/**
 * Created by thRShy on 2017/6/7.
 */
public class DiskWriteDto {
    private double write;
    private Date date;

    public DiskWriteDto() {
    }

    @Override
    public String toString() {
        return "DiskWriteDto{" +
                "write=" + write +
                ", date=" + date +
                '}';
    }

    public double getWrite() {
        return write;
    }

    public void setWrite(double write) {
        this.write = write;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
