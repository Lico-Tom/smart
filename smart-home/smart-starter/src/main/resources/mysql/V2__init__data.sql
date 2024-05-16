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
-- Records of t_schedule_task
-- ----------------------------
INSERT INTO t_schedule_task (id, task_name, cron_expression, details) VALUES (1, 'com.smart.task.ins.SummarySheetTask','0 0 2 1 * ? *', '月报分析');

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` (id, name, description, user_count, status, sort) VALUES (1, '商品管理员', '只能查看及操作商品', 0, 1, 0);
INSERT INTO `t_role` (id, name, description, user_count, status, sort) VALUES (2, '订单管理员', '只能查看及操作订单', 0, 1, 0);
INSERT INTO `t_role` (id, name, description, user_count, status, sort) VALUES (5, '超级管理员', '拥有所有查看和操作功能', 0, 1, 0);

-- ----------------------------
-- Records of t_role_menu_relation
-- ----------------------------
INSERT INTO `t_role_menu_relation` VALUES (53, 2, 7);
INSERT INTO `t_role_menu_relation` VALUES (54, 2, 8);
INSERT INTO `t_role_menu_relation` VALUES (55, 2, 9);
INSERT INTO `t_role_menu_relation` VALUES (56, 2, 10);
INSERT INTO `t_role_menu_relation` VALUES (57, 2, 11);
INSERT INTO `t_role_menu_relation` VALUES (72, 5, 1);
INSERT INTO `t_role_menu_relation` VALUES (73, 5, 2);
INSERT INTO `t_role_menu_relation` VALUES (74, 5, 3);
INSERT INTO `t_role_menu_relation` VALUES (75, 5, 4);
INSERT INTO `t_role_menu_relation` VALUES (76, 5, 5);
INSERT INTO `t_role_menu_relation` VALUES (77, 5, 6);
INSERT INTO `t_role_menu_relation` VALUES (78, 5, 7);
INSERT INTO `t_role_menu_relation` VALUES (79, 5, 8);
INSERT INTO `t_role_menu_relation` VALUES (80, 5, 9);
INSERT INTO `t_role_menu_relation` VALUES (81, 5, 10);
INSERT INTO `t_role_menu_relation` VALUES (82, 5, 11);
INSERT INTO `t_role_menu_relation` VALUES (83, 5, 12);
INSERT INTO `t_role_menu_relation` VALUES (84, 5, 13);
INSERT INTO `t_role_menu_relation` VALUES (85, 5, 14);
INSERT INTO `t_role_menu_relation` VALUES (86, 5, 16);
INSERT INTO `t_role_menu_relation` VALUES (87, 5, 17);
INSERT INTO `t_role_menu_relation` VALUES (88, 5, 18);
INSERT INTO `t_role_menu_relation` VALUES (89, 5, 19);
INSERT INTO `t_role_menu_relation` VALUES (90, 5, 20);
INSERT INTO `t_role_menu_relation` VALUES (91, 5, 21);
INSERT INTO `t_role_menu_relation` VALUES (92, 5, 22);
INSERT INTO `t_role_menu_relation` VALUES (93, 5, 23);
INSERT INTO `t_role_menu_relation` VALUES (94, 5, 24);
INSERT INTO `t_role_menu_relation` VALUES (95, 5, 25);
INSERT INTO `t_role_menu_relation` VALUES (121, 1, 1);
INSERT INTO `t_role_menu_relation` VALUES (122, 1, 2);
INSERT INTO `t_role_menu_relation` VALUES (123, 1, 3);
INSERT INTO `t_role_menu_relation` VALUES (124, 1, 4);
INSERT INTO `t_role_menu_relation` VALUES (125, 1, 5);
INSERT INTO `t_role_menu_relation` VALUES (126, 1, 6);


-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES (1, 0, '2020-02-02 14:50:36', '商品', 0, 0, 'pms', 'product', 0);
INSERT INTO `t_menu` VALUES (2, 1, '2020-02-02 14:51:50', '商品列表', 1, 0, 'product', 'product-list', 0);
INSERT INTO `t_menu` VALUES (3, 1, '2020-02-02 14:52:44', '添加商品', 1, 0, 'addProduct', 'product-add', 0);
INSERT INTO `t_menu` VALUES (4, 1, '2020-02-02 14:53:51', '商品分类', 1, 0, 'productCate', 'product-cate', 0);
INSERT INTO `t_menu` VALUES (5, 1, '2020-02-02 14:54:51', '商品类型', 1, 0, 'productAttr', 'product-attr', 0);
INSERT INTO `t_menu` VALUES (6, 1, '2020-02-02 14:56:29', '品牌管理', 1, 0, 'brand', 'product-brand', 0);
INSERT INTO `t_menu` VALUES (7, 0, '2020-02-02 16:54:07', '订单', 0, 0, 'oms', 'order', 0);
INSERT INTO `t_menu` VALUES (8, 7, '2020-02-02 16:55:18', '订单列表', 1, 0, 'order', 'product-list', 0);
INSERT INTO `t_menu` VALUES (9, 7, '2020-02-02 16:56:46', '订单设置', 1, 0, 'orderSetting', 'order-setting', 0);
INSERT INTO `t_menu` VALUES (10, 7, '2020-02-02 16:57:39', '退货申请处理', 1, 0, 'returnApply', 'order-return', 0);
INSERT INTO `t_menu` VALUES (11, 7, '2020-02-02 16:59:40', '退货原因设置', 1, 0, 'returnReason', 'order-return-reason', 0);
INSERT INTO `t_menu` VALUES (12, 0, '2020-02-04 16:18:00', '营销', 0, 0, 'sms', 'sms', 0);
INSERT INTO `t_menu` VALUES (13, 12, '2020-02-04 16:19:22', '秒杀活动列表', 1, 0, 'flash', 'sms-flash', 0);
INSERT INTO `t_menu` VALUES (14, 12, '2020-02-04 16:20:16', '优惠券列表', 1, 0, 'coupon', 'sms-coupon', 0);
INSERT INTO `t_menu` VALUES (16, 12, '2020-02-07 16:22:38', '品牌推荐', 1, 0, 'homeBrand', 'product-brand', 0);
INSERT INTO `t_menu` VALUES (17, 12, '2020-02-07 16:23:14', '新品推荐', 1, 0, 'homeNew', 'sms-new', 0);
INSERT INTO `t_menu` VALUES (18, 12, '2020-02-07 16:26:38', '人气推荐', 1, 0, 'homeHot', 'sms-hot', 0);
INSERT INTO `t_menu` VALUES (19, 12, '2020-02-07 16:28:16', '专题推荐', 1, 0, 'homeSubject', 'sms-subject', 0);
INSERT INTO `t_menu` VALUES (20, 12, '2020-02-07 16:28:42', '广告列表', 1, 0, 'homeAdvertise', 'sms-ad', 0);
INSERT INTO `t_menu` VALUES (21, 0, '2020-02-07 16:29:13', '权限', 0, 0, 'ums', 'ums', 0);
INSERT INTO `t_menu` VALUES (22, 21, '2020-02-07 16:29:51', '用户列表', 1, 0, 'admin', 'ums-admin', 0);
INSERT INTO `t_menu` VALUES (23, 21, '2020-02-07 16:30:13', '角色列表', 1, 0, 'role', 'ums-role', 0);
INSERT INTO `t_menu` VALUES (24, 21, '2020-02-07 16:30:53', '菜单列表', 1, 0, 'menu', 'ums-menu', 0);
INSERT INTO `t_menu` VALUES (25, 21, '2020-02-07 16:31:13', '资源列表', 1, 0, 'resource', 'ums-resource', 0);

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES (1, 0, '商品', NULL, NULL, 0, NULL, 1, '2018-09-29 16:15:14', 0);
INSERT INTO `t_permission` VALUES (2, 1, '商品列表', 'pms:product:read', NULL, 1, '/pms/product/index', 1, '2018-09-29 16:17:01', 0);
INSERT INTO `t_permission` VALUES (3, 1, '添加商品', 'pms:product:create', NULL, 1, '/pms/product/add', 1, '2018-09-29 16:18:51', 0);
INSERT INTO `t_permission` VALUES (4, 1, '商品分类', 'pms:productCategory:read', NULL, 1, '/pms/productCate/index', 1, '2018-09-29 16:23:07', 0);
INSERT INTO `t_permission` VALUES (5, 1, '商品类型', 'pms:productAttribute:read', NULL, 1, '/pms/productAttr/index', 1, '2018-09-29 16:24:43', 0);
INSERT INTO `t_permission` VALUES (6, 1, '品牌管理', 'pms:brand:read', NULL, 1, '/pms/brand/index', 1, '2018-09-29 16:25:45', 0);
INSERT INTO `t_permission` VALUES (7, 2, '编辑商品', 'pms:product:update', NULL, 2, '/pms/product/updateProduct', 1, '2018-09-29 16:34:23', 0);
INSERT INTO `t_permission` VALUES (8, 2, '删除商品', 'pms:product:delete', NULL, 2, '/pms/product/delete', 1, '2018-09-29 16:38:33', 0);
INSERT INTO `t_permission` VALUES (9, 4, '添加商品分类', 'pms:productCategory:create', NULL, 2, '/pms/productCate/create', 1, '2018-09-29 16:43:23', 0);
INSERT INTO `t_permission` VALUES (10, 4, '修改商品分类', 'pms:productCategory:update', NULL, 2, '/pms/productCate/update', 1, '2018-09-29 16:43:55', 0);
INSERT INTO `t_permission` VALUES (11, 4, '删除商品分类', 'pms:productCategory:delete', NULL, 2, '/pms/productAttr/delete', 1, '2018-09-29 16:44:38', 0);
INSERT INTO `t_permission` VALUES (12, 5, '添加商品类型', 'pms:productAttribute:create', NULL, 2, '/pms/productAttr/create', 1, '2018-09-29 16:45:25', 0);
INSERT INTO `t_permission` VALUES (13, 5, '修改商品类型', 'pms:productAttribute:update', NULL, 2, '/pms/productAttr/update', 1, '2018-09-29 16:48:08', 0);
INSERT INTO `t_permission` VALUES (14, 5, '删除商品类型', 'pms:productAttribute:delete', NULL, 2, '/pms/productAttr/delete', 1, '2018-09-29 16:48:44', 0);
INSERT INTO `t_permission` VALUES (15, 6, '添加品牌', 'pms:brand:create', NULL, 2, '/pms/brand/add', 1, '2018-09-29 16:49:34', 0);
INSERT INTO `t_permission` VALUES (16, 6, '修改品牌', 'pms:brand:update', NULL, 2, '/pms/brand/update', 1, '2018-09-29 16:50:55', 0);
INSERT INTO `t_permission` VALUES (17, 6, '删除品牌', 'pms:brand:delete', NULL, 2, '/pms/brand/delete', 1, '2018-09-29 16:50:59', 0);
INSERT INTO `t_permission` VALUES (18, 0, '首页', NULL, NULL, 0, NULL, 1, '2018-09-29 16:51:57', 0);

-- ----------------------------
-- Records of t_resource
-- ----------------------------
INSERT INTO `t_resource` VALUES (1, '2020-02-04 17:04:55', '商品品牌管理', '/brand/**', NULL, 1);
INSERT INTO `t_resource` VALUES (2, '2020-02-04 17:05:35', '商品属性分类管理', '/productAttribute/category/**', NULL, 1);
INSERT INTO `t_resource` VALUES (3, '2020-02-04 17:06:13', '商品属性管理', '/productAttribute/**', NULL, 1);
INSERT INTO `t_resource` VALUES (4, '2020-02-04 17:07:15', '商品分类管理', '/productCategory/**', NULL, 1);
INSERT INTO `t_resource` VALUES (5, '2020-02-04 17:09:16', '商品管理', '/product/**', NULL, 1);
INSERT INTO `t_resource` VALUES (6, '2020-02-04 17:09:53', '商品库存管理', '/sku/**', NULL, 1);
INSERT INTO `t_resource` VALUES (8, '2020-02-05 14:43:37', '订单管理', '/order/**', '', 2);
INSERT INTO `t_resource` VALUES (9, '2020-02-05 14:44:22', ' 订单退货申请管理', '/returnApply/**', '', 2);
INSERT INTO `t_resource` VALUES (10, '2020-02-05 14:45:08', '退货原因管理', '/returnReason/**', '', 2);
INSERT INTO `t_resource` VALUES (11, '2020-02-05 14:45:43', '订单设置管理', '/orderSetting/**', '', 2);
INSERT INTO `t_resource` VALUES (12, '2020-02-05 14:46:23', '收货地址管理', '/companyAddress/**', '', 2);
INSERT INTO `t_resource` VALUES (13, '2020-02-07 16:37:22', '优惠券管理', '/coupon/**', '', 3);
INSERT INTO `t_resource` VALUES (14, '2020-02-07 16:37:59', '优惠券领取记录管理', '/couponHistory/**', '', 3);
INSERT INTO `t_resource` VALUES (15, '2020-02-07 16:38:28', '限时购活动管理', '/flash/**', '', 3);
INSERT INTO `t_resource` VALUES (16, '2020-02-07 16:38:59', '限时购商品关系管理', '/flashProductRelation/**', '', 3);
INSERT INTO `t_resource` VALUES (17, '2020-02-07 16:39:22', '限时购场次管理', '/flashSession/**', '', 3);
INSERT INTO `t_resource` VALUES (18, '2020-02-07 16:40:07', '首页轮播广告管理', '/home/advertise/**', '', 3);
INSERT INTO `t_resource` VALUES (19, '2020-02-07 16:40:34', '首页品牌管理', '/home/brand/**', '', 3);
INSERT INTO `t_resource` VALUES (20, '2020-02-07 16:41:06', '首页新品管理', '/home/newProduct/**', '', 3);
INSERT INTO `t_resource` VALUES (21, '2020-02-07 16:42:16', '首页人气推荐管理', '/home/recommendProduct/**', '', 3);
INSERT INTO `t_resource` VALUES (22, '2020-02-07 16:42:48', '首页专题推荐管理', '/home/recommendSubject/**', '', 3);
INSERT INTO `t_resource` VALUES (23, '2020-02-07 16:44:56', ' 商品优选管理', '/prefrenceArea/**', '', 5);
INSERT INTO `t_resource` VALUES (24, '2020-02-07 16:45:39', '商品专题管理', '/subject/**', '', 5);
INSERT INTO `t_resource` VALUES (25, '2020-02-07 16:47:34', '后台用户管理', '/admin/**', '', 4);
INSERT INTO `t_resource` VALUES (26, '2020-02-07 16:48:24', '后台用户角色管理', '/role/**', '', 4);
INSERT INTO `t_resource` VALUES (27, '2020-02-07 16:48:48', '后台菜单管理', '/menu/**', '', 4);
INSERT INTO `t_resource` VALUES (28, '2020-02-07 16:49:18', '后台资源分类管理', '/resourceCategory/**', '', 4);
INSERT INTO `t_resource` VALUES (29, '2020-02-07 16:49:45', '后台资源管理', '/resource/**', '', 4);
INSERT INTO `t_resource` VALUES (30, '2020-09-19 15:47:57', '会员等级管理', '/memberLevel/**', '', 7);
INSERT INTO `t_resource` VALUES (31, '2020-09-19 15:51:29', '获取登录用户信息', '/admin/info', '用户登录必配', 4);
INSERT INTO `t_resource` VALUES (32, '2020-09-19 15:53:34', '用户登出', '/admin/logout', '用户登出必配', 4);

-- ----------------------------
-- Records of t_resource_category
-- ----------------------------
INSERT INTO `t_resource_category` VALUES (1, '2020-02-05 10:21:44', '商品模块', 0);
INSERT INTO `t_resource_category` VALUES (2, '2020-02-05 10:22:34', '订单模块', 0);
INSERT INTO `t_resource_category` VALUES (3, '2020-02-05 10:22:48', '营销模块', 0);
INSERT INTO `t_resource_category` VALUES (4, '2020-02-05 10:23:04', '权限模块', 0);
INSERT INTO `t_resource_category` VALUES (5, '2020-02-07 16:34:27', '内容模块', 0);
INSERT INTO `t_resource_category` VALUES (7, '2020-09-19 15:49:08', '其他模块', 0);

-- ----------------------------
-- Records of t_role_permission_relation
-- ----------------------------
INSERT INTO `t_role_permission_relation` VALUES (1, 1, 1);
INSERT INTO `t_role_permission_relation` VALUES (2, 1, 2);
INSERT INTO `t_role_permission_relation` VALUES (3, 1, 3);
INSERT INTO `t_role_permission_relation` VALUES (4, 1, 7);
INSERT INTO `t_role_permission_relation` VALUES (5, 1, 8);
INSERT INTO `t_role_permission_relation` VALUES (6, 2, 4);
INSERT INTO `t_role_permission_relation` VALUES (7, 2, 9);
INSERT INTO `t_role_permission_relation` VALUES (8, 2, 10);
INSERT INTO `t_role_permission_relation` VALUES (9, 2, 11);
INSERT INTO `t_role_permission_relation` VALUES (10, 3, 5);
INSERT INTO `t_role_permission_relation` VALUES (11, 3, 12);
INSERT INTO `t_role_permission_relation` VALUES (12, 3, 13);
INSERT INTO `t_role_permission_relation` VALUES (13, 3, 14);
INSERT INTO `t_role_permission_relation` VALUES (14, 4, 6);
INSERT INTO `t_role_permission_relation` VALUES (15, 4, 15);
INSERT INTO `t_role_permission_relation` VALUES (16, 4, 16);
INSERT INTO `t_role_permission_relation` VALUES (17, 4, 17);


-- ----------------------------
-- Records of t_role_resource_relation
-- ----------------------------
INSERT INTO `t_role_resource_relation` VALUES (194, 5, 1);
INSERT INTO `t_role_resource_relation` VALUES (195, 5, 2);
INSERT INTO `t_role_resource_relation` VALUES (196, 5, 3);
INSERT INTO `t_role_resource_relation` VALUES (197, 5, 4);
INSERT INTO `t_role_resource_relation` VALUES (198, 5, 5);
INSERT INTO `t_role_resource_relation` VALUES (199, 5, 6);
INSERT INTO `t_role_resource_relation` VALUES (200, 5, 8);
INSERT INTO `t_role_resource_relation` VALUES (201, 5, 9);
INSERT INTO `t_role_resource_relation` VALUES (202, 5, 10);
INSERT INTO `t_role_resource_relation` VALUES (203, 5, 11);
INSERT INTO `t_role_resource_relation` VALUES (204, 5, 12);
INSERT INTO `t_role_resource_relation` VALUES (205, 5, 13);
INSERT INTO `t_role_resource_relation` VALUES (206, 5, 14);
INSERT INTO `t_role_resource_relation` VALUES (207, 5, 15);
INSERT INTO `t_role_resource_relation` VALUES (208, 5, 16);
INSERT INTO `t_role_resource_relation` VALUES (209, 5, 17);
INSERT INTO `t_role_resource_relation` VALUES (210, 5, 18);
INSERT INTO `t_role_resource_relation` VALUES (211, 5, 19);
INSERT INTO `t_role_resource_relation` VALUES (212, 5, 20);
INSERT INTO `t_role_resource_relation` VALUES (213, 5, 21);
INSERT INTO `t_role_resource_relation` VALUES (214, 5, 22);
INSERT INTO `t_role_resource_relation` VALUES (215, 5, 23);
INSERT INTO `t_role_resource_relation` VALUES (216, 5, 24);
INSERT INTO `t_role_resource_relation` VALUES (217, 5, 25);
INSERT INTO `t_role_resource_relation` VALUES (218, 5, 26);
INSERT INTO `t_role_resource_relation` VALUES (219, 5, 27);
INSERT INTO `t_role_resource_relation` VALUES (220, 5, 28);
INSERT INTO `t_role_resource_relation` VALUES (221, 5, 29);
INSERT INTO `t_role_resource_relation` VALUES (222, 5, 30);
INSERT INTO `t_role_resource_relation` VALUES (232, 2, 8);
INSERT INTO `t_role_resource_relation` VALUES (233, 2, 9);
INSERT INTO `t_role_resource_relation` VALUES (234, 2, 10);
INSERT INTO `t_role_resource_relation` VALUES (235, 2, 11);
INSERT INTO `t_role_resource_relation` VALUES (236, 2, 12);
INSERT INTO `t_role_resource_relation` VALUES (237, 2, 31);
INSERT INTO `t_role_resource_relation` VALUES (238, 2, 32);
INSERT INTO `t_role_resource_relation` VALUES (239, 1, 1);
INSERT INTO `t_role_resource_relation` VALUES (240, 1, 2);
INSERT INTO `t_role_resource_relation` VALUES (241, 1, 3);
INSERT INTO `t_role_resource_relation` VALUES (242, 1, 4);
INSERT INTO `t_role_resource_relation` VALUES (243, 1, 5);
INSERT INTO `t_role_resource_relation` VALUES (244, 1, 6);
INSERT INTO `t_role_resource_relation` VALUES (245, 1, 23);
INSERT INTO `t_role_resource_relation` VALUES (246, 1, 24);
INSERT INTO `t_role_resource_relation` VALUES (247, 1, 31);
INSERT INTO `t_role_resource_relation` VALUES (248, 1, 32);

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'test', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'https://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/icon/github_icon_02.png', 'test@qq.com', '测试账号', NULL, '2018-09-29 13:55:30', '2018-09-29 13:55:39', 1);
INSERT INTO `t_user` VALUES (3, 'admin', '$2a$10$moL..bh.Ie1OBMzb2kNFQeTpaW3CVAgv/CPdY.SpTrLbk5Hg8nviS', 'https://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/icon/github_icon_01.png', 'admin@163.com', '系统管理员', '系统管理员', '2018-10-08 13:32:47', '2019-04-20 12:45:16', 1);
INSERT INTO `t_user` VALUES (4, 'macro', '$2a$10$Bx4jZPR7GhEpIQfefDQtVeS58GfT5n6mxs/b4nLLK65eMFa16topa', 'https://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/icon/github_icon_01.png', 'macro@qq.com', 'macro', 'macro专用', '2019-10-06 15:53:51', '2020-02-03 14:55:55', 1);
INSERT INTO `t_user` VALUES (6, 'productAdmin', '$2a$10$6/.J.p.6Bhn7ic4GfoB5D.pGd7xSiD1a9M6ht6yO0fxzlKJPjRAGm', 'https://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/icon/github_icon_03.png', 'product@qq.com', '商品管理员', '只有商品权限', '2020-02-07 16:15:08', NULL, 1);
INSERT INTO `t_user` VALUES (7, 'orderAdmin', '$2a$10$UqEhA9UZXjHHA3B.L9wNG.6aerrBjC6WHTtbv1FdvYPUI.7lkL6E.', 'https://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/icon/github_icon_04.png', 'order@qq.com', '订单管理员', '只有订单管理权限', '2020-02-07 16:15:50', NULL, 1);
INSERT INTO `t_user` VALUES (8, 'test123', '$2a$10$M1qJguEzwoAN0la7PB8UO.HOGe1xZGku7xw1iTaUUpY0ZVRCxrxoO', 'string', 'abc@qq.com', 'string', 'string', '2022-08-07 14:45:42', NULL, 1);
INSERT INTO `t_user` VALUES (9, 'test256', '$2a$10$kTMBrt8mkXcO8T4eHThFWOf3KuNK6tqevkiAf4YbtXtaCJ6ocYkJa', 'string', 'abc@qq.com', 'string', 'string', '2022-08-07 14:52:57', NULL, 1);
INSERT INTO `t_user` VALUES (10, 'test1267', '$2a$10$VUywDhXVPY13YZxMD/uPWeDqkzSozN7o8u/3MX6sBig2NK2VaTJZ2', NULL, 'test1267@qq.com', 'test1267', 'test1267', '2023-01-04 16:13:34', NULL, 1);

-- ----------------------------
-- Records of t_user_role_relation
-- ----------------------------
INSERT INTO `t_user_role_relation` VALUES (26, 3, 5);
INSERT INTO `t_user_role_relation` VALUES (27, 6, 1);
INSERT INTO `t_user_role_relation` VALUES (28, 7, 2);
INSERT INTO `t_user_role_relation` VALUES (29, 1, 5);
INSERT INTO `t_user_role_relation` VALUES (30, 4, 5);
INSERT INTO `t_user_role_relation` VALUES (31, 8, 1);

-- ----------------------------
-- Records of t_pig_state
-- ----------------------------
INSERT INTO `t_pig_state` VALUES (1, 0, 20, 200, 10, 'lisi', 123456789, '', 1500, 3, '2023-1-12 23:12:55', '2023-12-12 23:12:55');
INSERT INTO `t_pig_state` VALUES (2, 0, 20, 200, 10, 'lisi', 12345678, '', 1600, 3, '2023-2-12 23:12:55', '2023-12-12 23:12:55');
INSERT INTO `t_pig_state` VALUES (3, 0, 20, 200, 10, 'lisi', 1234567, '', 1700, 3, '2023-4-12 23:12:55', '2023-12-12 23:12:55');

-- ----------------------------
-- Records of t_pig_pigsty
-- ----------------------------
INSERT INTO `t_pig_pigsty` VALUES (3, 300, 200);
INSERT INTO `t_pig_pigsty` VALUES (2, 300, 200);
INSERT INTO `t_pig_pigsty` VALUES (1, 300, 200);

-- ----------------------------
-- Records of t_pig_pigsty_feed
-- ----------------------------
INSERT INTO `t_pig_pigsty_feed` VALUES (1, 1, 3, 100, '2023-4-12 23:12:55');
INSERT INTO `t_pig_pigsty_feed` VALUES (2, 1, 3, 100, '2023-4-13 23:12:55');
INSERT INTO `t_pig_pigsty_feed` VALUES (3, 1, 3, 100, '2023-4-14 23:12:55');

-- ----------------------------
-- Records of t_pig_feed_brand
-- ----------------------------
INSERT INTO `t_pig_feed_brand` VALUES (1, '正大');
INSERT INTO `t_pig_feed_brand` VALUES (2, '阳光');
INSERT INTO `t_pig_feed_brand` VALUES (3, '金正大');

-- ----------------------------
-- Records of t_pig_feed_price
-- ----------------------------
INSERT INTO `t_pig_feed_price` VALUES (1, 2, 150, '2023-4-14 23:12:55');
INSERT INTO `t_pig_feed_price` VALUES (2, 2, 150, '2023-4-15 23:12:55');

-- ----------------------------
-- Records of t_pig_feed_total
-- ----------------------------
INSERT INTO `t_pig_feed_total` VALUES (1, 2, 'lisi', 123456, '', 200, 180, 150, '2023-4-14 23:12:55', 60, 15);
INSERT INTO `t_pig_feed_total` VALUES (2, 2, 'zhangsan', 1234566, '', 200, 180, 150, '2023-3-14 23:12:55', 60, 15);
INSERT INTO `t_pig_feed_total` VALUES (3, 2, 'wangwu', 1234565, '', 200, 180, 150, '2023-2-14 23:12:55', 60, 15);

-- ----------------------------
-- Records of t_pig_feed
-- ----------------------------
INSERT INTO `t_pig_feed` VALUES (1, 2, 1, '2023-4-14 23:12:55');
INSERT INTO `t_pig_feed` VALUES (2, 2, 1, '2023-5-14 23:12:55');
INSERT INTO `t_pig_feed` VALUES (3, 2, 1, '2023-6-14 23:12:55');

-- ----------------------------
-- Records of t_pig_temperature
-- ----------------------------
INSERT INTO `t_pig_temperature` VALUES (1, 2, 36, '2023-4-14 23:12:55');
INSERT INTO `t_pig_temperature` VALUES (2, 2, 36, '2023-4-15 23:12:55');
INSERT INTO `t_pig_temperature` VALUES (3, 2, 36, '2023-4-16 23:12:55');

-- ----------------------------
-- Records of t_pig_weight
-- ----------------------------
INSERT INTO `t_pig_weight` VALUES (1, 2, 130, '2023-4-14 23:12:55');
INSERT INTO `t_pig_weight` VALUES (2, 2, 130, '2023-4-14 23:12:55');
INSERT INTO `t_pig_weight` VALUES (3, 2, 130, '2023-4-14 23:12:55');


-- ----------------------------
-- Table structure for t_mqtt
-- ----------------------------
INSERT INTO `t_mqtt` VALUES (1, '127.0.0.1:1883', 'admin', 'admin', 30, 60, 0, 0, 'admin 用戶连接地址', 1, '2023-4-14 23:12:55');
INSERT INTO `t_mqtt` VALUES (2, '127.0.0.1:1883', 'user', 'user', 30, 60, 0, 0, 'user 用戶连接地址', 1, '2023-4-14 23:12:55');
INSERT INTO `t_mqtt` VALUES (3, '127.0.0.1:1883', 'agent', 'agent', 30, 60, 0, 0, 'agent 用戶连接地址', 1, '2023-4-14 23:12:55');
INSERT INTO `t_mqtt` VALUES (4, '127.0.0.1:1883', 'ss', 'ss', 30, 60, 0, 0, 'ss 用戶连接地址', 1, '2023-4-14 23:12:55');
INSERT INTO `t_mqtt` VALUES (5, '127.0.0.1:1883', 'uu', 'uu', 30, 60, 0, 0, 'admin 用戶连接地址', 1, '2023-4-14 23:12:55');


-- ----------------------------
-- Table structure for t_mqtt_sub
-- ----------------------------
INSERT INTO `t_mqtt_sub` VALUES (1, 12234533,'topic_id', 1, 0,'2023-4-14 23:12:55');
INSERT INTO `t_mqtt_sub` VALUES (2, 12234533,'topic_id', 1, 0,'2023-4-14 23:12:55');
INSERT INTO `t_mqtt_sub` VALUES (3, 12234533,'topic_id', 1, 0,'2023-4-14 23:12:55');
INSERT INTO `t_mqtt_sub` VALUES (4, 12234533,'topic_id', 1, 0,'2023-4-14 23:12:55');
INSERT INTO `t_mqtt_sub` VALUES (5, 12234533,'topic_id', 1, 0,'2023-4-14 23:12:55');


-- ----------------------------
-- Table structure for t_mqtt_pub
-- ----------------------------
INSERT INTO `t_mqtt_pub` VALUES (1, 34556778,'topic_id', 1, 0, 0, '2023-4-14 23:12:55');
INSERT INTO `t_mqtt_pub` VALUES (2, 34556778,'topic_id', 1, 0, 0, '2023-4-14 23:12:55');
INSERT INTO `t_mqtt_pub` VALUES (3, 34556778,'topic_id', 1, 0, 0, '2023-4-14 23:12:55');
INSERT INTO `t_mqtt_pub` VALUES (4, 34556778,'topic_id', 1, 0, 0, '2023-4-14 23:12:55');
INSERT INTO `t_mqtt_pub` VALUES (5, 34556778,'topic_id', 1, 0, 0, '2023-4-14 23:12:55');


-- ----------------------------
-- Table structure for t_mqtt_history
-- ----------------------------
INSERT INTO `t_mqtt_history` VALUES (1, 'sub_ip', 'pub_ip', 'mqtt_topic', 1, 0, 'is success', '2023-4-14 23:12:55');
INSERT INTO `t_mqtt_history` VALUES (2, 'sub_ip', 'pub_ip', 'mqtt_topic', 1, 0, 'is success', '2023-4-14 23:12:55');
INSERT INTO `t_mqtt_history` VALUES (3, 'sub_ip', 'pub_ip', 'mqtt_topic', 1, 0, 'is success', '2023-4-14 23:12:55');
INSERT INTO `t_mqtt_history` VALUES (4, 'sub_ip', 'pub_ip', 'mqtt_topic', 1, 0, 'is success', '2023-4-14 23:12:55');
INSERT INTO `t_mqtt_history` VALUES (5, 'sub_ip', 'pub_ip', 'mqtt_topic', 1, 0, 'is success', '2023-4-14 23:12:55');
;
-- ----------------------------
-- Records of t_schedule_taskf
-- ----------------------------
INSERT INTO `t_schedule_task` VALUES (127, 'com.smart.task.ins.SummarySheetTask', '0 0/20 * * * ?', '每20分钟执行一次', '2023-4-14 23:12:55', '2023-4-14 23:12:55');
INSERT INTO `t_schedule_task` VALUES (122, 'com.smart.task.ins.SummarySheetTask', '0 0 0 0 1/1 ?', '每月1号开始，每月1号执行一次', '2023-4-14 23:12:55', '2023-4-14 23:12:55');
INSERT INTO `t_schedule_task` VALUES (123, 'com.smart.task.ins.SummarySheetTask', '0 0 5 0 * ? *', '每五天执行一次', '2023-4-14 23:12:55', '2023-4-14 23:12:55');
INSERT INTO `t_schedule_task` VALUES (124, 'com.smart.task.ins.SummarySheetTask', '0 0 6 0 * ? *', '每六天执行一次', '2023-4-14 23:12:55', '2023-4-14 23:12:55');
INSERT INTO `t_schedule_task` VALUES (125, 'com.smart.task.ins.SummarySheetTask', '0 0 5 2 * ? *', '每五天执行一次', '2023-4-14 23:12:55', '2023-4-14 23:12:55');
INSERT INTO `t_schedule_task` VALUES (126, 'com.smart.task.ins.SummarySheetTask', '0 0 8 0 * ? *', '每八天执行一次', '2023-4-14 23:12:55', '2023-4-14 23:12:55');
