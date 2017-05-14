package com.zjut.sys.pojo;

import java.util.Date;

public class Ecs {
    private String ecsIp;

    private String ecsName;

    private String ecsPassword;

    private Integer ecsPort;

    private String ecsLastLogin;

    private String ecsDesc;

    private Date ecsCreateTime;

    private String userId;

    public Ecs(String ecsIp, String ecsName, String ecsPassword, Integer ecsPort, String ecsLastLogin, String ecsDesc, Date ecsCreateTime, String userId) {
        this.ecsIp = ecsIp;
        this.ecsName = ecsName;
        this.ecsPassword = ecsPassword;
        this.ecsPort = ecsPort;
        this.ecsLastLogin = ecsLastLogin;
        this.ecsDesc = ecsDesc;
        this.ecsCreateTime = ecsCreateTime;
        this.userId = userId;
    }

    public Ecs() {
        super();
    }

    public String getEcsIp() {
        return ecsIp;
    }

    public void setEcsIp(String ecsIp) {
        this.ecsIp = ecsIp == null ? null : ecsIp.trim();
    }

    public String getEcsName() {
        return ecsName;
    }

    public void setEcsName(String ecsName) {
        this.ecsName = ecsName == null ? null : ecsName.trim();
    }

    public String getEcsPassword() {
        return ecsPassword;
    }

    public void setEcsPassword(String ecsPassword) {
        this.ecsPassword = ecsPassword == null ? null : ecsPassword.trim();
    }

    public Integer getEcsPort() {
        return ecsPort;
    }

    public void setEcsPort(Integer ecsPort) {
        this.ecsPort = ecsPort;
    }

    public String getEcsLastLogin() {
        return ecsLastLogin;
    }

    public void setEcsLastLogin(String ecsLastLogin) {
        this.ecsLastLogin = ecsLastLogin == null ? null : ecsLastLogin.trim();
    }

    public String getEcsDesc() {
        return ecsDesc;
    }

    public void setEcsDesc(String ecsDesc) {
        this.ecsDesc = ecsDesc == null ? null : ecsDesc.trim();
    }

    public Date getEcsCreateTime() {
        return ecsCreateTime;
    }

    public void setEcsCreateTime(Date ecsCreateTime) {
        this.ecsCreateTime = ecsCreateTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}