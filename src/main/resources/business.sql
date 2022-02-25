/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : business

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2022-02-25 10:59:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `salt` varchar(255) NOT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '货主1号', 'e518b8b11df55194fe9f8598a848af6d', 'TzQG@P#7', '2022-02-10 14:09:26', '2022-02-10 14:09:26');
INSERT INTO `user_info` VALUES ('2', '测试测试', '1234556', '', '2022-02-08 14:54:21', '2022-02-10 13:24:03');
INSERT INTO `user_info` VALUES ('3', '货主2号', '123456', '', '2022-02-08 15:00:06', '2022-02-10 13:24:07');
INSERT INTO `user_info` VALUES ('4', '货主3号', '123456', '', '2022-02-08 15:08:23', '2022-02-08 15:08:23');
INSERT INTO `user_info` VALUES ('5', '管理员1号', 'eaf6494b4ba61597acd76529667f77b1', 'Rp!MY!S@', '2022-02-10 09:10:54', '2022-02-10 09:10:54');
INSERT INTO `user_info` VALUES ('7', 'tom', 'f01644c8ef56b677e8b7753099149b2b', 'kHtKM3fA', '2022-02-10 09:50:24', '2022-02-10 09:50:24');
INSERT INTO `user_info` VALUES ('10', '王五五', '403383d0bb5dbb144f02c721f040bfed', 'YvzjmmeN', '2022-02-10 13:17:55', '2022-02-10 13:17:55');
INSERT INTO `user_info` VALUES ('11', '承运商1号', '324e92636c37df28ca71cb1fb2e460ea', 'iZ5UTtYQ', '2022-02-10 13:58:02', '2022-02-10 13:58:02');
INSERT INTO `user_info` VALUES ('13', '杨文嘉', 'c415cc28c887928872ec29486e73af60', 'BwkY^$oz', '2022-02-16 10:33:46', '2022-02-16 10:33:46');

-- ----------------------------
-- Table structure for user_operationlog
-- ----------------------------
DROP TABLE IF EXISTS `user_operationlog`;
CREATE TABLE `user_operationlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `operator` varchar(255) DEFAULT NULL,
  `operate_method` varchar(255) DEFAULT NULL,
  `operation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `params` varchar(255) DEFAULT NULL,
  `operate_ip` varchar(255) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_update` datetime DEFAULT NULL,
  `is_deleted` tinyint(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_operationlog
-- ----------------------------
INSERT INTO `user_operationlog` VALUES ('1', 'TODO', 'com.example.business.controller.UserRoleController.assignRole', '给用户动态分配角色', '[1,1]', null, '2022-02-18 10:10:37', '2022-02-18 10:10:37', '0');
INSERT INTO `user_operationlog` VALUES ('2', '管理员1号', 'com.example.business.controller.UserRoleController.assignRole', '给用户动态分配角色', '[1,1]', '0:0:0:0:0:0:0:1', '2022-02-18 10:15:22', '2022-02-18 10:15:22', '0');
INSERT INTO `user_operationlog` VALUES ('3', '货主1号', 'com.example.business.controller.OrderController.listUserOrder', '通过统一返回的接口查询所有订单', '[]', '192.168.1.170', '2022-02-18 10:31:28', '2022-02-18 10:31:28', '0');
INSERT INTO `user_operationlog` VALUES ('4', '管理员1号', 'com.example.business.controller.UserRoleController.assignRole', '给用户动态分配角色', '[{\"roleid\":1,\"userid\":1}]', '0:0:0:0:0:0:0:1', '2022-02-25 09:47:06', '2022-02-25 09:47:06', '0');
INSERT INTO `user_operationlog` VALUES ('5', '管理员1号', 'com.example.business.controller.OrderController.listUserOrder', '通过统一返回的接口查询所有订单', '[]', '0:0:0:0:0:0:0:1', '2022-02-25 10:39:41', '2022-02-25 10:39:41', '0');

-- ----------------------------
-- Table structure for user_order
-- ----------------------------
DROP TABLE IF EXISTS `user_order`;
CREATE TABLE `user_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(255) NOT NULL,
  `con_username` varchar(255) NOT NULL,
  `supplier` varchar(255) NOT NULL,
  `money` decimal(10,0) NOT NULL,
  `start_place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `destination` varchar(255) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_update` datetime DEFAULT NULL,
  `is_deleted` tinyint(255) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_order
