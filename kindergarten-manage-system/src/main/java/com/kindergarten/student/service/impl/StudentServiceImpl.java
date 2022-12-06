package com.kindergarten.student.service.impl;

import com.kindergarten.student.entity.Student;
import com.kindergarten.student.mapper.StudentMapper;
import com.kindergarten.student.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生信息表 服务实现类
 * </p>
 *
 * @author lxcecho
 * @since 2022-12-06
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
