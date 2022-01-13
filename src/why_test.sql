/*
 Navicat Premium Data Transfer

 Source Server         : mySql8.0FromService
 Source Server Type    : MySQL
 Source Server Version : 80024
 Source Host           : 121.40.83.16:3306
 Source Schema         : why_test

 Target Server Type    : MySQL
 Target Server Version : 80024
 File Encoding         : 65001

 Date: 12/01/2022 18:15:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for company_inf
-- ----------------------------
DROP TABLE IF EXISTS `company_inf`;
CREATE TABLE `company_inf`  (
  `bottom_logo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hot_line` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `website` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `qr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `logo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of company_inf
-- ----------------------------
INSERT INTO `company_inf` VALUES ('/pic/dlogo_bx20.jpg', '400-028-3294', 'DavedQAQ@outlook.com', '成都的那个踏踏', 'www.baidu.com', '/pic/QR.png', '/pic/logo_jzv9.jpg');

-- ----------------------------
-- Table structure for files
-- ----------------------------
DROP TABLE IF EXISTS `files`;
CREATE TABLE `files`  (
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_id` int(0) NOT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `id`(`user_id`) USING BTREE,
  CONSTRAINT `files_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `member_list` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of files
-- ----------------------------
INSERT INTO `files` VALUES ('/upload/avatar/04364.jpg', 1, 'avatar');
INSERT INTO `files` VALUES ('/upload/avatar/32536.jpeg', 24, 'avatar');

-- ----------------------------
-- Table structure for inf_company_detail
-- ----------------------------
DROP TABLE IF EXISTS `inf_company_detail`;
CREATE TABLE `inf_company_detail`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `inf_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `inf_value` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `inf_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `inf_link` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `inf_belong_to` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `inf_sort` int(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of inf_company_detail
-- ----------------------------
INSERT INTO `inf_company_detail` VALUES (1, 'orderline', '400-028-369', 'phone_number', '', 'newscenter', 1);
INSERT INTO `inf_company_detail` VALUES (2, 'newscenterimg', '未标题-1.png', 'img', '', 'newscenter', 1);
INSERT INTO `inf_company_detail` VALUES (3, '新闻', '两大企业强强联手', 'word', '', 'newscenter', 1);
INSERT INTO `inf_company_detail` VALUES (4, '新闻', '两大企业强强联手', 'word', '', 'newscenter', 2);
INSERT INTO `inf_company_detail` VALUES (5, '新闻', '两大企业强强联手', 'word', '', 'newscenter', 3);
INSERT INTO `inf_company_detail` VALUES (6, '新闻', '两大企业强强联手', 'word', '', 'newscenter', 4);

-- ----------------------------
-- Table structure for inf_nav
-- ----------------------------
DROP TABLE IF EXISTS `inf_nav`;
CREATE TABLE `inf_nav`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `inf_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `inf_value` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `inf_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `inf_link` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `inf_belong_to` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `inf_sort` int(0) NOT NULL,
  `is_show` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enable` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of inf_nav
-- ----------------------------
INSERT INTO `inf_nav` VALUES (1, '网站首页', '网站首页', 'word', 'index.html', 'nav_word', 1, '1', '1');
INSERT INTO `inf_nav` VALUES (2, '关于我们', '关于我们', 'word', 'aboutus.html', 'nav_word', 2, '1', '1');
INSERT INTO `inf_nav` VALUES (3, '服务项目', '服务项目', 'word', 'serviceproject.html', 'nav_word', 3, '1', '1');
INSERT INTO `inf_nav` VALUES (4, '新闻中心', '新闻中心', 'word', 'newscenter.html', 'nav_word', 4, '1', '1');
INSERT INTO `inf_nav` VALUES (5, '设施介绍', '设施介绍', 'word', 'equipmentintruduce.html', 'nav_word', 5, '1', '0');
INSERT INTO `inf_nav` VALUES (6, '在线订房', '在线订房', 'word', 'onlineorderroom.html', 'nav_word', 6, '1', '0');
INSERT INTO `inf_nav` VALUES (7, '联系我们', '联系我们', 'word', 'contantus.html', 'nav_word', 7, '1', '1');
INSERT INTO `inf_nav` VALUES (8, '头部logo', 'pic', 'nav_pic', 'logo_jzv9.jpg', 'nav_pic', 1, '1', '1');
INSERT INTO `inf_nav` VALUES (9, 'topImg', 'pic', 'top_Img', '/pic/ban1_hnkr.jpg', 'top_pic', 1, '1', '1');
INSERT INTO `inf_nav` VALUES (10, 'topImg', 'pic', 'top_Img', '/pic/ban_s8ne.jpg', 'top_pic', 1, '1', '1');

-- ----------------------------
-- Table structure for mail
-- ----------------------------
DROP TABLE IF EXISTS `mail`;
CREATE TABLE `mail`  (
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `detail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `id` int(0) NOT NULL,
  `call_back` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `enable` int(0) NULL DEFAULT NULL,
  `publish_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `call_back_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mail
-- ----------------------------
INSERT INTO `mail` VALUES ('davedqaq@outlook.com', '关于我在干嘛这件事', '八八八八八八八八八八八', 1, '<img src=\"/upload/mail/88827.jpg\" alt=\"undefined\">asdasdasdasd', 1, '2021-12-07 16:42:36', '2022-01-05 16:37:27');
INSERT INTO `mail` VALUES ('123@outlook.com', 'ajksdhjaksdh kashjk', 'aslkdhsajkldh', 2, '你好呀', 1, '2021-1-07 16:42:36', '2022-01-05 04:25:48');
INSERT INTO `mail` VALUES ('1114223183@qq.com', '八八八', '撒大阿萨', 3, NULL, 1, '2021-1-07 16:42:36', NULL);

-- ----------------------------
-- Table structure for managers
-- ----------------------------
DROP TABLE IF EXISTS `managers`;
CREATE TABLE `managers`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `logintimes` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of managers
-- ----------------------------
INSERT INTO `managers` VALUES (1, 'admin', 'admin', 0);

-- ----------------------------
-- Table structure for member_list
-- ----------------------------
DROP TABLE IF EXISTS `member_list`;
CREATE TABLE `member_list`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sign` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `city` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `experience` int(0) NULL DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `logins` int(0) NULL DEFAULT NULL,
  `birthday` datetime(0) NULL DEFAULT NULL,
  `enable` int(0) NULL DEFAULT NULL,
  `create_time` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hobby` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Start` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `End` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `temp` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member_list
-- ----------------------------
INSERT INTO `member_list` VALUES (1, 'bobo', 'davedqaq@outlook.com', '123456', '男', '15928550732', '君不见，黄河之水天上来，奔流到海不复回。 君不见，高堂明镜悲白发，朝如青丝暮成雪。', '浙江杭州', 12, 'null', 106, '2022-01-12 00:00:00', 1, '2016-10-14', 'c,c++,java', '2016-10-14', '2021-12-16', '2022-01-12 17:33:15', NULL, '', '<img src=\"/upload/text/17112.jpeg\" alt=\"undefined\">', NULL);
INSERT INTO `member_list` VALUES (24, 'tFWpa4.187274', '123456@qq.com', 'adminadminadmin', '男', '17602836084', NULL, NULL, NULL, NULL, NULL, '2022-01-12 00:00:00', 1, NULL, 'c,java', NULL, NULL, '2022-01-12 17:33:37', NULL, NULL, '<img src=\"/upload/text/14386.jpeg\" alt=\"undefined\">', NULL);
INSERT INTO `member_list` VALUES (25, 'mhktE2.972420', '123456@qq.com', 'adminadminadmin', '男', '17602836084', NULL, NULL, NULL, NULL, NULL, '2022-01-21 00:00:00', 1, NULL, 'c,java', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `member_list` VALUES (26, 'EGtbe1.435470', '123456@qq.com', 'adminadminadmin', '男', '17602836084', NULL, NULL, NULL, NULL, NULL, '2022-01-29 00:00:00', 1, NULL, 'c,java', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `member_list` VALUES (27, 'SXknb9.100594', '123456@qq.com', 'adminadminadmin', '男', '17602836084', NULL, NULL, NULL, NULL, NULL, '2022-01-21 00:00:00', 1, NULL, 'c++,java,c#', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `member_list` VALUES (28, 'KEjym7.006994', '123456@qq.com', 'adminadminadmin', '男', '17602836084', NULL, NULL, NULL, NULL, NULL, '2022-01-14 00:00:00', 1, NULL, 'c,c++', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `member_list` VALUES (29, 'dAGyw1.972072', '123456@qq.com', 'adminadminadmin', '男', '17602836084', NULL, NULL, NULL, NULL, NULL, '2022-01-22 00:00:00', 1, NULL, 'c,c++', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `member_list` VALUES (30, 'RzPEi3.511556', '123456@qq.com', 'adminadminadmin', '男', '17602836084', NULL, NULL, NULL, NULL, NULL, '2022-01-21 00:00:00', 1, NULL, 'c,c++', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `member_list` VALUES (31, 'NSTbk9.870206', '123456@qq.com', 'adminadminadmin', '男', '17602836084', NULL, NULL, NULL, NULL, NULL, '2022-01-21 00:00:00', 1, NULL, 'c,c++', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `member_list` VALUES (32, 'GwhKy2.286762', '123456@qq.com', 'adminadminadmin', '男', '17602836084', NULL, NULL, NULL, NULL, NULL, '2022-01-21 00:00:00', 1, NULL, 'c,c#', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `member_list` VALUES (33, 'mTrmh0.308031', '123456@qq.com', 'adminadminadmin', '男', '17602836084', NULL, NULL, NULL, NULL, NULL, '2022-01-21 00:00:00', 1, NULL, 'c,c++', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `member_list` VALUES (34, 'erRSY8.036387', '123456@qq.com', 'adminadminadmin', '男', '17602836084', NULL, NULL, NULL, NULL, NULL, '2022-01-28 00:00:00', 1, NULL, 'c,c++', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `member_list` VALUES (35, 'justdoit', NULL, '123456', '男', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `member_list` VALUES (36, 'FFCZd9.436191', '123456@qq.com', 'adminadminadmin', '男', '17602836084', NULL, NULL, NULL, NULL, NULL, '2022-01-14 00:00:00', 1, NULL, 'c,java', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for news_center
-- ----------------------------
DROP TABLE IF EXISTS `news_center`;
CREATE TABLE `news_center`  (
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `english_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enable` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `href` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id` int(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news_center
-- ----------------------------
INSERT INTO `news_center` VALUES ('新闻中心', 'NEWS CENTER', '/pic/xl_du7j.jpg', '1', 'title', NULL, 'Our #ParkerSolarProbe has touched the Sun!\r\n\r\nFor the first time in history, a spacecraft has flown through the Sun\'s atmosphere, the corona. Here\'s what it means: https://go.nasa.gov/3oU7Vlj', 0);
INSERT INTO `news_center` VALUES ('两大企业强强联手', NULL, NULL, '1', 'content', NULL, 'Our #ParkerSolarProbe has touched the Sun!\r\n\r\nFor the first time in history, a spacecraft has flown through the Sun\'s atmosphere, the corona. Here\'s what it means: https://go.nasa.gov/3oU7Vlj', 1);
INSERT INTO `news_center` VALUES ('节后全国热点城市酒店房价继续', NULL, NULL, '1', 'content', NULL, 'Our #ParkerSolarProbe has touched the Sun!\r\n\r\nFor the first time in history, a spacecraft has flown through the Sun\'s atmosphere, the corona. Here\'s what it means: https://go.nasa.gov/3oU7Vlj', 2);
INSERT INTO `news_center` VALUES ('三亚酒店价格大幅下降\r\n                            节后', NULL, NULL, '1', 'content', NULL, 'Our #ParkerSolarProbe has touched the Sun!\r\n\r\nFor the first time in history, a spacecraft has flown through the Sun\'s atmosphere, the corona. Here\'s what it means: https://go.nasa.gov/3oU7Vlj', 3);
INSERT INTO `news_center` VALUES ('延申到海中的酒店', NULL, NULL, '1', 'content', NULL, 'Our #ParkerSolarProbe has touched the Sun!\r\n\r\nFor the first time in history, a spacecraft has flown through the Sun\'s atmosphere, the corona. Here\'s what it means: https://go.nasa.gov/3oU7Vlj', 4);
INSERT INTO `news_center` VALUES ('外来和尚改写杭城高星级酒店版', NULL, NULL, '1', 'content', NULL, 'Our #ParkerSolarProbe has touched the Sun!\r\n\r\nFor the first time in history, a spacecraft has flown through the Sun\'s atmosphere, the corona. Here\'s what it means: https://go.nasa.gov/3oU7Vlj', 5);

-- ----------------------------
-- Table structure for service_project
-- ----------------------------
DROP TABLE IF EXISTS `service_project`;
CREATE TABLE `service_project`  (
  `on_back_letter` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `service_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `service_english_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `href` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `img` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enable` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of service_project
-- ----------------------------
INSERT INTO `service_project` VALUES ('V', '贵宾阁', 'VIP PAVILION', NULL, 1, '/pic/t01_fgu7.jpg', 'title', NULL, '1', 'Our #ParkerSolarProbe has touched the Sun!\r\n\r\nFor the first time in history, a spacecraft has flown through the Sun\'s atmosphere, the corona. Here\'s what it means: https://go.nasa.gov/3oU7Vlj');
INSERT INTO `service_project` VALUES ('S', '服务式套房', 'SERVICED SUITE', NULL, 2, '/pic/t02_1vs1.jpg', 'title', NULL, '1', 'Our #ParkerSolarProbe has touched the Sun!\r\n\r\nFor the first time in history, a spacecraft has flown through the Sun\'s atmosphere, the corona. Here\'s what it means: https://go.nasa.gov/3oU7Vlj');
INSERT INTO `service_project` VALUES ('R', '餐厅及酒吧', 'RESTAURANTS', NULL, 3, '/pic/t02_1vs1.jpg', 'title', NULL, '1', 'Our #ParkerSolarProbe has touched the Sun!\r\n\r\nFor the first time in history, a spacecraft has flown through the Sun\'s atmosphere, the corona. Here\'s what it means: https://go.nasa.gov/3oU7Vlj');
INSERT INTO `service_project` VALUES (NULL, 'balabasjdahskjdhasjk', NULL, NULL, 4, '/pic/01_6dzw.jpg', 'detail', '200', '1', 'Our #ParkerSolarProbe has touched the Sun!\r\n\r\nFor the first time in history, a spacecraft has flown through the Sun\'s atmosphere, the corona. Here\'s what it means: https://go.nasa.gov/3oU7Vlj');
INSERT INTO `service_project` VALUES (NULL, '贵宾楼层尊享海景客房', NULL, NULL, 5, '/pic/01_6dzw.jpg', 'detail', '200', '1', 'Our #ParkerSolarProbe has touched the Sun!\r\n\r\nFor the first time in history, a spacecraft has flown through the Sun\'s atmosphere, the corona. Here\'s what it means: https://go.nasa.gov/3oU7Vlj');
INSERT INTO `service_project` VALUES (NULL, '贵宾楼层尊', NULL, NULL, 6, '/pic/t02_1vs1.jpg', 'detail', '200', '1', 'Our #ParkerSolarProbe has touched the Sun!\r\n\r\nFor the first time in history, a spacecraft has flown through the Sun\'s atmosphere, the corona. Here\'s what it means: https://go.nasa.gov/3oU7Vlj');
INSERT INTO `service_project` VALUES (NULL, '贵宾楼层尊享海景客', NULL, NULL, 7, '/pic/01_6dzw.jpg', 'detail', '200', '1', 'Our #ParkerSolarProbe has touched the Sun!\r\n\r\nFor the first time in history, a spacecraft has flown through the Sun\'s atmosphere, the corona. Here\'s what it means: https://go.nasa.gov/3oU7Vlj');
INSERT INTO `service_project` VALUES (NULL, '贵宾楼层尊享海', NULL, NULL, 8, '/pic/01_6dzw.jpg', 'detail', '200', '1', 'Our #ParkerSolarProbe has touched the Sun!\r\n\r\nFor the first time in history, a spacecraft has flown through the Sun\'s atmosphere, the corona. Here\'s what it means: https://go.nasa.gov/3oU7Vlj');
INSERT INTO `service_project` VALUES (NULL, '贵宾', NULL, NULL, 9, '/pic/01_6dzw.jpg', 'detail', '200', '1', 'Our #ParkerSolarProbe has touched the Sun!\r\n\r\nFor the first time in history, a spacecraft has flown through the Sun\'s atmosphere, the corona. Here\'s what it means: https://go.nasa.gov/3oU7Vlj');

-- ----------------------------
-- Table structure for text
-- ----------------------------
DROP TABLE IF EXISTS `text`;
CREATE TABLE `text`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_id` int(0) NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `enable` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of text
-- ----------------------------
INSERT INTO `text` VALUES (1, 'null', NULL, 'wqeqwe@qq.com', 1);
INSERT INTO `text` VALUES (2, 'null', NULL, 'davedqaq@outlook.com', 1);
INSERT INTO `text` VALUES (3, 'null', NULL, 'davedqaq@outlook.com', 1);
INSERT INTO `text` VALUES (4, 'null', NULL, 'qaq@outlook.com', 1);
INSERT INTO `text` VALUES (5, '12312312', NULL, 'qaq@outlook.com', 1);
INSERT INTO `text` VALUES (6, '123156456', NULL, 'qaq@outlook.com', NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `session_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hobby` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `start` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `end` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id` int(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
