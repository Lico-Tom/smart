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
CREATE TABLE IF NOT EXISTS `t_schedule_task` (
 `id` BIGINT PRIMARY KEY COMMENT 'id',
 `task_name` VARCHAR(200) NOT NULL COMMENT '任务名称',
 `cron_expression` VARCHAR(100) NOT NULL COMMENT '定时任务表达式',
 `details` VARCHAR(200) COMMENT '详情',
 `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 `modify_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间'
);

-- ----------------------------
-- Table structure for t_lock
-- ----------------------------
CREATE TABLE IF NOT EXISTS `t_lock` (
    `task_id` VARCHAR(500) PRIMARY KEY COMMENT '任务ID',
    `expire`  INT NOT NULL DEFAULT 5 COMMENT '锁存活时间',
    `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
CREATE TABLE IF NOT EXISTS `t_user` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    `username` VARCHAR(64) NOT NULL UNIQUE COMMENT '用户名',
    `password` VARCHAR(64) NULL DEFAULT NULL COMMENT '密码',
    `icon` VARCHAR(500) NULL DEFAULT NULL COMMENT '头像',
    `email` VARCHAR(100) NULL DEFAULT NULL COMMENT '邮箱',
    `nick_name` VARCHAR(200) NULL DEFAULT NULL COMMENT '昵称',
    `note` VARCHAR(500) NULL DEFAULT NULL COMMENT '备注信息',
    `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `login_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '最后登录时间',
    `status` INT NULL DEFAULT 1 COMMENT '帐号启用状态：0->禁用；1->启用'
);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
CREATE TABLE IF NOT EXISTS `t_role`  (
     `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
     `name` VARCHAR(100) NULL DEFAULT NULL COMMENT '名称',
     `description` VARCHAR(500) NULL DEFAULT NULL COMMENT '描述',
     `user_count` INT NULL DEFAULT NULL COMMENT '后台用户数量',
     `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
     `status` INT NULL DEFAULT 1 COMMENT '启用状态：0->禁用；1->启用',
     `sort` INT NULL DEFAULT 0
);


-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
CREATE TABLE IF NOT EXISTS `t_menu` (
     `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
     `parent_id` BIGINT NULL DEFAULT NULL COMMENT '父级ID',
     `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
     `title` VARCHAR(100) NULL DEFAULT NULL COMMENT '菜单名称',
     `level` INT NULL DEFAULT NULL COMMENT '菜单级数',
     `sort` INT NULL DEFAULT NULL COMMENT '菜单排序',
     `name` VARCHAR(100) NULL DEFAULT NULL COMMENT '前端名称',
     `icon` VARCHAR(200) NULL DEFAULT NULL COMMENT '前端图标',
     `hidden` INT NULL DEFAULT NULL COMMENT '前端隐藏'
);

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
CREATE TABLE IF NOT EXISTS `t_permission` (
     `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
     `pid` BIGINT NULL DEFAULT NULL COMMENT '父级权限id',
     `name` VARCHAR(100) NULL DEFAULT NULL COMMENT '名称',
     `value` VARCHAR(200) NULL DEFAULT NULL COMMENT '权限值',
     `icon` VARCHAR(500) NULL DEFAULT NULL COMMENT '图标',
     `type` INT NULL DEFAULT NULL COMMENT '权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）',
     `uri` VARCHAR(200) NULL DEFAULT NULL COMMENT '前端资源路径',
     `status` INT NULL DEFAULT NULL COMMENT '启用状态；0->禁用；1->启用',
     `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
     `sort` INT NULL DEFAULT NULL COMMENT '排序'
);

-- ----------------------------
-- Table structure for t_resource
-- ----------------------------
CREATE TABLE IF NOT EXISTS `t_resource` (
     `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
     `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
     `name` VARCHAR(200) NULL DEFAULT NULL COMMENT '资源名称',
     `url` VARCHAR(200) NULL DEFAULT NULL COMMENT '资源URL',
     `description` VARCHAR(500) NULL DEFAULT NULL COMMENT '描述',
     `category_id` BIGINT NULL DEFAULT NULL COMMENT '资源分类ID'
);

-- ----------------------------
-- Table structure for t_resource_category
-- ----------------------------
CREATE TABLE IF NOT EXISTS `t_resource_category`  (
      `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
      `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
      `name` VARCHAR(200) NULL DEFAULT NULL COMMENT '分类名称',
      `sort` INT NULL DEFAULT NULL COMMENT '排序'
);


-- ----------------------------
-- Table structure for t_role_menu_relation
-- ----------------------------
CREATE TABLE IF NOT EXISTS `t_role_menu_relation`  (
     `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
     `role_id` BIGINT NULL DEFAULT NULL COMMENT '角色ID',
     `menu_id` BIGINT NULL DEFAULT NULL COMMENT '菜单ID'
);

