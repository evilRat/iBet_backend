DROP TABLE IF EXISTS t_bet;
CREATE TABLE t_bet
(
    id               int         NOT NULL AUTO_INCREMENT,
    bet_name         varchar(45) not NULL comment '玩法名称',
    red_ball_num     int         NOT NULL comment '红球个数',
    blue_ball_num    int         NOT NULL comment '蓝球个数',
    red_ball_range   int         NOT NULL comment '红球范围',
    blue_ball_range  int         NOT NULL comment '蓝球范围',
    icon             varchar(45) DEFAULT NULL comment 'icon',
    create_user      int         not null comment '创建人id',
    create_user_name varchar(45) not null comment '创建人姓名',
    create_time      datetime    not null comment '创建时间',
    update_user      int         not null comment '更新人id',
    update_user_name varchar(45) not null comment '更新人姓名',
    update_time      datetime    not null comment '更新实践',
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS t_bet_site;
CREATE TABLE t_bet_site
(
    id               int          NOT NULL AUTO_INCREMENT,
    site_name        varchar(255) not null comment '投注站名称',
    master           varchar(255) not null comment '站长',
    master_id_card   varchar(255) not null comment '站长身份证号',
    username         varchar(255) not null comment '管理员登录名',
    password         varchar(255) not null comment '管理员密码',
    bet_types        varchar(255) not null comment '玩法',

    create_user      int          not null comment '创建人id',
    create_user_name varchar(45)  not null comment '创建人姓名',
    create_time      datetime     not null comment '创建时间',
    update_user      int          not null comment '更新人id',
    update_user_name varchar(45)  not null comment '更新人姓名',
    update_time      datetime     not null comment '更新实践',
    PRIMARY KEY (id)
);


DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user
(
    id               int         NOT NULL AUTO_INCREMENT,
    wx_open_id       varchar(45) NOT NULL,
    wx_nick_name     varchar(45) DEFAULT NULL,
    user_name        varchar(45) DEFAULT NULL,
    id_card_no       varchar(18) DEFAULT NULL,
    phone_no         varchar(11) DEFAULT NULL,
    type             int         not null comment '类型：1-系统管理员;2-投注站管理员;3-彩民',

    create_user      int         null comment '创建人id',
    create_user_name varchar(45) null comment '创建人姓名',
    create_time      datetime    DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_user      int         null comment '更新人id',
    update_user_name varchar(45) null comment '更新人姓名',
    update_time      datetime    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id)
);


DROP TABLE IF EXISTS t_user_site;
CREATE TABLE t_user_site
(
    id               int         NOT NULL AUTO_INCREMENT,
    user_id          int           DEFAULT NULL comment '用户ID',
    site_id          int           DEFAULT NULL comment '投注站id',
    balance          decimal(6, 2) DEFAULT NULL comment '用户在投注站余额',

    create_user      int         not null comment '创建人id',
    create_user_name varchar(45) not null comment '创建人姓名',
    create_time      datetime    not null comment '创建时间',
    update_user      int         not null comment '更新人id',
    update_user_name varchar(45) not null comment '更新人姓名',
    update_time      datetime    not null comment '更新实践',
    PRIMARY KEY (id)
);
alter table t_user_site
    add unique (user_id, site_id);


drop table if exists t_order;
create table t_order
(
    id               int         NOT NULL AUTO_INCREMENT,
    order_code       varchar(20) not null comment '订单号',
    user_id          int         not NULL comment '用户ID',
    site_Id          int         not NULL comment '投注站id',
    bet_Id           int         not NULL comment '玩法id',
    red_balls        varchar(20) not NULL comment '红球',
    blue_balls       varchar(20) not NULL comment '蓝球',
    times            int         not NULL comment '倍数',
    amount           int     not NULL comment '总金额',

    create_user      int         not null comment '创建人id',
    create_user_name varchar(45) not null comment '创建人姓名',
    create_time      datetime    not null comment '创建时间',
    update_user      int         not null comment '更新人id',
    update_user_name varchar(45) not null comment '更新人姓名',
    update_time      datetime    not null comment '更新实践',
    primary key (id)
);

