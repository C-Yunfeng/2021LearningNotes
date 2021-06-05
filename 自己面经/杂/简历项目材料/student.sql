/*
 Navicat Premium Data Transfer

 Source Server         : myconnect
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 15/02/2021 11:00:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `ID` int(0) NOT NULL,
  `NAME` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `COURSE` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `SCORE` decimal(10, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '小白', '语文', 90);
INSERT INTO `student` VALUES (2, '小离', '语文', 80);
INSERT INTO `student` VALUES (3, '小五', '语文', 77);
INSERT INTO `student` VALUES (4, '小五', '英语', 80);
INSERT INTO `student` VALUES (5, '小白', '数学', 95);
INSERT INTO `student` VALUES (6, '小白', '英语', 89);
INSERT INTO `student` VALUES (7, '小离', '数学', 86);
INSERT INTO `student` VALUES (8, '小离', '政治', 94);
INSERT INTO `student` VALUES (9, '小五', '数学', 97);
INSERT INTO `student` VALUES (10, '飞飞', '化学', 81);

SET FOREIGN_KEY_CHECKS = 1;
