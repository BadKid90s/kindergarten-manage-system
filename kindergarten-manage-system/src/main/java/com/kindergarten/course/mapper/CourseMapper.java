package com.kindergarten.course.mapper;

import com.kindergarten.course.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 课程信息表 Mapper 接口
 * </p>
 *
 * @author lxcecho
 * @since 2022-12-06
 */
@Repository
@Mapper
public interface CourseMapper extends BaseMapper<Course> {

}
