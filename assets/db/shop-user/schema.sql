
create table `shop-user`.user
(
    id int auto_increment
        primary key,
    username varchar(255) not null,
    password varchar(255) not null,
    role varchar(1024) not null comment '用户角色，用于鉴权，多个角色逗号分隔',
    register_time timestamp default CURRENT_TIMESTAMP not null,
    constraint user_username_uindex
        unique (username)
);
