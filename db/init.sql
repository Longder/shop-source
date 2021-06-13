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

