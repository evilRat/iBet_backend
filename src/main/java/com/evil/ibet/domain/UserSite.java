package com.evil.ibet.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_user_site")
public class UserSite {

    @Id
    private Integer id;             //id
    private Integer userId;    //用户id
    private Integer siteId;  //投注站id
    private BigDecimal balance;    //用户在投注站的余额

    private OffsetDateTime createTime; //创建时间
    private OffsetDateTime updateTime; //更新时间
    private String createUser; //创建人id
    private String createUserName; //创建人姓名
    private String updateUser; //更新人id
    private String updateUserName; //更新人姓名
}
