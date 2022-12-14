

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class_info
-- ----------------------------
DROP TABLE IF EXISTS `class_info`;
CREATE TABLE `class_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) NOT NULL COMMENT '班级名称',
  `introduce` varchar(1025) NOT NULL COMMENT '班级介绍',
  `head_teacher_id` bigint NOT NULL COMMENT '班主任Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='班级信息表';

-- ----------------------------
-- Table structure for clocking_in
-- ----------------------------
DROP TABLE IF EXISTS `clocking_in`;
CREATE TABLE `clocking_in` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `student_id` bigint NOT NULL COMMENT '学生Id',
  `date_time` datetime NOT NULL COMMENT '考勤时间',
  `clocking_in_type` int NOT NULL COMMENT '考勤类型（1-正常，2-病假，3-事假，4-迟到，5-早退，6-其他）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='学生考勤表';

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `subjects_id` bigint NOT NULL COMMENT '科目Id',
  `class_info_id` bigint NOT NULL COMMENT '班级Id',
  `teacher_id` bigint NOT NULL COMMENT '老师Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='课程信息表';

-- ----------------------------
-- Table structure for date_manage
-- ----------------------------
DROP TABLE IF EXISTS `date_manage`;
CREATE TABLE `date_manage` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `start_date` varchar(900) DEFAULT NULL,
  `end_date` varchar(900) DEFAULT NULL,
  `time` int NOT NULL COMMENT '时长（分钟）',
  `course_id` bigint NOT NULL COMMENT '课程Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='时间管理表';

-- ----------------------------
-- Table structure for recipe
-- ----------------------------
DROP TABLE IF EXISTS `recipe`;
CREATE TABLE `recipe` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `breakfast` varchar(900) DEFAULT NULL,
  `lunch` varchar(900) DEFAULT NULL,
  `dinner` varchar(900) DEFAULT NULL,
  `name` varchar(900) DEFAULT NULL,
  `sort` int NOT NULL COMMENT '顺序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='食谱信息表';

-- ----------------------------
-- Table structure for rela_student_class
-- ----------------------------
DROP TABLE IF EXISTS `rela_student_class`;
CREATE TABLE `rela_student_class` (
  `student_id` bigint NOT NULL COMMENT '学生Id',
  `class_info_id` bigint NOT NULL COMMENT '班级Id',
  PRIMARY KEY `student_id` (`student_id`,`class_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='学生班级关系表';

-- ----------------------------
-- Table structure for rela_teacher_class
-- ----------------------------
DROP TABLE IF EXISTS `rela_teacher_class`;
CREATE TABLE `rela_teacher_class` (
  `teacher_id` bigint NOT NULL COMMENT '老师Id',
  `class_info_id` bigint NOT NULL COMMENT '班级Id',
  PRIMARY KEY `teacher_id` (`teacher_id`,`class_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='老师班级关系表';

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `age` varchar(20) NOT NULL COMMENT '年龄',
  `gender` varchar(20) NOT NULL COMMENT '性别',
  `birthday` date NOT NULL COMMENT '出生日期',
  `guardian_name` varchar(20) NOT NULL COMMENT '监护人姓名',
  `guardian_phone` varchar(900) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='学生信息表';

-- ----------------------------
-- Table structure for subjects
-- ----------------------------
DROP TABLE IF EXISTS `subjects`;
CREATE TABLE `subjects` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) NOT NULL COMMENT '科目名称',
  `introduce` varchar(1025) NOT NULL COMMENT '科目介绍',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='科目信息表';

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `age` int NOT NULL COMMENT '年龄',
  `gender` int NOT NULL COMMENT '性别',
  `hobby_tag` varchar(900) DEFAULT NULL,
  `biography` varchar(2048) NOT NULL COMMENT '个人简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='老师信息表';

SET FOREIGN_KEY_CHECKS = 1;
