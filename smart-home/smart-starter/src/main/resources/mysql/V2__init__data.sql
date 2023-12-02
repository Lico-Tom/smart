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
INSERT INTO t_schedule_task (id, task_name, cron_expression, details) VALUES (1, "com.smart.task.ins.SummarySheetTask","0 0 2 1 * ? *", "月报分析");