package com.zjut.sys.pojo;

public class Ecs {
    private String ip;

    private String name;

    private Long userId;

    private String desc;

    private String cpu;

    private String disk;

    private String memory;

    private String status;

    private Integer port;

    private String passwd;

    private String os;

    public Ecs(String ip, String name, Long userId, String desc, String cpu, String disk, String memory, String status, Integer port, String passwd, String os) {
        this.ip = ip;
        this.name = name;
        this.userId = userId;
        this.desc = desc;
        this.cpu = cpu;
        this.disk = disk;
        this.memory = memory;
        this.status = status;
        this.port = port;
        this.passwd = passwd;
        this.os = os;
    }

    public Ecs() {
        super();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu == null ? null : cpu.trim();
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk == null ? null : disk.trim();
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory == null ? null : memory.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os == null ? null : os.trim();
    }

    @Override
    public String toString() {
        return "Ecs{" +
                "ip='" + ip + '\'' +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                ", desc='" + desc + '\'' +
                ", cpu='" + cpu + '\'' +
                ", disk='" + disk + '\'' +
                ", memory='" + memory + '\'' +
                ", status='" + status + '\'' +
                ", port=" + port +
                ", passwd='" + passwd + '\'' +
                ", os='" + os + '\'' +
                '}';
    }
}