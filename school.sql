/*
 Navicat Premium Data Transfer

 Source Server         : JAVAEE
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : school

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 11/03/2020 15:53:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for s_homework
-- ----------------------------
DROP TABLE IF EXISTS `s_homework`;
CREATE TABLE `s_homework`  (
  `homework_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `create_time` timestamp(0) NOT NULL,
  `update_time` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`homework_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55555555555556 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_homework
-- ----------------------------
INSERT INTO `s_homework` VALUES (1, '2', '4', '2020-03-10 14:28:15', '2020-03-10 14:28:14.82');
INSERT INTO `s_homework` VALUES (5, '5', '5', '2020-03-10 17:14:52', '2020-03-10 17:14:52.263');
INSERT INTO `s_homework` VALUES (25, '51235', '532152135', '2020-03-10 14:30:53', '2020-03-10 14:30:53.026');
INSERT INTO `s_homework` VALUES (352, '6126', '1246236', '2020-03-10 14:29:01', '2020-03-10 14:29:00.946');
INSERT INTO `s_homework` VALUES (999, '888', '777', '2020-03-10 16:28:01', '2020-03-10 16:28:00.664');
INSERT INTO `s_homework` VALUES (51235, '21467', '374173147', '2020-03-10 14:32:09', '2020-03-10 14:32:08.792');
INSERT INTO `s_homework` VALUES (55555555555555, '333333', '55', '2020-03-11 07:39:40', '2020-03-11 07:39:40.109');

-- ----------------------------
-- Table structure for s_student
-- ----------------------------
DROP TABLE IF EXISTS `s_student`;
CREATE TABLE `s_student`  (
  `student_id` bigint(0) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` timestamp(0) NOT NULL,
  `update_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_student
-- ----------------------------
INSERT INTO `s_student` VALUES (1, 'XJ', '2020-03-10 16:27:44', '2020-03-10 16:27:44');
INSERT INTO `s_student` VALUES (3, '3', '2020-03-10 17:14:46', '2020-03-10 17:14:46');
INSERT INTO `s_student` VALUES (111, 'XJ', '2020-03-11 07:14:20', '2020-03-11 07:14:20');
INSERT INTO `s_student` VALUES (2135, '2316', '2020-03-10 14:12:51', '2020-03-10 14:12:51');
INSERT INTO `s_student` VALUES (5215, '52135', '2020-03-10 14:11:42', '2020-03-10 14:11:42');
INSERT INTO `s_student` VALUES (52315, '231521351235', '2020-03-10 14:28:23', '2020-03-10 14:28:23');
INSERT INTO `s_student` VALUES (11111111111, '555', '2020-03-10 14:40:06', '2020-03-10 14:40:06');

-- ----------------------------
-- Table structure for s_student_homework
-- ----------------------------
DROP TABLE IF EXISTS `s_student_homework`;
CREATE TABLE `s_student_homework`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `student_id` bigint(0) NOT NULL,
  `homework_id` bigint(0) NOT NULL,
  `homework_title` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `homework_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `create_time` timestamp(0) NOT NULL,
  `update_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_student_homework
-- ----------------------------
INSERT INTO `s_student_homework` VALUES (1, 100, 100, '作业', 'https://www.google.com', '2020-03-03 00:00:00', NULL);
INSERT INTO `s_student_homework` VALUES (2, 5321, 5213, '5213', '5231', '2020-03-10 13:48:10', '2020-03-10 13:48:10');
INSERT INTO `s_student_homework` VALUES (3, 100, 5325, '62146', '61246124', '2020-03-10 16:03:38', '2020-03-10 16:03:38');
INSERT INTO `s_student_homework` VALUES (4, 100, 777, '72457', '754', '2020-03-10 16:05:46', '2020-03-10 16:05:46');
INSERT INTO `s_student_homework` VALUES (5, 100, 7777, '8888', '9999', '2020-03-10 16:27:26', '2020-03-10 16:27:26');
INSERT INTO `s_student_homework` VALUES (6, 1, 1, '1', '1', '2020-03-10 17:12:40', '2020-03-10 17:12:40');
INSERT INTO `s_student_homework` VALUES (7, 1, 2, '3', '4', '2020-03-10 17:14:11', '2020-03-10 17:14:11');
INSERT INTO `s_student_homework` VALUES (8, 1, 23, '5325', '53215', '2020-03-11 07:05:09', '2020-03-11 07:05:09');
INSERT INTO `s_student_homework` VALUES (9, 1, 5315, 'fa', 'dsag', '2020-03-11 07:39:28', '2020-03-11 07:39:28');

SET FOREIGN_KEY_CHECKS = 1;
