/*
 * Source Server         : docker-mysql
 * Source Server Type    : MySQL
 * Source Server Version : 50734
 * Source Host           : localhost:3306
 * Source Schema         : smart-home

 * Target Server Type    : MySQL
 * Target Server Version : 50734
 * File Encoding         : 65001

 * Date: 05/11/2023 10:45:07
*/

-- ----------------------------
-- Table structure for t_schedule_task
-- ----------------------------
DROP TABLE IF EXISTS `t_schedule_task`;
CREATE TABLE `t_schedule_task` (
 `id` BIGINT PRIMARY KEY COMMENT 'id',
 `task_name` VARCHAR(200) NOT NULL COMMENT '任务名称',
 `cron_expression` VARCHAR(100) NOT NULL COMMENT '定时任务表达式',
 `details` VARCHAR(200) COMMENT '详情',
 `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 `modify_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_lock
-- ----------------------------
DROP TABLE IF EXISTS `t_lock`;
CREATE TABLE `t_lock` (
    `task_id` VARCHAR(500) PRIMARY KEY COMMENT '任务ID',
    `expire`  INT NOT NULL DEFAULT 5 COMMENT '锁存活时间',
    `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
    `username` VARCHAR(250) NOT NULL COMMENT '用户名',
    `password` VARCHAR(250) NOT NULL COMMENT '密码',
    `sid` BIGINT NOT NULL COMMENT '发件人员ID',
    `position` VARCHAR(250) NOT NULL COMMENT '发件人职位',
    `email` VARCHAR(250) NOT NULL COMMENT '发件人邮件',
    `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_recoder
-- ----------------------------
DROP TABLE IF EXISTS `t_recoder`;
CREATE TABLE `t_recoder` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
    `mid` BIGINT NOT NULL COMMENT '一个邮件对应一个mid',
    `mail` VARCHAR(250) NOT NULL COMMENT '邮件内容：包括收件人、主题、内容',
    `status` INT NOT NULL COMMENT '成功 0，失败 1',
    `persons` VARCHAR(250) NOT NULL COMMENT '相关人员列表',
    `files` VARCHAR(250) NOT NULL COMMENT '邮件中的文件对象'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ums_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
   `id` BIGINT NOT NULL AUTO_INCREMENT,
   `username` VARCHAR(64) NULL DEFAULT NULL,
   `password` VARCHAR(64) NULL DEFAULT NULL,
   `icon` VARCHAR(500)  NULL DEFAULT NULL COMMENT '头像',
   `email` VARCHAR(100) NULL DEFAULT NULL COMMENT '邮箱',
   `nick_name` VARCHAR(200) NULL DEFAULT NULL COMMENT '昵称',
   `note` VARCHAR(500) NULL DEFAULT NULL COMMENT '备注信息',
   `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   `login_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '最后登录时间',
   `status` INT NULL DEFAULT 1 COMMENT '帐号启用状态：0->禁用；1->启用',
   PRIMARY KEY (`id`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '后台用户表';
