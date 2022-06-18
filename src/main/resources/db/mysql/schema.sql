DROP TABLE IF EXISTS t_bet;
CREATE TABLE t_bet
(
    id               int NOT NULL AUTO_INCREMENT,
    bet_name         varchar(45) not NULL comment '玩法名称',
    red_ball_num     int NOT NULL comment '红球个数',
    blue_ball_num    int NOT NULL comment '蓝球个数',
    red_ball_range   int NOT NULL comment '红球范围',
    blue_ball_range  int NOT NULL comment '蓝球范围',
    icon             varchar(45) DEFAULT NULL comment 'icon',
    create_user      int     not null comment '创建人id',
    create_user_name int     not null comment '创建人姓名',
    create_time      int     not null comment '创建时间',
    update_user      int     not null comment '更新人id',
    update_user_name int     not null comment '更新人姓名',
    update_time      int     not null comment '更新实践',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS t_bet_site;
CREATE TABLE t_bet_site
(
    id               int      NOT NULL AUTO_INCREMENT,
    site_name        varchar(255) not null comment '投注站名称',
    master           varchar(255) not null comment '站长',
    master_id_card   varchar(255) not null comment '站长身份证号',
    username         varchar(255) not null comment '管理员登录名',
    password         varchar(255) not null comment '管理员密码',
    bet_types        varchar(255) not null comment '玩法',

    create_user      int          not null comment '创建人id',
    create_user_name int          not null comment '创建人姓名',
    create_time      int          not null comment '创建时间',
    update_user      int          not null comment '更新人id',
    update_user_name int          not null comment '更新人姓名',
    update_time      int          not null comment '更新实践',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;


DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user
(
    id               int     NOT NULL AUTO_INCREMENT,
    wx_open_id       varchar(45) NOT NULL,
    wx_nick_name     varchar(45) DEFAULT NULL,
    user_name        varchar(45) DEFAULT NULL,
    id_card_no       varchar(18) DEFAULT NULL,
    phone_no         varchar(11) DEFAULT NULL,

    create_user      int         not null comment '创建人id',
    create_user_name int         not null comment '创建人姓名',
    create_time      int         not null comment '创建时间',
    update_user      int         not null comment '更新人id',
    update_user_name int         not null comment '更新人姓名',
    update_time      int         not null comment '更新实践',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;


DROP TABLE IF EXISTS t_user_site;
CREATE TABLE t_user_site
(
    id      int NOT NULL AUTO_INCREMENT,
    user_id int DEFAULT NULL comment '用户ID',
    site_id int DEFAULT NULL comment '投注站id',
    balance decimal DEFAULT NULL comment '用户在投注站余额',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

