package com.evil.ibet.entity;

import java.sql.Timestamp;

public class Order {

    private int id;
    private int userId;
    private int betSiteId;
    private int betId;
    private String redBalls;
    private String blueBalls;
    private int times;
    private Timestamp orderTime;

    public Order() {

    }


    public Order(int id, int userId, int betSiteId, int betId, String redBalls, String blueBalls, int times, Timestamp orderTime) {
        this.id = id;
        this.userId = userId;
        this.betSiteId = betSiteId;
        this.betId = betId;
        this.redBalls = redBalls;
        this.blueBalls = blueBalls;
        this.times = times;
        this.orderTime = orderTime;
    }

    public Order(int userId, int betSiteId, int betId, String redBalls, String blueBalls, int times) {
        this.id = id;
        this.userId = userId;
        this.betSiteId = betSiteId;
        this.betId = betId;
        this.redBalls = redBalls;
        this.blueBalls = blueBalls;
        this.times = times;
        this.orderTime = orderTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBetSiteId() {
        return betSiteId;
    }

    public void setBetSiteId(int betSiteId) {
        this.betSiteId = betSiteId;
    }

    public int getBetId() {
        return betId;
    }

    public void setBetId(int betId) {
        this.betId = betId;
    }

    public String getRedBalls() {
        return redBalls;
    }

    public void setRedBalls(String redBalls) {
        this.redBalls = redBalls;
    }

    public String getBlueBalls() {
        return blueBalls;
    }

    public void setBlueBalls(String blueBalls) {
        this.blueBalls = blueBalls;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }
}
