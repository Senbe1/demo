

#user表:用户表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `first_name`      varchar(30) NOT NULL COMMENT '真实姓名',
    `last_name`      varchar(30) NOT NULL COMMENT '昵称',
    `age`         varchar(20) NOT NULL COMMENT '手机号码',
    `sex`            int(4) NOT NULL COMMENT '性别'
    PRIMARY KEY (`id`),
    UNIQUE KEY `uniq_mobile`(`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';

BEGIN;
INSERT INTO `user` VALUES (1, '三', '张',18, 1);
INSERT INTO `user` VALUES (2, '四', '李',19, 2);
INSERT INTO `user` VALUES (3, '五', '王',20, 1);
INSERT INTO `user` VALUES (4, '仙贝','旺旺' ,10, 1);
INSERT INTO `user` VALUES (5, '雪饼', '旺旺',11, 1);
