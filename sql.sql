create database if not exists `kindergarten` character set utf8mb4;

use `kindergarten`;

create table `teacher`
(
    `id`        bigint auto_increment comment '主键',
    `name`      varchar(20)   not null comment '姓名',
    `age`       varchar(20)   not null comment '年龄',
    `gender`    varchar(20)   not null comment '性别',
    `hobby_tag` varchar(255)  not null comment '爱好',
    `biography` varchar(2048) not null comment '个人简介',
    key (id)
) engine = InnoDB
  default charset = utf8mb4 comment ='老师信息表';


create table `student`
(
    `id`             bigint auto_increment comment '主键',
    `name`           varchar(20)  not null comment '姓名',
    `age`            varchar(20)  not null comment '年龄',
    `gender`         varchar(20)  not null comment '性别',
    `birthday`       date         not null comment '出生日期',
    `guardian_name`  varchar(20)  not null comment '监护人姓名',
    `guardian_phone` varchar(255) not null comment '监护人电话',
    key (id)
) engine = InnoDB
  default charset = utf8mb4 comment ='学生信息表';


create table `class_info`
(
    `id`              bigint auto_increment comment '主键',
    `name`            varchar(20)   not null comment '班级名称',
    `introduce`       varchar(1025) not null comment '班级介绍',
    `head_teacher_id` bigint        not null comment '班主任Id',
    key (id)
) engine = InnoDB
  default charset = utf8mb4 comment ='班级信息表';


create table `rela_teacher_class`
(
    `teacher_id`    bigint not null comment '老师Id',
    `class_info_id` bigint not null comment '班级Id',
    key (teacher_id, class_info_id)
) engine = InnoDB
  default charset = utf8mb4 comment ='老师班级关系表';


create table `rela_student_class`
(
    `student_id`    bigint not null comment '学生Id',
    `class_info_id` bigint not null comment '班级Id',
    key (student_id, class_info_id)
) engine = InnoDB
  default charset = utf8mb4 comment ='学生班级关系表';


create table `subjects`
(
    `id`        bigint auto_increment comment '主键',
    `name`      varchar(20)   not null comment '科目名称',
    `introduce` varchar(1025) not null comment '科目介绍',
    key (id)
) engine = InnoDB
  default charset = utf8mb4 comment ='科目信息表';


create table `course`
(
    `id`            bigint auto_increment comment '主键',
    `subjects_id`   bigint not null comment '科目Id',
    `class_info_id` bigint not null comment '班级Id',
    `teacher_id`    bigint not null comment '老师Id',
    key (id)
) engine = InnoDB
  default charset = utf8mb4 comment ='课程信息表';


create table `date_manage`
(
    `id`         bigint auto_increment comment '主键',
    `start_date` time   not null comment '开始时间',
    `end_date`   time   not null comment '结束时间',
    `time`       int    not null comment '时长（分钟）',
    `course_id`  bigint not null comment '课程Id',
    key (id)
) engine = InnoDB
  default charset = utf8mb4 comment ='时间管理表';

create table `clocking_in`
(
    `id`               bigint auto_increment comment '主键',
    `student_id`       bigint   not null comment '学生Id',
    `date_time`        datetime not null comment '考勤时间',
    `clocking_in_type` int      not null comment '考勤类型（1-正常，2-病假，3-事假，4-迟到，5-早退，6-其他）',
    key (id)
) engine = InnoDB
  default charset = utf8mb4 comment ='学生考勤表';


create table `recipe`
(
    `id`                  bigint auto_increment comment '星期一-主键',
    `monday_breakfast`    varchar(255) not null comment '星期一-早餐',
    `monday_lunch`        varchar(255) not null comment '星期一-午餐',
    `monday_dinner`       varchar(255) not null comment '星期二-晚餐',
    `tuesday_breakfast`   varchar(255) not null comment '星期二-早餐',
    `tuesday_lunch`       varchar(255) not null comment '星期二-午餐',
    `tuesday_dinner`      varchar(255) not null comment '星期三-晚餐',
    `wednesday_breakfast` varchar(255) not null comment '星期三-早餐',
    `wednesday_lunch`     varchar(255) not null comment '星期三-午餐',
    `wednesday_dinner`    varchar(255) not null comment '星期四-晚餐',
    `thursday_breakfast`  varchar(255) not null comment '星期四-早餐',
    `thursday__lunch`     varchar(255) not null comment '星期四-午餐',
    `thursday__dinner`    varchar(255) not null comment '星期五-晚餐',
    `friday_breakfast`    varchar(255) not null comment '星期五-早餐',
    `friday_lunch`        varchar(255) not null comment '星期五-午餐',
    `friday_dinner`       varchar(255) not null comment '星期五-晚餐',
    key (id)
) engine = InnoDB
  default charset = utf8mb4 comment ='食谱信息表';
