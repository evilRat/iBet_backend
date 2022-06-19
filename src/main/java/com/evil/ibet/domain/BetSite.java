package com.evil.ibet.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_bet_site")
public class BetSite {

    @Id
    private int id;
    private String siteName;        //彩票站名称
    private String master;      //负责人
    private String masterIdCard;      //负责人身份证号
    private String username;    //用户名
    private String password;    //密码
    private String betTypes;    //玩法

    private OffsetDateTime createTime; //创建时间
    private OffsetDateTime updateTime; //更新时间
    private String createUser; //创建人id
    private String createUserName; //创建人姓名
    private String updateUser; //更新人id
    private String updateUserName; //更新人姓名

    @Transient
    private List<Integer> betTypeList;
}
