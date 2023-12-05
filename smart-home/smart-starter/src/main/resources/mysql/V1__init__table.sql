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
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(64) UNIQUE NULL DEFAULT NULL,
    `password` VARCHAR(64) NULL DEFAULT NULL,
    `icon` VARCHAR(500) NULL DEFAULT NULL COMMENT '头像',
    `email` VARCHAR(100) NULL DEFAULT NULL COMMENT '邮箱',
    `nick_name` VARCHAR(200) NULL DEFAULT NULL COMMENT '昵称',
    `note` VARCHAR(500) NULL DEFAULT NULL COMMENT '备注信息',
    `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `login_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '最后登录时间',
    `status` INT NULL DEFAULT 1 COMMENT '帐号启用状态：0->禁用；1->启用',
    PRIMARY KEY (`id`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
     `id` BIGINT NOT NULL AUTO_INCREMENT,
     `name` VARCHAR(100) NULL DEFAULT NULL COMMENT '名称',
     `description` VARCHAR(500) NULL DEFAULT NULL COMMENT '描述',
     `user_count` INT NULL DEFAULT NULL COMMENT '后台用户数量',
     `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
     `status` INT NULL DEFAULT 1 COMMENT '启用状态：0->禁用；1->启用',
     `sort` INT NULL DEFAULT 0,
     PRIMARY KEY (`id`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '后台用户角色表';


-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
     `id` BIGINT NOT NULL AUTO_INCREMENT,
     `parent_id` BIGINT NULL DEFAULT NULL COMMENT '父级ID',
     `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
     `title` VARCHAR(100) NULL DEFAULT NULL COMMENT '菜单名称',
     `level` INT NULL DEFAULT NULL COMMENT '菜单级数',
     `sort` INT NULL DEFAULT NULL COMMENT '菜单排序',
     `name` VARCHAR(100) NULL DEFAULT NULL COMMENT '前端名称',
     `icon` VARCHAR(200) NULL DEFAULT NULL COMMENT '前端图标',
     `hidden` INT NULL DEFAULT NULL COMMENT '前端隐藏',
     PRIMARY KEY (`id`) USING BTREE
)ENGINE = InnoDB DEFAULT CHARSET=utf8 COMMENT = '后台菜单表';

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission`  (
     `id` BIGINT NOT NULL AUTO_INCREMENT,
     `pid` BIGINT NULL DEFAULT NULL COMMENT '父级权限id',
     `name` VARCHAR(100) NULL DEFAULT NULL COMMENT '名称',
     `value` VARCHAR(200) NULL DEFAULT NULL COMMENT '权限值',
     `icon` VARCHAR(500) NULL DEFAULT NULL COMMENT '图标',
     `type` INT NULL DEFAULT NULL COMMENT '权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）',
     `uri` VARCHAR(200) NULL DEFAULT NULL COMMENT '前端资源路径',
     `status` INT NULL DEFAULT NULL COMMENT '启用状态；0->禁用；1->启用',
     `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
     `sort` INT NULL DEFAULT NULL COMMENT '排序',
     PRIMARY KEY (`id`) USING BTREE
)ENGINE = InnoDB DEFAULT CHARSET=utf8 COMMENT = '后台用户权限表';

-- ----------------------------
-- Table structure for t_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_resource`;
CREATE TABLE `t_resource`  (
     `id` BIGINT NOT NULL AUTO_INCREMENT,
     `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
     `name` VARCHAR(200) NULL DEFAULT NULL COMMENT '资源名称',
     `url` VARCHAR(200) NULL DEFAULT NULL COMMENT '资源URL',
     `description` VARCHAR(500) NULL DEFAULT NULL COMMENT '描述',
     `category_id` BIGINT NULL DEFAULT NULL COMMENT '资源分类ID',
     PRIMARY KEY (`id`) USING BTREE
)ENGINE = InnoDB DEFAULT CHARSET=utf8 COMMENT = '后台资源表';

-- ----------------------------
-- Table structure for t_resource_category
-- ----------------------------
DROP TABLE IF EXISTS `t_resource_category`;
CREATE TABLE `t_resource_category`  (
      `id` BIGINT NOT NULL AUTO_INCREMENT,
      `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
      `name` VARCHAR(200) NULL DEFAULT NULL COMMENT '分类名称',
      `sort` INT NULL DEFAULT NULL COMMENT '排序',
      PRIMARY KEY (`id`) USING BTREE
)ENGINE = InnoDB DEFAULT CHARSET=utf8 COMMENT = '资源分类表';


-- ----------------------------
-- Table structure for t_role_menu_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu_relation`;
CREATE TABLE `t_role_menu_relation`  (
     `id` BIGINT NOT NULL AUTO_INCREMENT,
     `role_id` BIGINT NULL DEFAULT NULL COMMENT '角色ID',
     `menu_id` BIGINT NULL DEFAULT NULL COMMENT '菜单ID',
     PRIMARY KEY (`id`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '后台角色菜单关系表';

-- ----------------------------
-- Table structure for t_role_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission_relation`;
CREATE TABLE `t_role_permission_relation`  (
     `id` BIGINT NOT NULL AUTO_INCREMENT,
     `role_id` BIGINT NULL DEFAULT NULL,
     `permission_id` BIGINT NULL DEFAULT NULL,
     PRIMARY KEY (`id`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '后台用户角色和权限关系表';

-- ----------------------------
-- Table structure for t_role_resource_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_role_resource_relation`;
CREATE TABLE `t_role_resource_relation`  (
     `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
     `role_id` BIGINT(20) NULL DEFAULT NULL COMMENT '角色ID',
     `resource_id` BIGINT(20) NULL DEFAULT NULL COMMENT '资源ID',
     PRIMARY KEY (`id`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '后台角色资源关系表';

-- ----------------------------
-- Table structure for ums_admin_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role_relation`;
CREATE TABLE `t_user_role_relation`  (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `admin_id` bigint(20) NULL DEFAULT NULL,
    `role_id` bigint(20) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '后台用户和角色关系表';

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
