create database sys;

use sys;
/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : ecs

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-05-14 13:33:18
*/

-- ----------------------------
-- Table structure for ecs
-- ----------------------------
DROP TABLE IF EXISTS `ecs`;
CREATE TABLE `ecs` (
  `ecs_ip` varchar(255) NOT NULL,
  `ecs_name` varchar(50) NOT NULL,
  `ecs_password` varchar(255) NOT NULL,
  `ecs_port` int(11) NOT NULL DEFAULT '22',
  `ecs_last_login` varchar(255) DEFAULT NULL,
  `ecs_desc` char(200) DEFAULT '',
  `ecs_create_time` datetime NOT NULL,
  `user_id` varchar(50) NOT NULL,
  PRIMARY KEY (`ecs_ip`),
  KEY `ecs_user` (`user_id`),
  CONSTRAINT `ecs_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ecs
-- ----------------------------
INSERT INTO `ecs` VALUES ('192.168.1.1', 'local', '123456', '22', null, 'localTest', '2017-05-06 16:52:09', '1');

-- ----------------------------
-- Table structure for ecs_detail
-- ----------------------------
DROP TABLE IF EXISTS `ecs_detail`;
CREATE TABLE `ecs_detail` (
  `ip` varchar(50) NOT NULL,
  `time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `cpu_rate` double DEFAULT NULL,
  `net_in` double DEFAULT NULL COMMENT '网络流入带宽',
  `net_out` double DEFAULT NULL COMMENT '网络流出带宽',
  `ipos` int(11) DEFAULT NULL COMMENT '每秒读写操作次数(window为c盘)',
  `memory_rate` double DEFAULT NULL COMMENT '内存使用率',
  `average_load` double DEFAULT NULL COMMENT '平均负载',
  `kb_reads` double DEFAULT NULL COMMENT '磁盘IO(读)',
  `kb_writes` double DEFAULT NULL COMMENT '磁盘IO(写)',
  `disk_usage` double DEFAULT NULL COMMENT '磁盘使用率',
  PRIMARY KEY (`ip`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ecs_detail
-- ----------------------------

-- ----------------------------
-- Table structure for ecs_info
-- ----------------------------
DROP TABLE IF EXISTS `ecs_info`;
CREATE TABLE `ecs_info` (
  `ip` varchar(50) NOT NULL,
  `cpu_nums` int(11) NOT NULL,
  `memory` int(11) DEFAULT NULL COMMENT '单位GB',
  `os` varchar(100) DEFAULT NULL COMMENT '操作系统',
  `mbps` int(11) DEFAULT NULL COMMENT '带宽'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ecs_info
-- ----------------------------
INSERT INTO `ecs_info` VALUES ('192.168.1.1', '1', '10241024', 'Linux', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(50) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `user_password` varchar(255) NOT NULL,
  `user_ecs_nums` int(10) unsigned zerofill NOT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_phone` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'likang', '123456', '0000000001', null, null);
SET FOREIGN_KEY_CHECKS=1;
