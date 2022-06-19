package com.evil.ibet.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_order")
public class Order {

    @Id
    private int id;
    private String orderCode;
    private int userId;
    private int siteId;
    private int betId;
    private String redBalls;
    private String blueBalls;
    private int times; //倍数;
    private BigDecimal amount; //总金额

    private OffsetDateTime createTime; //创建时间
    private OffsetDateTime updateTime; //更新时间
    private String createUser; //创建人id
    private String createUserName; //创建人姓名
    private String updateUser; //更新人id
    private String updateUserName; //更新人姓名

    // vo
    @Transient
    private String betName;
    @Transient
    private String siteName;
    @Transient
    private List<Integer> redList;
    @Transient
    private List<Integer> blueList;
}
