package com.kindergarten.course.service.impl;

import com.kindergarten.course.entity.Course;
import com.kindergarten.course.mapper.CourseMapper;
import com.kindergarten.course.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程信息表 服务实现类
 * </p>
 *
 * @author lxcecho
 * @since 2022-12-06
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

}
