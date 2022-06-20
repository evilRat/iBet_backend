package com.evil.ibet.domain;

public enum UserTypeEnum {
    UN_KNOW(0, "未知"), // 未知是未注册用户，可以试用，选号分享
    ADMIN(1, "管理员"),
    SITE_MASTER(2, "投注站"),
    BUYER(3, "彩民"),
    ;

    private Integer code;
    private String desc;

    UserTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
