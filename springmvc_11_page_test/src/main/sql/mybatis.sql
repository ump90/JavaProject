/*
Navicat MySQL Data Transfer

Source Server         : 呵呵
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2021-10-09 17:52:31
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_account
-- ----------------------------
DROP TABLE IF EXISTS `tbl_account`;
CREATE TABLE `tbl_account`
(
    `id`    int(11) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name`  varchar(255)             DEFAULT NULL COMMENT '账户名字',
    `money` int(8) unsigned zerofill DEFAULT NULL COMMENT '账户金额',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 8
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of tbl_account
-- ----------------------------
INSERT INTO `tbl_account`
VALUES ('00000000001', '账户A', '00000000');
INSERT INTO `tbl_account`
VALUES ('00000000002', '账户B', '00000000');
INSERT INTO `tbl_account`
VALUES ('00000000003', '账户C', '00000000');
INSERT INTO `tbl_account`
VALUES ('00000000004', '账户D', '00000000');
INSERT INTO `tbl_account`
VALUES ('00000000005', '手续账号', '00000000');
INSERT INTO `tbl_account`
VALUES ('00000000006', '张部国内账号', '00000100');
INSERT INTO `tbl_account`
VALUES ('00000000007', '张部的海外账户', '00000000');

-- ----------------------------
-- Table structure for tbl_book
-- ----------------------------
DROP TABLE IF EXISTS `tbl_book`;
CREATE TABLE `tbl_book`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `TYPE`        varchar(100) DEFAULT NULL,
    `NAME`        varchar(100) DEFAULT NULL,
    `description` varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of tbl_book
-- ----------------------------
INSERT INTO `tbl_book`
VALUES ('1', '计算机理论', 'Spring实战 第5版', 'Spring入门经典教材，深入理解Spring原理技术内幕');
INSERT INTO `tbl_book`
VALUES ('2', '计算机理论', 'Spring 5核心原理与30个类手写实战', '十年沉淀之作,手写Spring精华思想');
INSERT INTO `tbl_book`
VALUES ('3', '计算机理论', 'Spring 5设计模式', '深入Spring源码剖析,Spring源码蕴含的10大设计模式');
INSERT INTO `tbl_book`
VALUES ('4', '市场营销', '直播就该这么做:主播高效沟通实战指南', '李子柒、李佳琦、薇娅成长为网红的秘密都在书中');
INSERT INTO `tbl_book`
VALUES ('5', '市场营销', '直播销讲实战一本通', '和秋叶一起学系列网络营销书籍');
INSERT INTO `tbl_book`
VALUES ('6', '市场营销', '直播带货:淘宝、天猫直播从新手到高手', '一本教你如何玩转直播的书,10堂课轻松实现带货月入3W+');

-- ----------------------------
-- Table structure for tbl_log
-- ----------------------------
DROP TABLE IF EXISTS `tbl_log`;
CREATE TABLE `tbl_log`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `info`       varchar(255) DEFAULT NULL COMMENT '转账信息',
    `createDate` datetime     DEFAULT NULL COMMENT '发生时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 128
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of tbl_log
-- ----------------------------
INSERT INTO `tbl_log`
VALUES ('106', '转账操作由张部账号到账户A,金额：100.0', '2021-10-06 20:08:53');
INSERT INTO `tbl_log`
VALUES ('107', '转账操作由账户A到账户B,金额：100.0', '2021-10-06 20:08:53');
INSERT INTO `tbl_log`
VALUES ('108', '转账操作由账户B到账户C,金额：100.0', '2021-10-06 20:08:53');
INSERT INTO `tbl_log`
VALUES ('109', '转账操作由账户C到账户D,金额：100.0', '2021-10-06 20:08:53');
INSERT INTO `tbl_log`
VALUES ('110', '转账操作由账户D到张部账号,金额：100.0', '2021-10-06 20:08:53');
INSERT INTO `tbl_log`
VALUES ('111', '转账操作由张部账号到账户A,金额：100.0', '2021-10-06 20:09:10');
INSERT INTO `tbl_log`
VALUES ('112', '转账操作由账户A到账户B,金额：100.0', '2021-10-06 20:09:10');
INSERT INTO `tbl_log`
VALUES ('113', '转账操作由账户B到账户C,金额：100.0', '2021-10-06 20:09:10');
INSERT INTO `tbl_log`
VALUES ('114', '转账操作由账户C到账户D,金额：100.0', '2021-10-06 20:09:10');
INSERT INTO `tbl_log`
VALUES ('115', '转账操作由账户D到张部账号,金额：100.0', '2021-10-06 20:09:10');
INSERT INTO `tbl_log`
VALUES ('116', '转账操作由张部账号到账户A,金额：100.0', '2021-10-06 20:09:29');
INSERT INTO `tbl_log`
VALUES ('117', '转账操作由账户A到账户B,金额：100.0', '2021-10-06 20:09:29');
INSERT INTO `tbl_log`
VALUES ('118', '转账操作由账户B到账户C,金额：100.0', '2021-10-06 20:09:29');
INSERT INTO `tbl_log`
VALUES ('119', '转账操作由账户C到账户D,金额：100.0', '2021-10-06 20:09:29');
INSERT INTO `tbl_log`
VALUES ('120', '转账操作由张部账号到账户A,金额：100.0', '2021-10-06 20:10:20');
INSERT INTO `tbl_log`
VALUES ('121', '转账操作由张部账号到账户A,金额：100.0', '2021-10-06 20:11:05');
INSERT INTO `tbl_log`
VALUES ('122', '转账操作由张部账号到账户A,金额：100.0', '2021-10-06 20:11:24');
INSERT INTO `tbl_log`
VALUES ('123', '转账操作由账户A到账户B,金额：100.0', '2021-10-06 20:11:25');
INSERT INTO `tbl_log`
VALUES ('124', '转账操作由账户B到账户C,金额：100.0', '2021-10-06 20:11:25');
INSERT INTO `tbl_log`
VALUES ('125', '转账操作由账户C到账户D,金额：100.0', '2021-10-06 20:11:25');
INSERT INTO `tbl_log`
VALUES ('126', '转账操作由账户D到张部账号,金额：100.0', '2021-10-06 20:11:25');
INSERT INTO `tbl_log`
VALUES ('127', '转账操作由张部账号到账户A,金额：100.0', '2021-10-06 20:11:39');

-- ----------------------------
-- Table structure for tb_brand
-- ----------------------------
DROP TABLE IF EXISTS `tb_brand`;
CREATE TABLE `tb_brand`
(
    `id`           int(11) NOT NULL AUTO_INCREMENT,
    `brand_name`   varchar(20)  DEFAULT NULL,
    `company_name` varchar(20)  DEFAULT NULL,
    `ordered`      int(11)      DEFAULT NULL,
    `description`  varchar(100) DEFAULT NULL,
    `status`       int(11)      DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of tb_brand
-- ----------------------------
INSERT INTO `tb_brand`
VALUES ('1', '三只松鼠', '三只松鼠股份有限公司', '5', '好吃不上火', '0');
INSERT INTO `tb_brand`
VALUES ('2', '华为', '华为技术有限公司', '100', '华为致力于把数字世界带入每个人、每个家庭、每个组织，构建万物互联的智能世界', '1');
INSERT INTO `tb_brand`
VALUES ('3', '小米', '小米科技有限公司', '50', 'are you ok', '1');
INSERT INTO `tb_brand`
VALUES ('4', '问问', '我问问', '1', '啥', '0');
INSERT INTO `tb_brand`
VALUES ('5', '问问', '我问问', '1', '啥', '0');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`
(
    `id`       int(11) NOT NULL AUTO_INCREMENT,
    `username` varchar(20) DEFAULT NULL,
    `password` varchar(20) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user`
VALUES ('1', 'zhangsan', '123');
INSERT INTO `tb_user`
VALUES ('2', '李四', '234');
INSERT INTO `tb_user`
VALUES ('3', '王五', '11');
INSERT INTO `tb_user`
VALUES ('4', '18684811361', '123456');
