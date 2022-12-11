/*
 Navicat Premium Data Transfer

 Source Server         : 120.76.142.218
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : 120.76.142.218:3306
 Source Schema         : kindergarten

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 11/12/2022 16:15:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class_info
-- ----------------------------
DROP TABLE IF EXISTS `class_info`;
CREATE TABLE `class_info`  (
                               `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                               `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '班级名称',
                               `introduce` varchar(1025) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '班级介绍',
                               `head_teacher_id` bigint NOT NULL COMMENT '班主任Id',
                               INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '班级信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for clocking_in
-- ----------------------------
DROP TABLE IF EXISTS `clocking_in`;
CREATE TABLE `clocking_in`  (
                                `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                                `student_id` bigint NOT NULL COMMENT '学生Id',
                                `date_time` datetime(0) NOT NULL COMMENT '考勤时间',
                                `clocking_in_type` int NOT NULL COMMENT '考勤类型（1-正常，2-病假，3-事假，4-迟到，5-早退，6-其他）',
                                INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生考勤表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
                           `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                           `subjects_id` bigint NOT NULL COMMENT '科目Id',
                           `class_info_id` bigint NOT NULL COMMENT '班级Id',
                           `teacher_id` bigint NOT NULL COMMENT '老师Id',
                           INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for date_manage
-- ----------------------------
DROP TABLE IF EXISTS `date_manage`;
CREATE TABLE `date_manage`  (
                                `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                                `start_date` varchar(900) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                                `end_date` varchar(900) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                                `time` int NOT NULL COMMENT '时长（分钟）',
                                `course_id` bigint NOT NULL COMMENT '课程Id',
                                INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '时间管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for recipe
-- ----------------------------
DROP TABLE IF EXISTS `recipe`;
CREATE TABLE `recipe`  (
                           `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                           `breakfast` varchar(900) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                           `lunch` varchar(900) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                           `dinner` varchar(900) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                           `name` varchar(900) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                           `sort` int NOT NULL COMMENT '顺序',
                           INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '食谱信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rela_student_class
-- ----------------------------
DROP TABLE IF EXISTS `rela_student_class`;
CREATE TABLE `rela_student_class`  (
                                       `student_id` bigint NOT NULL COMMENT '学生Id',
                                       `class_info_id` bigint NOT NULL COMMENT '班级Id',
                                       INDEX `student_id`(`student_id`, `class_info_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生班级关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rela_teacher_class
-- ----------------------------
DROP TABLE IF EXISTS `rela_teacher_class`;
CREATE TABLE `rela_teacher_class`  (
                                       `teacher_id` bigint NOT NULL COMMENT '老师Id',
                                       `class_info_id` bigint NOT NULL COMMENT '班级Id',
                                       INDEX `teacher_id`(`teacher_id`, `class_info_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '老师班级关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
                            `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                            `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
                            `age` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '年龄',
                            `gender` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '性别',
                            `birthday` date NOT NULL COMMENT '出生日期',
                            `guardian_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '监护人姓名',
                            `guardian_phone` varchar(900) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                            INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for subjects
-- ----------------------------
DROP TABLE IF EXISTS `subjects`;
CREATE TABLE `subjects`  (
                             `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                             `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '科目名称',
                             `introduce` varchar(1025) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '科目介绍',
                             INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '科目信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
                            `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                            `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
                            `age` int NOT NULL COMMENT '年龄',
                            `gender` tinyint NOT NULL COMMENT '性别',
                            `hobby_tag` varchar(900) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                            `biography` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '个人简介',
                            INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '老师信息表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
