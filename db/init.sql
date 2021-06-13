drop table if exists SYS_USER;
create table SYS_USER
(
    id         bigint auto_increment comment '主键',
    name       varchar(255) null comment '姓名',
    login_name varchar(100) null comment '登录名',
    password   varchar(100) null comment '密码',
    constraint SYS_USER_pk
        primary key (id)
);


drop table if exists SYS_USER_ROLE;
create table SYS_USER_ROLE
(
    id          bigint auto_increment comment '主键',
    sys_user_id BIGINT      null comment '关联用户表主键',
    role        varchar(50) null comment '角色名',
    constraint SYS_USER_ROLE_pk
        primary key (id)
);
drop table if exists GOODS;
create table GOODS(
                      id          bigint auto_increment comment '主键',
                      name        varchar(255) comment '商品名称',
                      dealer     varchar(255) comment '经销商',
                      factory     varchar(255) comment '生产地',
                      unit_price  numeric(18,2) comment '单价',
                      image       longtext comment '商品图片',
                      qr_code_image longtext comment '商品二维码图片',
                      scan_count int comment '扫描次数',
                      seller_id bigint comment '关联卖方id',
                      constraint GOODS_pk
                          primary key (id)
);
insert into SYS_USER(name, login_name, password) VALUES ('商家A','sellerA','$2a$10$OZkHd5LbJmQcBs5NUwetL.xafO5ThfwIW3dYCwU514oVopgRmOghu');
insert into SYS_USER_ROLE(sys_user_id, role) values (1,'ROLE_SELLER');
insert into SYS_USER(name, login_name, password) VALUES ('商家B','sellerB','$2a$10$OZkHd5LbJmQcBs5NUwetL.xafO5ThfwIW3dYCwU514oVopgRmOghu');
insert into SYS_USER_ROLE(sys_user_id, role) values (2,'ROLE_SELLER');