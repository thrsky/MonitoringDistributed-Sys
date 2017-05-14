package com.zjut.sys.pojo;

public class User {
    private String userId;

    private String userName;

    private String userPassword;

    private Integer userEcsNums;

    private String userEmail;

    private Long userPhone;

    public User(String userId, String userName, String userPassword, Integer userEcsNums, String userEmail, Long userPhone) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEcsNums = userEcsNums;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
    }

    public User() {
        super();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Integer getUserEcsNums() {
        return userEcsNums;
    }

    public void setUserEcsNums(Integer userEcsNums) {
        this.userEcsNums = userEcsNums;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }
}