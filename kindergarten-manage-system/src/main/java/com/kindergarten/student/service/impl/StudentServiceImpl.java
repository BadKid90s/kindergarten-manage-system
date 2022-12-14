package com.kindergarten.student.service.impl;

import com.kindergarten.basic.result.PageInfo;
import com.kindergarten.student.dto.StudentDTO;
import com.kindergarten.student.dto.StudentPageDTO;
import com.kindergarten.student.entity.Student;
import com.kindergarten.student.mapper.StudentMapper;
import com.kindergarten.student.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kindergarten.teacher.entity.Teacher;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public PageInfo<List<Student>> getList(StudentPageDTO studentPageDTO) {
        return null;
    }

    @Override
    public Student getInfoById(Long id) {
        return this.getById(id);
    }

    @Override
    public void save(StudentDTO studentDTO) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        this.save(student);
    }

    @Override
    public void modify(StudentDTO studentDTO) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        this.updateById(student);
    }
}