-- ----------------------------
INSERT INTO `user_order` VALUES ('1', 'DD2022020800001', '货主1号', '中国某某公司', '200', '四川省成都市', '四川省广元市', '2022-02-08 16:13:29', null, '0');
INSERT INTO `user_order` VALUES ('2', 'DD2022020800002', '货主2号', '中国某某有限公司', '100', '四川省成都市', '四川省广元市', '2022-02-08 16:25:35', '2022-02-08 16:25:35', '0');
INSERT INTO `user_order` VALUES ('3', 'DD2022020800003', '货主3号', '中国某某有限公司', '500', '四川省成都市', '四川省广元市', '2022-02-08 16:36:44', '2022-02-08 16:36:44', '1');
INSERT INTO `user_order` VALUES ('12', 'DD20220211000004', '测试有序', '中国XX公司', '333', '四川省广元市', '四川省成都市', '2022-02-11 23:13:03', '2022-02-11 23:13:03', '0');
INSERT INTO `user_order` VALUES ('13', 'DD2022021100005', '货主5', '中国有', '110', '光源', '四川', '2022-02-11 23:15:28', '2022-02-11 23:15:28', '0');
INSERT INTO `user_order` VALUES ('14', 'DD20220212000002', '货主1号', '中国某某公司', '10', 'string', 'string', '2022-02-12 16:04:29', '2022-02-12 16:04:29', '0');
INSERT INTO `user_order` VALUES ('16', 'DD20220212000004', '货主1号', '中国某某公司', '10', 'string', 'string', '2022-02-12 16:07:07', '2022-02-12 16:07:07', '0');
INSERT INTO `user_order` VALUES ('17', 'DD20220212000005', '货主1号', '中国某某公司', '220', 'string', 'string', '2022-02-12 16:10:34', '2022-02-12 16:10:34', '0');
INSERT INTO `user_order` VALUES ('23', 'DD20220216000001', '货主1号', '中国某某公司', '100', 'string', 'string', '2022-02-16 15:26:36', '2022-02-16 15:26:36', '0');
INSERT INTO `user_order` VALUES ('24', 'DD20220216000002', '货主1号', '中国某某公司', '100', 'string', 'string', '2022-02-16 15:27:09', '2022-02-16 15:27:09', '0');
INSERT INTO `user_order` VALUES ('25', 'DD20220216000003', '货主1号', '中国某某公司', '100', 'string', 'string', '2022-02-16 15:27:10', '2022-02-16 15:27:10', '0');
INSERT INTO `user_order` VALUES ('26', 'DD20220216000004', '货主1号', '中国某某公司', '100', 'string', 'string', '2022-02-16 15:27:10', '2022-02-16 15:27:10', '0');
INSERT INTO `user_order` VALUES ('27', 'DD20220216000005', '货主1号', '中国某某公司', '100', 'string', 'string', '2022-02-16 15:27:10', '2022-02-16 15:27:10', '0');
INSERT INTO `user_order` VALUES ('28', 'DD20220216000006', '货主1号', '中国某某公司', '100', 'string', 'string', '2022-02-16 15:27:10', '2022-02-16 15:27:10', '0');
INSERT INTO `user_order` VALUES ('29', 'DD20220216000007', '货主1号', '中国某某公司', '100', 'string', 'string', '2022-02-16 15:27:10', '2022-02-16 15:27:10', '0');
INSERT INTO `user_order` VALUES ('30', 'DD20220216000008', '货主1号', '中国某某公司', '100', 'string', 'string', '2022-02-16 15:27:10', '2022-02-16 15:27:10', '0');
INSERT INTO `user_order` VALUES ('31', 'DD20220216000009', '货主1号', '中国某某公司', '100', 'string', 'string', '2022-02-16 15:27:11', '2022-02-16 15:27:11', '0');
INSERT INTO `user_order` VALUES ('32', 'DD20220216000010', '货主1号', '中国某某公司', '100', 'string', 'string', '2022-02-16 15:27:11', '2022-02-16 15:27:11', '0');
INSERT INTO `user_order` VALUES ('33', 'DD20220216000011', '货主1号', '中国某某公司', '100', 'string', 'string', '2022-02-16 15:27:11', '2022-02-16 15:27:11', '0');
INSERT INTO `user_order` VALUES ('34', 'DD20220216000012', '货主1号', 'string', '100', 'string', 'string', '2022-02-16 15:27:11', '2022-02-16 15:27:11', '0');
INSERT INTO `user_order` VALUES ('35', 'DD20220216000013', '货主1号', 'string', '100', 'string', 'string', '2022-02-16 15:27:11', '2022-02-16 15:27:11', '0');
INSERT INTO `user_order` VALUES ('36', 'DD20220216000014', '货主1号', 'string', '100', 'string', 'string', '2022-02-16 15:27:12', '2022-02-16 15:27:12', '0');
INSERT INTO `user_order` VALUES ('37', 'DD20220216000015', '货主1号', 'string', '100', 'string', 'string', '2022-02-16 15:27:12', '2022-02-16 15:27:12', '0');
INSERT INTO `user_order` VALUES ('38', 'DD20220216000016', '货主1号', 'string', '100', 'string', 'string', '2022-02-16 15:27:20', '2022-02-16 15:27:20', '0');
INSERT INTO `user_order` VALUES ('39', 'DD20220216000017', '货主1号', 'string', '100', 'string', 'string', '2022-02-16 15:27:21', '2022-02-16 15:27:21', '0');
INSERT INTO `user_order` VALUES ('40', 'DD20220216000018', '货主1号', 'string', '100', 'string', 'string', '2022-02-16 15:27:21', '2022-02-16 15:27:21', '0');
INSERT INTO `user_order` VALUES ('41', 'DD20220216000019', '货主1号', 'string', '100', 'string', 'string', '2022-02-16 15:27:21', '2022-02-16 15:27:21', '0');
INSERT INTO `user_order` VALUES ('42', 'DD20220216000020', '货主1号', 'string', '100', 'string', 'string', '2022-02-16 15:27:21', '2022-02-16 15:27:21', '0');
INSERT INTO `user_order` VALUES ('43', 'DD20220216000021', '货主1号', 'string', '100', 'string', 'string', '2022-02-16 15:27:21', '2022-02-16 15:27:21', '0');
INSERT INTO `user_order` VALUES ('44', 'DD20220216000022', '货主1号', 'string', '100', 'string', 'string', '2022-02-16 15:27:21', '2022-02-16 15:27:21', '0');
INSERT INTO `user_order` VALUES ('45', 'DD20220216000023', '货主1号', 'string', '100', 'string', 'string', '2022-02-16 15:27:21', '2022-02-16 15:27:21', '0');
INSERT INTO `user_order` VALUES ('46', 'DD20220216000024', '货主1号', 'string', '100', 'string', 'string', '2022-02-16 15:27:22', '2022-02-16 15:27:22', '0');
INSERT INTO `user_order` VALUES ('47', 'DD20220216000025', '货主1号', 'string', '100', 'string', 'string', '2022-02-16 15:27:22', '2022-02-16 15:27:22', '0');
INSERT INTO `user_order` VALUES ('48', 'DD20220216000026', '货主1号', 'string', '100', 'string', 'string', '2022-02-16 15:27:22', '2022-02-16 15:27:22', '0');
INSERT INTO `user_order` VALUES ('49', 'DD20220216000027', '货主1号', 'string', '100', 'string', 'string', '2022-02-16 15:27:22', '2022-02-16 15:27:22', '0');
INSERT INTO `user_order` VALUES ('50', 'DD20220216000028', '货主1号', 'string', '100', 'string', 'string', '2022-02-16 15:27:22', '2022-02-16 15:27:22', '0');
INSERT INTO `user_order` VALUES ('51', 'DD20220216000029', '货主1号', 'string', '100', 'string', 'string', '2022-02-16 15:27:22', '2022-02-16 15:27:22', '0');
INSERT INTO `user_order` VALUES ('52', 'DD20220216000030', '货主1号', 'string', '100', 'string', 'string', '2022-02-16 15:27:23', '2022-02-16 15:27:23', '0');
INSERT INTO `user_order` VALUES ('53', 'DD20220216000031', '货主2号', 'string', '100', 'string', 'string', '2022-02-16 15:27:23', '2022-02-16 15:27:23', '0');
INSERT INTO `user_order` VALUES ('54', 'DD20220216000032', '货主2号', 'string', '100', 'string', 'string', '2022-02-16 15:27:23', '2022-02-16 15:27:23', '0');
INSERT INTO `user_order` VALUES ('55', 'DD20220216000033', '货主2号', 'string', '100', 'string', 'string', '2022-02-16 15:27:23', '2022-02-16 15:27:23', '0');
INSERT INTO `user_order` VALUES ('56', 'DD20220216000034', '货主2号', 'string', '100', 'string', 'string', '2022-02-16 15:27:23', '2022-02-16 15:27:23', '0');
INSERT INTO `user_order` VALUES ('57', 'DD20220216000035', '货主2号', 'string', '100', 'string', 'string', '2022-02-16 15:27:24', '2022-02-16 15:27:24', '0');
INSERT INTO `user_order` VALUES ('58', 'DD20220216000036', '货主2号', 'string', '100', 'string', 'string', '2022-02-16 15:27:24', '2022-02-16 15:27:24', '0');
INSERT INTO `user_order` VALUES ('59', 'DD20220216000037', '货主2号', 'string', '100', 'string', 'string', '2022-02-16 15:27:24', '2022-02-16 15:27:24', '0');
INSERT INTO `user_order` VALUES ('60', 'DD20220216000038', '货主2号', 'string', '100', 'string', 'string', '2022-02-16 15:27:24', '2022-02-16 15:27:24', '0');
INSERT INTO `user_order` VALUES ('61', 'DD20220216000039', '货主2号', 'string', '100', 'string', 'string', '2022-02-16 15:27:24', '2022-02-16 15:27:24', '0');
INSERT INTO `user_order` VALUES ('62', 'DD20220216000040', '货主2号', 'string', '100', 'string', 'string', '2022-02-16 15:27:24', '2022-02-16 15:27:24', '0');
INSERT INTO `user_order` VALUES ('63', 'DD20220216000041', '货主2号', 'string', '100', 'string', 'string', '2022-02-16 15:27:25', '2022-02-16 15:27:25', '0');
INSERT INTO `user_order` VALUES ('64', 'DD20220216000042', '货主2号', 'string', '100', 'string', 'string', '2022-02-16 15:27:25', '2022-02-16 15:27:25', '0');
INSERT INTO `user_order` VALUES ('65', 'DD20220216000043', '货主2号', 'string', '100', 'string', 'string', '2022-02-16 15:27:25', '2022-02-16 15:27:25', '0');
INSERT INTO `user_order` VALUES ('66', 'DD20220216000044', '货主2号', 'string', '100', 'string', 'string', '2022-02-16 15:27:25', '2022-02-16 15:27:25', '0');
INSERT INTO `user_order` VALUES ('67', 'DD20220216000045', '货主2号', 'string', '100', 'string', 'string', '2022-02-16 15:27:25', '2022-02-16 15:27:25', '0');
INSERT INTO `user_order` VALUES ('68', 'DD20220216000046', '货主2号', 'string', '100', 'string', 'string', '2022-02-16 15:27:26', '2022-02-16 15:27:26', '0');
INSERT INTO `user_order` VALUES ('69', 'DD20220216000047', '货主2号', 'string', '100', 'string', 'string', '2022-02-16 15:27:26', '2022-02-16 15:27:26', '0');
INSERT INTO `user_order` VALUES ('70', 'DD20220216000048', '货主2号', 'string', '100', 'string', 'string', '2022-02-16 15:27:26', '2022-02-16 15:27:26', '0');
INSERT INTO `user_order` VALUES ('71', 'DD20220216000049', '货主2号', 'string', '100', 'string', 'string', '2022-02-16 15:27:26', '2022-02-16 15:27:26', '0');
INSERT INTO `user_order` VALUES ('72', 'DD20220216000050', '货主2号', 'string', '100', 'string', 'string', '2022-02-16 15:27:26', '2022-02-16 15:27:26', '0');
INSERT INTO `user_order` VALUES ('73', 'DD20220216000051', '货主2号', 'string', '100', 'string', 'string', '2022-02-16 15:27:27', '2022-02-16 15:27:27', '0');
INSERT INTO `user_order` VALUES ('74', 'DD20220216000052', '货主2号', 'string', '100', 'string', 'string', '2022-02-16 15:27:27', '2022-02-16 15:27:27', '0');
INSERT INTO `user_order` VALUES ('75', 'DD20220216000053', '货主2号', 'string', '100', 'string', 'string', '2022-02-16 15:27:27', '2022-02-16 15:27:27', '0');
INSERT INTO `user_order` VALUES ('76', 'DD20220216000054', '货主2号', 'string', '100', 'string', 'string', '2022-02-16 15:27:27', '2022-02-16 15:27:27', '0');
INSERT INTO `user_order` VALUES ('77', 'DD20220216000055', '货主2号', 'string', '100', 'string', 'string', '2022-02-16 15:27:27', '2022-02-16 15:27:27', '0');
INSERT INTO `user_order` VALUES ('78', 'DD20220216000056', '货主2号', 'string', '100', 'string', 'string', '2022-02-16 15:27:28', '2022-02-16 15:27:28', '0');
INSERT INTO `user_order` VALUES ('79', 'DD20220216000057', '货主2号', 'string', '100', 'string', 'string', '2022-02-16 15:27:28', '2022-02-16 15:27:28', '0');
INSERT INTO `user_order` VALUES ('80', 'DD20220216000058', '货主2号', 'string', '100', 'string', 'string', '2022-02-16 15:27:28', '2022-02-16 15:27:28', '0');
INSERT INTO `user_order` VALUES ('81', 'DD20220216000059', '货主2号', 'string', '100', 'string', 'string', '2022-02-16 15:27:28', '2022-02-16 15:27:28', '0');

