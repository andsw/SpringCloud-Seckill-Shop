SET FOREIGN_KEY_CHECKS = 0;


DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand`
(
    `id`     bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '品牌id',
    `name`   varchar(50) NOT NULL COMMENT '品牌名称',
    `image`  varchar(200) DEFAULT '' COMMENT '品牌图片地址',
    `letter` char(1)      DEFAULT '' COMMENT '品牌的首字母',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 325400
  DEFAULT CHARSET = utf8 COMMENT ='品牌表，一个品牌下有多个商品（spu），一对多关系';


-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`
(
    `id`        bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '类目id',
    `name`      varchar(20) NOT NULL COMMENT '类目名称',
    `parent_id` bigint(20)  NOT NULL COMMENT '父类目id,顶级类目填0',
    `is_parent` tinyint(1)  NOT NULL COMMENT '是否为父节点，0为否，1为是',
    `sort`      int(4)      NOT NULL COMMENT '排序指数，越小越靠前',
    PRIMARY KEY (`id`),
    KEY `key_parent_id` (`parent_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1424
  DEFAULT CHARSET = utf8 COMMENT ='商品类目表，类目和商品(spu)是一对多关系，类目与品牌是多对多关系';


DROP TABLE IF EXISTS `category_brand`;
CREATE TABLE `category_brand`
(
    `category_id` bigint(20) NOT NULL COMMENT '商品类目id',
    `brand_id`    bigint(20) NOT NULL COMMENT '品牌id',
    PRIMARY KEY (`category_id`, `brand_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='商品分类和品牌的中间表，两者是多对多关系';


DROP TABLE IF EXISTS `sku`;
CREATE TABLE `sku`
(
    `id`               bigint(20)   NOT NULL AUTO_INCREMENT COMMENT 'sku id',
    `spu_id`           bigint(20)   NOT NULL COMMENT 'spu id',
    `title`            varchar(255) NOT NULL COMMENT '商品标题',
    `images`           varchar(1000)         DEFAULT '' COMMENT '商品的图片，多个图片以‘,’分割',
    `price`            bigint(15)   NOT NULL DEFAULT '0' COMMENT '销售价格，单位为分',
    `indexes`          varchar(100)          DEFAULT '' COMMENT '特有规格属性在spu属性模板中的对应下标组合',
    `own_spec`         varchar(1000)         DEFAULT '' COMMENT 'sku的特有规格参数键值对，json格式，反序列化时请使用linkedHashMap，保证有序',
    `enable`           tinyint(1)   NOT NULL DEFAULT '1' COMMENT '是否有效，0无效，1有效',
    `create_time`      datetime     NOT NULL COMMENT '添加时间',
    `last_update_time` datetime     NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`),
    KEY `key_spu_id` (`spu_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 27359021548
  DEFAULT CHARSET = utf8 COMMENT ='sku表,该表表示具体的商品实体,如黑色的 64g的iphone 8';

DROP TABLE IF EXISTS `spec_group`;
CREATE TABLE `spec_group`
(
    `id`   bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '主键',
    `cid`  bigint(20)  NOT NULL COMMENT '商品分类id，一个分类下有多个规格组',
    `name` varchar(50) NOT NULL COMMENT '规格组的名称',
    PRIMARY KEY (`id`),
    KEY `key_category` (`cid`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 15
  DEFAULT CHARSET = utf8 COMMENT ='规格参数的分组表，每个商品分类下有多个规格参数组';

DROP TABLE IF EXISTS `spec_param`;
CREATE TABLE `spec_param`
(
    `id`        bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '主键',
    `cid`       bigint(20)   NOT NULL COMMENT '商品分类id',
    `group_id`  bigint(20)   NOT NULL,
    `name`      varchar(255) NOT NULL COMMENT '参数名',
    `numeric`   tinyint(1)   NOT NULL COMMENT '是否是数字类型参数，true或false',
    `unit`      varchar(255)  DEFAULT '' COMMENT '数字类型参数的单位，非数字类型可以为空',
    `generic`   tinyint(1)   NOT NULL COMMENT '是否是sku通用属性，true或false',
    `searching` tinyint(1)   NOT NULL COMMENT '是否用于搜索过滤，true或false',
    `segments`  varchar(1000) DEFAULT '' COMMENT '数值类型参数，如果需要搜索，则添加分段间隔值，如CPU频率间隔：0.5-1.0',
    PRIMARY KEY (`id`),
    KEY `key_group` (`group_id`),
    KEY `key_category` (`cid`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 24
  DEFAULT CHARSET = utf8 COMMENT ='规格参数组下的参数名';

DROP TABLE IF EXISTS `spu`;
CREATE TABLE `spu`
(
    `id`               bigint(20)   NOT NULL AUTO_INCREMENT COMMENT 'spu id',
    `title`            varchar(255) NOT NULL DEFAULT '' COMMENT '标题',
    `sub_title`        varchar(255)          DEFAULT '' COMMENT '子标题',
    `cid1`             bigint(20)   NOT NULL COMMENT '1级类目id',
    `cid2`             bigint(20)   NOT NULL COMMENT '2级类目id',
    `cid3`             bigint(20)   NOT NULL COMMENT '3级类目id',
    `brand_id`         bigint(20)   NOT NULL COMMENT '商品所属品牌id',
    `saleable`         tinyint(1)   NOT NULL DEFAULT '1' COMMENT '是否上架，0下架，1上架',
    `valid`            tinyint(1)   NOT NULL DEFAULT '1' COMMENT '是否有效，0已删除，1有效',
    `create_time`      datetime              DEFAULT NULL COMMENT '添加时间',
    `last_update_time` datetime              DEFAULT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 183
  DEFAULT CHARSET = utf8 COMMENT ='spu表，该表描述的是一个抽象性的商品，比如 iphone8';

DROP TABLE IF EXISTS `spu_detail`;
CREATE TABLE `spu_detail`
(
    `spu_id`        bigint(20)    NOT NULL,
    `description`   text COMMENT '商品描述信息',
    `generic_spec`  varchar(3000) NOT NULL DEFAULT '' COMMENT '通用规格参数数据',
    `special_spec`  varchar(1000) NOT NULL COMMENT '特有规格参数及可选值信息，json格式',
    `packing_list`  varchar(1000)          DEFAULT '' COMMENT '包装清单',
    `after_service` varchar(1000)          DEFAULT '' COMMENT '售后服务',
    PRIMARY KEY (`spu_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock`
(
    `sku_id`        bigint(20) NOT NULL COMMENT '库存对应的商品sku id',
    `seckill_stock` int(9) DEFAULT '0' COMMENT '可秒杀库存',
    `seckill_total` int(9) DEFAULT '0' COMMENT '秒杀总数量',
    `stock`         int(9)     NOT NULL COMMENT '库存数量',
    PRIMARY KEY (`sku_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='库存表，代表库存，秒杀库存等信息';