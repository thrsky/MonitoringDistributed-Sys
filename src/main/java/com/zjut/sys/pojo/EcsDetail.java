package com.zjut.sys.pojo;

import java.util.Date;

public class EcsDetail {
    private String ip;

    private Date time;

    private Double cpuRate;

    private Double netIn;

    private Double netOut;

    private Integer ipos;

    private Double memoryRate;

    private Double averageLoad;

    private Double kbReads;

    private Double kbWrites;

    private Double diskUsage;

    public EcsDetail(String ip, Date time, Double cpuRate, Double netIn, Double netOut, Integer ipos, Double memoryRate, Double averageLoad, Double kbReads, Double kbWrites, Double diskUsage) {
        this.ip = ip;
        this.time = time;
        this.cpuRate = cpuRate;
        this.netIn = netIn;
        this.netOut = netOut;
        this.ipos = ipos;
        this.memoryRate = memoryRate;
        this.averageLoad = averageLoad;
        this.kbReads = kbReads;
        this.kbWrites = kbWrites;
        this.diskUsage = diskUsage;
    }

    public EcsDetail() {
        super();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getCpuRate() {
        return cpuRate;
    }

    public void setCpuRate(Double cpuRate) {
        this.cpuRate = cpuRate;
    }

    public Double getNetIn() {
        return netIn;
    }

    public void setNetIn(Double netIn) {
        this.netIn = netIn;
    }

    public Double getNetOut() {
        return netOut;
    }

    public void setNetOut(Double netOut) {
        this.netOut = netOut;
    }

    public Integer getIpos() {
        return ipos;
    }

    public void setIpos(Integer ipos) {
        this.ipos = ipos;
    }

    public Double getMemoryRate() {
        return memoryRate;
    }

    public void setMemoryRate(Double memoryRate) {
        this.memoryRate = memoryRate;
    }

    public Double getAverageLoad() {
        return averageLoad;
    }

    public void setAverageLoad(Double averageLoad) {
        this.averageLoad = averageLoad;
    }

    public Double getKbReads() {
        return kbReads;
    }

    public void setKbReads(Double kbReads) {
        this.kbReads = kbReads;
    }

    public Double getKbWrites() {
        return kbWrites;
    }

    public void setKbWrites(Double kbWrites) {
        this.kbWrites = kbWrites;
    }

    public Double getDiskUsage() {
        return diskUsage;
    }

    public void setDiskUsage(Double diskUsage) {
        this.diskUsage = diskUsage;
    }
}