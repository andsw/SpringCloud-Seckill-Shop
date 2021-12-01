DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`
(
    `id`               int                          NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `order_uid`        varchar(30)                  NOT NULL COMMENT '订单id',
    `total_pay`        bigint(20)                   NOT NULL COMMENT '总金额，单位为分',
    `actual_pay`       bigint(20)                   NOT NULL COMMENT '实付金额。单位:分。如:20007，表示:200元7分',
    `promotion_ids`    varchar(255) COLLATE utf8_bin DEFAULT '',
    `create_time`      datetime                      DEFAULT NULL COMMENT '订单创建时间',
    `shipping_code`    varchar(20) COLLATE utf8_bin  DEFAULT NULL COMMENT '物流单号',
    `buyer_id`         varchar(50) COLLATE utf8_bin NOT NULL COMMENT '用户id',
    `buyer_name`       varchar(50) COLLATE utf8_bin NOT NULL COMMENT '买家昵称',
    `receiver_name`    varchar(50) COLLATE utf8_bin  DEFAULT NULL COMMENT '收货人',
    `receiver_mobile`  varchar(12) COLLATE utf8_bin  DEFAULT NULL COMMENT '收货人手机',
    `receiver_address` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '收获地址',
    KEY `create_time` (`create_time`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;


DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`
(
    `id`        bigint(20)  NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `order_uid` varchar(30) NOT NULL COMMENT '订单id',
    `sku_id`    bigint(20)  NOT NULL COMMENT 'sku商品id',
    `num`       int(11)     NOT NULL COMMENT '购买数量',
    `price`     bigint(20)  NOT NULL COMMENT '价格,单位：分',
    UNIQUE KEY (`order_uid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='订单详情表';


DROP TABLE IF EXISTS `order_status`;
CREATE TABLE `order_status`
(
    `id`           int         NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `order_uid`    VARCHAR(30) NOT NULL COMMENT '订单id',
    `status`       int(1)   DEFAULT NULL COMMENT '状态：1、未付款 2、已付款,未发货 3、已发货,未确认 4、交易成功 5、交易关闭 6、已评价',
    `create_time`  datetime DEFAULT NULL COMMENT '订单创建时间',
    `payment_time` datetime DEFAULT NULL COMMENT '付款时间',
    `consign_time` datetime DEFAULT NULL COMMENT '发货时间',
    `end_time`     datetime DEFAULT NULL COMMENT '交易完成时间',
    `close_time`   datetime DEFAULT NULL COMMENT '交易关闭时间',
    UNIQUE KEY (`order_uid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='订单状态表';