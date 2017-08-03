/*
Navicat MySQL Data Transfer

Source Server         : Localhost
Source Server Version : 50630
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50630
File Encoding         : 65001

Date: 2016-11-30 17:20:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for classs
-- ----------------------------
DROP TABLE IF EXISTS `classs`;
CREATE TABLE `classs` (
  `c_uuid` varchar(18) NOT NULL,
  `c_name` varchar(255) NOT NULL,
  PRIMARY KEY (`c_uuid`,`c_name`),
  UNIQUE KEY `sy_c_name` (`c_name`) USING BTREE COMMENT '唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classs
-- ----------------------------
INSERT INTO `classs` VALUES ('24838094943420421', '计应143');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_uuid` varchar(36) NOT NULL,
  `username` varchar(18) NOT NULL,
  `password` varchar(18) NOT NULL,
  `is_delete` int(1) NOT NULL COMMENT '0 是',
  `create_date` datetime(6) DEFAULT NULL,
  `c_uuid` varchar(36) NOT NULL,
  PRIMARY KEY (`u_uuid`,`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('24838094943420424', 'adminstrator', 'soft', '1', '2016-11-30 17:10:02.896000', '24838094943420421');
