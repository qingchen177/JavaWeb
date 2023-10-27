DROP TABLE IF EXISTS ${tablePrefix}_user;
CREATE TABLE ${tablePrefix}_user
(
    `id`          varchar(32) NOT NULL COMMENT 'ID',
    `account`     varchar(64) NOT NULL COMMENT '账号',
    `name`        varchar(64) NOT NULL COMMENT '姓名',
    `email`       varchar(256)         DEFAULT NULL COMMENT '邮箱',
    `mobile`      varchar(32)          DEFAULT '' COMMENT '手机',
    `wechat`      varchar(512)         DEFAULT NULL COMMENT '微信',
    `sex`         varchar(1)           DEFAULT 'N' COMMENT '性别{W:女;M:男;N:未知}',
    `status`      tinyint(4)           DEFAULT '1' COMMENT '状态 1启用 0禁用 9删除',
    `avatar`      varchar(512)         DEFAULT '' COMMENT '头像',
    `password`    varchar(64) NOT NULL DEFAULT '' COMMENT '密码',
    `create_user` varchar(32)          DEFAULT NULL COMMENT '创建人id',
    `create_time` datetime             DEFAULT NULL COMMENT '创建时间',
    `update_user` varchar(32)          DEFAULT NULL COMMENT '更新人id',
    `update_time` datetime             DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='用户表';

INSERT INTO `basic_web`.`${tablePrefix}_user`(`id`, `account`, `name`, `email`, `mobile`, `wechat`, `sex`, `status`,
                                              `avatar`, `password`, `create_user`, `create_time`, `update_user`,
                                              `update_time`)
VALUES ('-1', 'adminstrator', 'adminstrator', 'qingchen0607@qq.com', '151xxxx3710', '151xxxx3710', 'N', 1, '', '123456',
        '-1', '2023-10-12 17:07:11', '-1', '2023-10-12 17:07:14');

DROP TABLE IF EXISTS ${tablePrefix}_audit_record;
CREATE TABLE ${tablePrefix}_audit_record
(
    `id`                         varchar(32) NOT NULL COMMENT 'ID',
    `operator`                   varchar(64) NOT NULL COMMENT '操作人',
    `operation_type`             varchar(64) NOT NULL COMMENT '操作类型',
    `operation_time`             datetime    NOT NULL COMMENT '操作时间',
    `operation_time_consumption` int(8) COMMENT '操作耗时',
    `operation_class_name`       varchar(1024) DEFAULT NULL COMMENT '操作类名',
    `operation_method_name`      varchar(1024) DEFAULT NULL COMMENT '操作方法名',
    `operation_method_params`    varchar(1024) DEFAULT NULL COMMENT '操作方法参数',
    `operation_return_value`     varchar(1024) DEFAULT NULL COMMENT '操作方法返回值',
    `create_user`                varchar(32)   DEFAULT NULL COMMENT '创建人id',
    `create_time`                datetime      DEFAULT NULL COMMENT '创建时间',
    `update_user`                varchar(32)   DEFAULT NULL COMMENT '更新人id',
    `update_time`                datetime      DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='审计记录表';

DROP TABLE IF EXISTS ${tablePrefix}_qrcode_history;
CREATE TABLE ${tablePrefix}_qrcode_history
(
    `id`          varchar(32) NOT NULL COMMENT 'ID',
    `user_id`     varchar(64) NOT NULL COMMENT '用户id',
    `login_time`  datetime    NOT NULL COMMENT '操作时间',
    `status`      tinyint(4)  DEFAULT '0' COMMENT '状态 0有效 1失效',
    `create_user` varchar(32) DEFAULT NULL COMMENT '创建人id',
    `create_time` datetime    DEFAULT NULL COMMENT '创建时间',
    `update_user` varchar(32) DEFAULT NULL COMMENT '更新人id',
    `update_time` datetime    DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='二维码登陆历史表';