-- ----------------------------
-- Table structure for t_role_permission_relation
-- ----------------------------
CREATE TABLE IF NOT EXISTS `t_role_permission_relation` (
     `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
     `role_id` BIGINT NULL DEFAULT NULL,
     `permission_id` BIGINT NULL DEFAULT NULL
);

-- ----------------------------
-- Table structure for t_role_resource_relation
-- ----------------------------
CREATE TABLE IF NOT EXISTS `t_role_resource_relation`  (
     `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
     `role_id` BIGINT NULL DEFAULT NULL COMMENT '角色ID',
     `resource_id` BIGINT NULL DEFAULT NULL COMMENT '资源ID'
);

-- ----------------------------
-- Table structure for ums_admin_role_relation
-- ----------------------------
CREATE TABLE IF NOT EXISTS `t_user_role_relation`  (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    `admin_id` BIGINT NULL DEFAULT NULL,
    `role_id` BIGINT NULL DEFAULT NULL
);

-- ----------------------------
-- Table structure for t_recoder
-- ----------------------------
CREATE TABLE IF NOT EXISTS `t_recoder` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
    `mid` BIGINT NOT NULL COMMENT '一个邮件对应一个mid',
    `mail` VARCHAR(250) NOT NULL COMMENT '邮件内容：包括收件人、主题、内容',
    `status` INT NOT NULL COMMENT '成功 0，失败 1',
    `persons` VARCHAR(250) NOT NULL COMMENT '相关人员列表',
    `files` VARCHAR(250) NOT NULL COMMENT '邮件中的文件对象'
);

-- ----------------------------
-- Table structure for t_pig_state
-- ----------------------------
CREATE TABLE IF NOT EXISTS `t_pig_state` (
   `id` BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
   `parent` BIGINT NULL COMMENT '生产该仔的母猪',
   `start_weight` INT NOT NULL COMMENT '出生体重',
   `end_weight` BIGINT NULL COMMENT '出栏体重',
   `price` BIGINT NULL COMMENT '出栏单价',
   `purchaser` VARCHAR(200) NULL COMMENT '购买者',
   `phone_number` INT NULL COMMENT '电话号码',
   `bills` BINARY NOT NULL COMMENT '单据图片',
   `spend` BIGINT NULL COMMENT '饲养花费',
   `pigsty_number` BIGINT NOT NULL COMMENT '猪栏编号',
   `birthday`  datetime NULL DEFAULT NULL COMMENT '出生日期',
   `sell_date`  datetime NULL DEFAULT NULL COMMENT '出栏日期'
);

-- ----------------------------
-- Table structure for t_pig_pigsty
-- ----------------------------
CREATE TABLE IF NOT EXISTS `t_pig_pigsty` (
   `id` BIGINT PRIMARY KEY COMMENT 'ID',
   `length` INT NOT NULL COMMENT '猪栏的长',
   `wide` BIGINT NOT NULL COMMENT '猪栏的宽'
);

-- ----------------------------
-- Table structure for t_pig_pigsty_feed
-- ----------------------------
CREATE TABLE IF NOT EXISTS `t_pig_pigsty_feed` (
   `id` BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
   `brand_id` BIGINT NULL COMMENT '猪饲料品牌ID',
   `pigsty_number` BIGINT NOT NULL COMMENT '猪栏编号',
   `feed_weight` INT NOT NULL COMMENT '每天使用的饲料量',
   `day` datetime NULL DEFAULT NULL COMMENT '天'
);

-- ----------------------------
-- Table structure for t_pig_feed_brand
-- ----------------------------
CREATE TABLE IF NOT EXISTS `t_pig_feed_brand` (
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
  `brand_name` VARCHAR(100) NULL COMMENT '猪饲料品牌名'
);

-- ----------------------------
-- Table structure for t_pig_feed_price
-- ----------------------------
CREATE TABLE IF NOT EXISTS `t_pig_feed_price` (
   `id` BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
   `brand_id` INT NULL COMMENT '猪饲料品牌',
   `price` INT NOT NULL COMMENT '价格',
   `day` datetime NULL DEFAULT NULL COMMENT '天'
);

-- ----------------------------
-- Table structure for t_pig_feed_total
-- ----------------------------
CREATE TABLE IF NOT EXISTS `t_pig_feed_total` (
   `id` BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
   `brand_id` INT NULL COMMENT '猪饲料品牌',
   `selling_unit` VARCHAR(200) NULL COMMENT '售卖单位',
   `phone_number` INT NULL COMMENT '电话号码',
   `bills` binary NOT NULL COMMENT '单据图片',
   `buy_total` INT NOT NULL COMMENT '购入总量/包',
   `residue_total` INT NOT NULL COMMENT '剩余总量/包',
   `price` INT NOT NULL COMMENT '购入时/单价',
   `production_date` datetime NULL DEFAULT NULL COMMENT '生产日期',
   `shelf_life` INT NOT NULL COMMENT '保质期/天',
   `expired_alert` INT NOT NULL COMMENT '距离多久过期告警/天'
);

