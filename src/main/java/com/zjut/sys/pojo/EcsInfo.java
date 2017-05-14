package com.zjut.sys.pojo;

public class EcsInfo {
    private String ip;

    //CPU个数
    private Integer cpuNums;

    //内存（单位为kb)
    private Integer memory;

    //操作系统
    private String os;

    //带宽
    private Integer mbps;

    public EcsInfo(String ip, Integer cpuNums, Integer memory, String os, Integer mbps) {
        this.ip = ip;
        this.cpuNums = cpuNums;
        this.memory = memory;
        this.os = os;
        this.mbps = mbps;
    }

    public EcsInfo() {
        super();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getCpuNums() {
        return cpuNums;
    }

    public void setCpuNums(Integer cpuNums) {
        this.cpuNums = cpuNums;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os == null ? null : os.trim();
    }

    public Integer getMbps() {
        return mbps;
    }

    public void setMbps(Integer mbps) {
        this.mbps = mbps;
    }
}