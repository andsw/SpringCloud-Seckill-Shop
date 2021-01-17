DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`
(
    `order_id`          bigint(20)                   NOT NULL COMMENT '订单id',
    `total_pay`         bigint(20)                   NOT NULL COMMENT '总金额，单位为分',
    `actual_pay`        bigint(20)                   NOT NULL COMMENT '实付金额。单位:分。如:20007，表示:200元7分',
    `promotion_ids`     varchar(255) COLLATE utf8_bin DEFAULT '',
    `payment_type`      tinyint(1) unsigned zerofill NOT NULL COMMENT '支付类型，1、在线支付，2、货到付款',
    `post_fee`          bigint(20)                   NOT NULL COMMENT '邮费。单位:分。如:20007，表示:200元7分',
    `create_time`       datetime                      DEFAULT NULL COMMENT '订单创建时间',
    `shipping_name`     varchar(20) COLLATE utf8_bin  DEFAULT NULL COMMENT '物流名称',
    `shipping_code`     varchar(20) COLLATE utf8_bin  DEFAULT NULL COMMENT '物流单号',
    `user_id`           varchar(50) COLLATE utf8_bin NOT NULL COMMENT '用户id',
    `buyer_message`     varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '买家留言',
    `buyer_nick`        varchar(50) COLLATE utf8_bin NOT NULL COMMENT '买家昵称',
    `buyer_rate`        tinyint(1)                    DEFAULT NULL COMMENT '买家是否已经评价,0未评价，1已评价',
    `receiver_state`    varchar(100) COLLATE utf8_bin DEFAULT '' COMMENT '收获地址（省）',
    `receiver_city`     varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '收获地址（市）',
    `receiver_district` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '收获地址（区/县）',
    `receiver_address`  varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '收获地址（街道、住址等详细地址）',
    `receiver_mobile`   varchar(12) COLLATE utf8_bin  DEFAULT NULL COMMENT '收货人手机',
    `receiver_zip`      varchar(15) COLLATE utf8_bin  DEFAULT NULL COMMENT '收货人邮编',
    `receiver`          varchar(50) COLLATE utf8_bin  DEFAULT NULL COMMENT '收货人',
    `invoice_type`      int(1)                        DEFAULT '0' COMMENT '发票类型(0无发票1普通发票，2电子发票，3增值税发票)',
    `source_type`       int(1)                        DEFAULT '2' COMMENT '订单来源：1:app端，2：pc端，3：M端，4：微信端，5：手机qq端',
    PRIMARY KEY (`order_id`),
    KEY `create_time` (`create_time`),
    KEY `buyer_nick` (`buyer_nick`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;


DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`
(
    `id`       bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '订单详情id ',
    `order_id` bigint(20)   NOT NULL COMMENT '订单id',
    `sku_id`   bigint(20)   NOT NULL COMMENT 'sku商品id',
    `num`      int(11)      NOT NULL COMMENT '购买数量',
    `title`    varchar(200) NOT NULL COMMENT '商品标题',
    `own_spec` varchar(1000) DEFAULT '' COMMENT '商品动态属性键值集',
    `price`    bigint(20)   NOT NULL COMMENT '价格,单位：分',
    `image`    varchar(200)  DEFAULT '' COMMENT '商品图片',
    PRIMARY KEY (`id`),
    KEY `key_order_id` (`order_id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='订单详情表';


DROP TABLE IF EXISTS `order_status`;
CREATE TABLE `order_status`
(
    `order_id`     bigint(20) NOT NULL COMMENT '订单id',
    `status`       int(1)   DEFAULT NULL COMMENT '状态：1、未付款 2、已付款,未发货 3、已发货,未确认 4、交易成功 5、交易关闭 6、已评价',
    `create_time`  datetime DEFAULT NULL COMMENT '订单创建时间',
    `payment_time` datetime DEFAULT NULL COMMENT '付款时间',
    `consign_time` datetime DEFAULT NULL COMMENT '发货时间',
    `end_time`     datetime DEFAULT NULL COMMENT '交易完成时间',
    `close_time`   datetime DEFAULT NULL COMMENT '交易关闭时间',
    `comment_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '评价时间',
    PRIMARY KEY (`order_id`),
    KEY `status` (`status`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='订单状态表';