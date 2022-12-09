package com.kindergarten.index.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatsCountVO {

    /**
     * 课程数量
     */
    private Long courseNum;

    /**
     * 班级数量
     */
    private Long classNum;

    /**
     * 老师数量
     */
    private Long teacherNum;

    /**
     * 学生数量
     */
    private Long studentNum;
}
