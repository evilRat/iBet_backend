package com.evil.ibet.domain;

public enum BetTypeEnum {
    QILECAI(1, 1, "双色球"),
    SHUANGSEQIU(2, 2, "七乐彩"),
    THREED(3, 3, "3D"),
    ;

    private Integer code;
    private Integer id; // 绑定数据库id
    private String desc;

    BetTypeEnum(Integer code, Integer id, String desc) {
        this.code = code;
        this.id = id;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getId() {
        return id;
    }
}