-- ----------------------------
-- Table structure for t_pig_feed
-- ----------------------------
CREATE TABLE IF NOT EXISTS `t_pig_feed` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
    `total_id` INT NULL COMMENT '批次ID',
    `is_expired` INT NOT NULL DEFAULT 1 COMMENT '1表示没过期，0表示过期',
    `consumer_date` datetime NULL DEFAULT NULL COMMENT '消费日期'
);

-- ----------------------------
-- Table structure for t_pig_temperature
-- ----------------------------
CREATE TABLE IF NOT EXISTS `t_pig_temperature` (
   `id` BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
   `pig_id` BIGINT NULL COMMENT '猪id',
   `temperature` INT NOT NULL COMMENT '体温°C',
   `detection_time` datetime NULL DEFAULT NULL COMMENT '称重时间'
);

-- ----------------------------
-- Table structure for t_pig_weight
-- ----------------------------
CREATE TABLE IF NOT EXISTS `t_pig_weight` (
   `id` BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
   `pig_id` BIGINT NULL COMMENT '猪id',
   `weight` INT NOT NULL COMMENT '猪的重量',
   `detection_time` datetime NULL DEFAULT NULL COMMENT '称重时间'
);

-- ----------------------------
-- Table structure for t_mqtt
-- ----------------------------
CREATE TABLE IF NOT EXISTS `t_mqtt` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
    `mqtt_addr` VARCHAR(255) NULL COMMENT 'mqtt地址',
    `mqtt_username` VARCHAR(255) NOT NULL COMMENT '账号',
    `mqtt_passwd` VARCHAR(255) NOT NULL COMMENT '加密密码',
    `connect_timeout` INT NOT NULL COMMENT '连接超时时间',
    `keepalive_interval` INT NOT NULL COMMENT '存活时间',
    `automatic_reconnect` BIT NOT NULL COMMENT '自动尝试连接 0 true 1 false',
    `clean_session` BIT NOT NULL COMMENT '重连是是否记住状态',
    `mqtt_describe` VARCHAR(255) NOT NULL COMMENT '描述',
    `is_valid` BIT NOT NULL COMMENT '是否有效地址',
    `detection_time` datetime NULL DEFAULT NULL COMMENT '创建时间'
);

-- ----------------------------
-- Table structure for t_mqtt_sub
-- ----------------------------
CREATE TABLE IF NOT EXISTS `t_mqtt_sub` (
   `id` BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
   `mqtt_id` BIGINT NOT NULL COMMENT 'mqtt的id',
   `mqtt_topic` VARCHAR(255) NOT NULL COMMENT '订阅主题名',
   `mqtt_qos` BIT NOT NULL COMMENT '订阅模式',
   `is_valid` BIT NOT NULL COMMENT '是否有效订阅',
   `detection_time` datetime NULL DEFAULT NULL COMMENT '创建时间'
);

-- ----------------------------
-- Table structure for t_mqtt_pub
-- ----------------------------
CREATE TABLE IF NOT EXISTS `t_mqtt_pub` (
   `id` BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
   `mqtt_id` BIGINT NOT NULL COMMENT 'mqtt的id',
   `mqtt_topic` VARCHAR(255) NOT NULL COMMENT '发布主题名',
   `mqtt_qos` BIT NOT NULL COMMENT '订阅模式',
   `is_valid` BIT NOT NULL COMMENT '是否有效发布主题',
   `level` BIT NOT NULL COMMENT '控制等级',
   `detection_time` datetime NULL DEFAULT NULL COMMENT '创建时间'
);

-- ----------------------------
-- Table structure for t_mqtt_history
-- ----------------------------
CREATE TABLE IF NOT EXISTS `t_mqtt_history` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
    `sub_ip` VARCHAR(100) NOT NULL COMMENT '订阅者的ip',
    `pub_ip` VARCHAR(100) NOT NULL COMMENT '消费者的ip',
    `mqtt_topic` VARCHAR(255) NOT NULL COMMENT '发布主题名',
    `mqtt_qos` BIT NOT NULL COMMENT '订阅模式',
    `is_success` BIT NOT NULL COMMENT '是否发送或接收成功',
    `mqtt_msg` VARCHAR(255) NOT NULL COMMENT '发送或接收的消息',
    `detection_time` datetime NULL DEFAULT NULL COMMENT '创建时间'
);
