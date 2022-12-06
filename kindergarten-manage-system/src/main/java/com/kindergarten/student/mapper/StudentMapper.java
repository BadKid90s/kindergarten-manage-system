package com.kindergarten.student.mapper;

import com.kindergarten.student.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 学生信息表 Mapper 接口
 * </p>
 *
 * @author lxcecho
 * @since 2022-12-06
 */
@Repository
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
