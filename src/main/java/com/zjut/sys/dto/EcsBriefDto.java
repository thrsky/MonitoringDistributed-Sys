package com.zjut.sys.dto;
/**
 * 在serverList中展示用的简略信息
 * Created by xjy on 2017/5/14.
 */
public class EcsBriefDto {
    private String ip;
    private String name;
    private String cpu;
    private String memory;
    private String disk;
    private String description;
    private String operation;
    /**
     * 运行状态
     */
    private String status;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "EcsBriefDto{" +
                "ip='" + ip + '\'' +
                ", name='" + name + '\'' +
                ", cpu='" + cpu + '\'' +
                ", memory='" + memory + '\'' +
                ", disk='" + disk + '\'' +
                ", description='" + description + '\'' +
                ", operation='" + operation + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