-- ----------------------------
-- Table structure for user_permission
-- ----------------------------
DROP TABLE IF EXISTS `user_permission`;
CREATE TABLE `user_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_permission
-- ----------------------------
INSERT INTO `user_permission` VALUES ('1', 'owner:publish:*', '发布货源', '2022-02-10 14:28:15', null);
INSERT INTO `user_permission` VALUES ('2', 'owner:speed:*', '催促订单', '2022-02-10 14:29:25', null);
INSERT INTO `user_permission` VALUES ('3', 'owner:update:*', '修改地址', '2022-02-10 14:55:47', null);
INSERT INTO `user_permission` VALUES ('4', 'owner:choice:*', '选择承运商', '2022-02-10 14:57:51', null);
INSERT INTO `user_permission` VALUES ('5', '*:see:*', '查看所有订单', '2022-02-16 13:47:31', null);
INSERT INTO `user_permission` VALUES ('6', 'carrier:see:*', '承运查看车辆及驾驶员信息', '2022-02-16 13:49:48', null);
INSERT INTO `user_permission` VALUES ('9', 'admin:*:*', '管理货主和承运商', '2022-02-16 13:50:27', null);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', 'owner', '货主：卖方', '2022-02-10 13:34:24', null);
INSERT INTO `user_role` VALUES ('2', 'carrier', '承运(人)商：运输公司或运输人员', '2022-02-10 13:34:28', null);
INSERT INTO `user_role` VALUES ('3', 'admin', '管理员：管理货主和承运商信息', '2022-02-16 13:51:05', null);

-- ----------------------------
-- Table structure for user_role_perms
-- ----------------------------
DROP TABLE IF EXISTS `user_role_perms`;
CREATE TABLE `user_role_perms` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleid` int(255) DEFAULT NULL,
  `permissionid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role_perms
-- ----------------------------
INSERT INTO `user_role_perms` VALUES ('1', '1', '1');
INSERT INTO `user_role_perms` VALUES ('2', '1', '2');
INSERT INTO `user_role_perms` VALUES ('3', '1', '3');
INSERT INTO `user_role_perms` VALUES ('4', '1', '4');
INSERT INTO `user_role_perms` VALUES ('5', '1', '5');
INSERT INTO `user_role_perms` VALUES ('6', '3', '9');
INSERT INTO `user_role_perms` VALUES ('9', '2', '5');
INSERT INTO `user_role_perms` VALUES ('10', '2', '6');

-- ----------------------------
-- Table structure for user_user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_user_role`;
CREATE TABLE `user_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_user_role
-- ----------------------------
INSERT INTO `user_user_role` VALUES ('1', '1', '1', '2022-02-16 10:24:27', null);
INSERT INTO `user_user_role` VALUES ('2', '11', '2', '2022-02-16 10:24:30', null);
INSERT INTO `user_user_role` VALUES ('7', '5', '3', '2022-02-16 13:51:50', null);
INSERT INTO `user_user_role` VALUES ('8', '7', '1', '2022-02-16 14:44:56', null);
