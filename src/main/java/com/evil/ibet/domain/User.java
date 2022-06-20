package com.evil.ibet.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;             //用户id
    private Integer type;   //用户类型
    private String wxOpenId;    //微信openId
    private String wxNickName;  //用户微信昵称
    private String userName;    //用户真实姓名
    private String idCardNo;      //用户身份证信息
    private String phoneNo;     //用户手机号码

    private OffsetDateTime createTime; //创建时间
    private OffsetDateTime updateTime; //更新时间
    private String createUser; //创建人id
    private String createUserName; //创建人姓名
    private String updateUser; //更新人id
    private String updateUserName; //更新人姓名
}
