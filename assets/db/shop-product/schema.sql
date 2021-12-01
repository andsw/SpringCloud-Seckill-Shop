SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `spu`;
CREATE TABLE `spu`
(
    `id`               int          NOT NULL primary key AUTO_INCREMENT,
    `spu_uid`          varchar(30)  NOT NULL COMMENT 'UID',
    `title`            varchar(255) NOT NULL DEFAULT '' COMMENT '标题（如面包屑商品界面层级显示内容）',
    `sub_title`        varchar(255)          DEFAULT '' COMMENT '子标题',
    `brand_name`       bigint(20)   NOT NULL COMMENT '商品所属品牌id',
    `saleable`         tinyint(1)   NOT NULL DEFAULT '1' COMMENT '是否上架，0下架，1上架',
    `valid`            tinyint(1)   NOT NULL DEFAULT '1' COMMENT '是否有效，0已删除，1有效',
    `create_time`      datetime              DEFAULT NULL COMMENT '添加时间',
    `last_update_time` datetime              DEFAULT NULL COMMENT '最后修改时间',
    UNIQUE KEY (`spu_uid`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 183
  DEFAULT CHARSET = utf8 COMMENT ='spu表，该表描述的是一个抽象性的商品，比如 iphone8';

DROP TABLE IF EXISTS `spu_detail`;
CREATE TABLE `spu_detail`
(
    `id`          int         NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `spu_uid`     varchar(30) NOT NULL,
    `description` text COMMENT '商品描述信息',
    UNIQUE KEY (`spu_uid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `sku`;
CREATE TABLE `sku`
(
    `id`               int   NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `spu_uid`          varchar(30)  NOT NULL COMMENT 'spu uid',
    `title`            varchar(255) NOT NULL COMMENT '商品主标题',
    `price`            bigint(15)   NOT NULL DEFAULT '0' COMMENT '销售价格，单位为分',
    `enable`           tinyint(1)   NOT NULL DEFAULT '1' COMMENT '是否有效，0无效，1有效',
    `create_time`      datetime     NOT NULL COMMENT '添加时间',
    `last_update_time` datetime     NOT NULL COMMENT '最后修改时间',
    UNIQUE KEY (`spu_uid`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 27359021548
  DEFAULT CHARSET = utf8 COMMENT ='sku表,该表表示具体的商品实体,如黑色的 64g的iphone 8';

DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock`
(
    `id`            int         NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `sku_uid`       varchar(30) NOT NULL COMMENT '库存对应的商品sku uid',
    `seckill_stock` int(9) DEFAULT '0' COMMENT '可秒杀库存',
    `seckill_total` int(9) DEFAULT '0' COMMENT '秒杀总数量',
    `stock`         int(9)      NOT NULL COMMENT '库存数量',
    UNIQUE KEY (`sku_uid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='库存表，代表库存，秒杀库存等信息';