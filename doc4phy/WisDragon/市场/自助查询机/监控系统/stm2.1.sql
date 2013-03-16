/*
Navicat MySQL Data Transfer

Source Server         : ؔ׺»�urce Server Version : 50509
Source Host           : 121.193.69.135:3306
Source Database       : stm2.1

Target Server Type    : MYSQL
Target Server Version : 50509
File Encoding         : 65001

Date: 2013-03-07 09:28:28
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `stm_baseinfo`
-- ----------------------------
DROP TABLE IF EXISTS `stm_baseinfo`;
CREATE TABLE `stm_baseinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(16) NOT NULL,
  `mac` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `position` varchar(64) DEFAULT NULL,
  `relayip` varchar(16) DEFAULT NULL,
  `port` int(11) DEFAULT NULL,
  `memo` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_stm_baseinfo_ip` (`ip`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of stm_baseinfo
-- ----------------------------
INSERT INTO `stm_baseinfo` VALUES ('13', '121.193.70.59', '00:E0:B1:1E:B8:F7', '网络中心玻璃厅(南)', '', '121.193.70.63', null, '');
INSERT INTO `stm_baseinfo` VALUES ('28', '121.193.70.17', '00:1E:90:6A:3E:8B', '办公室测试机器', '', '121.193.70.63', '6000', '');
INSERT INTO `stm_baseinfo` VALUES ('47', '121.193.70.58', '00:E0:B1:21:4C:4F', '网络中心玻璃厅北', '网络中心玻璃厅北', '121.193.70.63', '6000', '');
INSERT INTO `stm_baseinfo` VALUES ('100', '121.193.70.53', '18:A9:05:29:0F:FC', '测试本机', '本机', '121.193.70.53', null, null);

-- ----------------------------
-- Table structure for `stm_instruction`
-- ----------------------------
DROP TABLE IF EXISTS `stm_instruction`;
CREATE TABLE `stm_instruction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stm_id` int(11) NOT NULL,
  `shuttime` datetime NOT NULL,
  `instructiontype` varchar(16) NOT NULL,
  `interval` int(11) NOT NULL DEFAULT '0',
  `status` varchar(1) NOT NULL DEFAULT '0',
  `actiontime` datetime DEFAULT NULL,
  `result` varchar(64) DEFAULT NULL,
  `memo` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=401 DEFAULT CHARSET=gbk;



-- ----------------------------
-- Table structure for `stm_instructiontype`
-- ----------------------------
DROP TABLE IF EXISTS `stm_instructiontype`;
CREATE TABLE `stm_instructiontype` (
  `typeid` varchar(16) NOT NULL,
  `instruction_name` varchar(16) NOT NULL,
  `memo` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`typeid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of stm_instructiontype
-- ----------------------------
INSERT INTO `stm_instructiontype` VALUES ('1', '重启', null);
INSERT INTO `stm_instructiontype` VALUES ('2', '关机一段时间', null);
INSERT INTO `stm_instructiontype` VALUES ('3', '关机', null);
INSERT INTO `stm_instructiontype` VALUES ('4', '开机', null);

-- ----------------------------
-- Table structure for `stm_jarinfo`
-- ----------------------------
DROP TABLE IF EXISTS `stm_jarinfo`;
CREATE TABLE `stm_jarinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jarversion` varchar(0) DEFAULT NULL,
  `filename` varchar(0) DEFAULT NULL,
  `updatetime` time DEFAULT NULL,
  `file` blob,
  `memo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;



-- ----------------------------
-- Table structure for `stm_log`
-- ----------------------------
DROP TABLE IF EXISTS `stm_log`;
CREATE TABLE `stm_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stm_id` int(11) NOT NULL,
  `content` varchar(128) DEFAULT NULL,
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `memo` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=335350 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of stm_log
-- ----------------------------
 

-- ----------------------------
-- Table structure for `stm_op_log`
-- ----------------------------
DROP TABLE IF EXISTS `stm_op_log`;
CREATE TABLE `stm_op_log` (
  `id` int(11) NOT NULL,
  `stm_id` int(11) NOT NULL,
  `operation` varchar(16) NOT NULL,
  `optime` date NOT NULL,
  `status` varchar(1) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(16) DEFAULT NULL,
  `memo` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of stm_op_log
-- ----------------------------

-- ----------------------------
-- Table structure for `stm_scheduletask`
-- ----------------------------
DROP TABLE IF EXISTS `stm_scheduletask`;
CREATE TABLE `stm_scheduletask` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `stm_id` int(11) NOT NULL,
  `task_type_id` int(1) NOT NULL,
  `shutdown_time` datetime NOT NULL,
  `up_time` datetime DEFAULT NULL,
  `exec_unit` varchar(16) DEFAULT '',
  `task_memo` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=443 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of stm_scheduletask
-- ----------------------------
INSERT INTO `stm_scheduletask` VALUES ('237', '15', '1', '2011-06-21 21:00:00', null, 'DAY', '');
INSERT INTO `stm_scheduletask` VALUES ('238', '14', '1', '2011-06-21 21:00:00', null, 'DAY', '');
INSERT INTO `stm_scheduletask` VALUES ('241', '32', '1', '2011-06-21 21:00:00', null, 'DAY', '');
INSERT INTO `stm_scheduletask` VALUES ('440', '28', '1', '2013-01-09 23:00:42', null, '天', '');

-- ----------------------------
-- Table structure for `stm_sms_alarm`
-- ----------------------------
DROP TABLE IF EXISTS `stm_sms_alarm`;
CREATE TABLE `stm_sms_alarm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(64) NOT NULL,
  `sms_type` int(11) NOT NULL,
  `updatetime` datetime NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  `dealtime` datetime DEFAULT NULL,
  `memo` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of stm_sms_alarm
-- ----------------------------
INSERT INTO `stm_sms_alarm` VALUES ('1', '编号为：100的机器出现高温', '1', '2012-12-09 00:00:00', '1', null, '高温异常');
INSERT INTO `stm_sms_alarm` VALUES ('2', '编号为：100的机器出现高温', '1', '2012-10-29 21:12:55', '1', null, '高温异常');
INSERT INTO `stm_sms_alarm` VALUES ('3', '编号为：100的机器出现高温', '1', '2012-10-29 21:14:07', '1', null, '高温异常');
INSERT INTO `stm_sms_alarm` VALUES ('4', '编号为：100的机器出现高温', '1', '2012-10-29 21:15:15', '1', null, '高温异常');
INSERT INTO `stm_sms_alarm` VALUES ('5', '编号为：100的机器出现高温', '1', '2012-10-29 21:16:25', '1', null, '高温异常');
INSERT INTO `stm_sms_alarm` VALUES ('6', '编号为：100的机器出现高温', '1', '2012-10-29 21:17:35', '1', null, '高温异常');
INSERT INTO `stm_sms_alarm` VALUES ('7', '编号为：28的机器出现高温', '1', '2012-11-08 09:58:15', '1', null, '高温异常');
INSERT INTO `stm_sms_alarm` VALUES ('8', '设备名称：办公室测试机器的机器出现高温,温度51.18181818181818', '1', '2012-11-08 16:34:17', '1', null, '高温异常');
INSERT INTO `stm_sms_alarm` VALUES ('9', '设备名称：办公室测试机器的机器出现高温,温度52.00', '1', '2012-11-08 16:58:10', '1', null, '高温异常');
INSERT INTO `stm_sms_alarm` VALUES ('10', '设备名称：办公室测试机器的机器出现高温,温度47.09', '1', '2013-01-08 12:59:24', '1', null, '高温异常');
INSERT INTO `stm_sms_alarm` VALUES ('11', '设备名称：办公室测试机器的机器出现高温,温度48.09', '1', '2013-01-15 17:50:45', '1', null, '高温异常');
INSERT INTO `stm_sms_alarm` VALUES ('12', '设备名称：办公室测试机器的机器出现高温,温度48.23', '1', '2013-01-29 17:27:17', '1', null, '高温异常');
INSERT INTO `stm_sms_alarm` VALUES ('13', '设备名称：办公室测试机器的机器出现高温,温度48.68', '1', '2013-01-29 20:39:29', '1', null, '高温异常');

-- ----------------------------
-- Table structure for `stm_status`
-- ----------------------------
DROP TABLE IF EXISTS `stm_status`;
CREATE TABLE `stm_status` (
  `stm_id` int(11) NOT NULL,
  `status` varchar(16) NOT NULL,
  `updatetime` datetime NOT NULL,
  `memo` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`stm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of stm_status
-- ----------------------------
INSERT INTO `stm_status` VALUES ('13', 'up', '2012-07-26 16:21:11', '系统开机,服务程序运行');
INSERT INTO `stm_status` VALUES ('28', 'up', '2013-03-07 09:06:52', '系统开机,服务程序运行');
INSERT INTO `stm_status` VALUES ('47', 'up', '2012-10-18 06:30:48', '系统开机,服务程序运行');
INSERT INTO `stm_status` VALUES ('100', 'up', '2012-11-12 16:57:09', '状态实时更新，命令未执行');

-- ----------------------------
-- Table structure for `stm_taskresult`
-- ----------------------------
DROP TABLE IF EXISTS `stm_taskresult`;
CREATE TABLE `stm_taskresult` (
  `result_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_id` int(11) NOT NULL,
  `exec_result` char(1) DEFAULT '',
  `exec_time` date DEFAULT NULL,
  `result_memo` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`result_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of stm_taskresult
-- ----------------------------

-- ----------------------------
-- Table structure for `stm_tasktype`
-- ----------------------------
DROP TABLE IF EXISTS `stm_tasktype`;
CREATE TABLE `stm_tasktype` (
  `task_type_id` varchar(16) NOT NULL,
  `task_type_name` varchar(16) NOT NULL,
  `task_type_memo` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`task_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of stm_tasktype
-- ----------------------------
INSERT INTO `stm_tasktype` VALUES ('1', '关机', null);
INSERT INTO `stm_tasktype` VALUES ('2', '关机一段时间', null);

-- ----------------------------
-- Table structure for `stm_temp`
-- ----------------------------
DROP TABLE IF EXISTS `stm_temp`;
CREATE TABLE `stm_temp` (
  `stm_id` int(11) NOT NULL,
  `temp` double NOT NULL,
  `updatetime` datetime NOT NULL,
  `memo` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of stm_temp
-- ----------------------------
INSERT INTO `stm_temp` VALUES ('0', '0', '2012-12-21 10:28:15', '实时温度');
INSERT INTO `stm_temp` VALUES ('100', '0', '2012-11-12 17:05:41', '实时温度');
INSERT INTO `stm_temp` VALUES ('28', '45', '2013-03-07 09:27:54', '实时温度');

-- ----------------------------
-- Table structure for `stm_temp_log`
-- ----------------------------
DROP TABLE IF EXISTS `stm_temp_log`;
CREATE TABLE `stm_temp_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stm_id` int(11) NOT NULL,
  `temp` double NOT NULL,
  `updatetime` datetime NOT NULL,
  `memo` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1274 DEFAULT CHARSET=gbk ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of stm_temp_log
-- ----------------------------


-- ----------------------------
-- Table structure for `stm_user`
-- ----------------------------
DROP TABLE IF EXISTS `stm_user`;
CREATE TABLE `stm_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `landname` varchar(30) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `type` varchar(2) DEFAULT NULL,
  `remark` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of stm_user
-- ----------------------------

INSERT INTO `stm_user` VALUES ('32', '管理员', 'admin', '21232f297a57a5a743894a0e4a801fc3', '1', '管理员');

