package com.evil.ibet.entity;

import java.sql.Date;

public class User {

    private int id;             //用户id
    private String wxOpenId;    //微信openId
    private String wxNickName;  //用户微信昵称
    private String userName;    //用户真实姓名
    private String idCardNo;      //用户身份证信息
    private String phoneNo;     //用户手机号码
    private Date registerTime;//用户注册时间

    public User() {

    }

    public User(int id, String wxOpenId, String wxNickName, String userName, String idCardNo, String phoneNo, Date registerTime) {
        this.id = id;
        this.wxOpenId = wxOpenId;
        this.wxNickName = wxNickName;
        this.userName = userName;
        this.idCardNo = idCardNo;
        this.phoneNo = phoneNo;
        this.registerTime = registerTime;
    }

    public User(String wxOpenId, String wxNickName) {
        this.wxOpenId = wxOpenId;
        this.wxNickName = wxNickName;
    }

    public User(int id, String userName, String idCardNo, String phoneNo) {
        this.id = id;
        this.userName = userName;
        this.idCardNo = idCardNo;
        this.phoneNo = phoneNo;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getWxNickName() {
        return wxNickName;
    }

    public void setWxNickName(String wxNickName) {
        this.wxNickName = wxNickName;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }
}
