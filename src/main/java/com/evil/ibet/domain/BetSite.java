package com.evil.ibet.entity;


import java.math.BigDecimal;
import java.sql.Timestamp;

public class BetSite {

    private int id;
    private String name;        //彩票站名称
    private String master;      //负责人
    private String username;    //用户名
    private String password;    //密码
    private Timestamp registerTime; //注册时间
    private String betTypes;    //玩法
    private BigDecimal balance; //用户在投注站余额

    public BetSite(int id, String name, String betTypes) {
        this.id = id;
        this.name = name;
        this.betTypes = betTypes;
    }

    public BetSite() {
    }

    public BetSite(int id, String name, String master, String username, String password, Timestamp registerTime, String betTypes, BigDecimal balance) {
        this.id = id;
        this.name = name;
        this.master = master;
        this.username = username;
        this.password = password;
        this.registerTime = registerTime;
        this.betTypes = betTypes;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    public String getBetTypes() {
        return betTypes;
    }

    public void setBetTypes(String betTypes) {
        this.betTypes = betTypes;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
