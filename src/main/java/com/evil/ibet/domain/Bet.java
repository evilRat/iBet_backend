package com.evil.ibet.entity;

public class Bet {

    private int id;
    private String name;
    private int redBallNum;
    private int blueBallNum;
    private int picname;

    public Bet() {

    }

    public Bet(int id, String name, int redBallNum, int blueBallNum, int picname) {
        this.id = id;
        this.name = name;
        this.redBallNum = redBallNum;
        this.blueBallNum = blueBallNum;
        this.picname = picname;
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

    public int getRedBallNum() {
        return redBallNum;
    }

    public void setRedBallNum(int redBallNum) {
        this.redBallNum = redBallNum;
    }

    public int getBlueBallNum() {
        return blueBallNum;
    }

    public void setBlueBallNum(int blueBallNum) {
        this.blueBallNum = blueBallNum;
    }

    public int getPicname() {
        return picname;
    }

    public void setPicname(int picname) {
        this.picname = picname;
    }
}
