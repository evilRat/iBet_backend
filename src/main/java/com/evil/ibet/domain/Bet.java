package com.evil.ibet.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.OffsetDateTime;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_bet")
public class Bet {

    @Id
    private Integer id;
    private String betName;
    private Integer redBallNum;
    private Integer blueBallNum;
    private Integer redBallRange;
    private Integer blueBallRange;
    private String icon;

    private OffsetDateTime createTime; //创建时间
    private OffsetDateTime updateTime; //更新时间
    private String createUser; //创建人id
    private String createUserName; //创建人姓名
    private String updateUser; //更新人id
    private String updateUserName; //更新人姓名
}
