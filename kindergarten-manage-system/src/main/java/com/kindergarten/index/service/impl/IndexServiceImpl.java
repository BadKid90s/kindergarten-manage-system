package com.kindergarten.index.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kindergarten.basic.result.ResultVO;
import com.kindergarten.classinfo.mapper.ClassInfoMapper;
import com.kindergarten.course.mapper.CourseMapper;
import com.kindergarten.index.service.IndexService;
import com.kindergarten.index.vo.StatsCountVO;
import com.kindergarten.student.mapper.StudentMapper;
import com.kindergarten.teacher.mapper.TeacherMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IndexServiceImpl implements IndexService {

    @Resource
    private CourseMapper courseMapper;

    @Resource
    private ClassInfoMapper classInfoMapper;

    @Resource
    private TeacherMapper teacherMapper;

    @Resource
    private StudentMapper studentMapper;

    @Override
    public ResultVO<StatsCountVO> getStatsCount() {
        Long courseNum = courseMapper.selectCount(new QueryWrapper<>());
        Long classNum = classInfoMapper.selectCount(new QueryWrapper<>());
        Long teacherNum = teacherMapper.selectCount(new QueryWrapper<>());
        Long studentNum = studentMapper.selectCount(new QueryWrapper<>());
        return ResultVO.success(new StatsCountVO(courseNum, classNum, teacherNum, studentNum));
    }
}
