package com.kindergarten.student.service;

import com.kindergarten.basic.result.PageInfo;
import com.kindergarten.student.dto.StudentDTO;
import com.kindergarten.student.dto.StudentPageDTO;
import com.kindergarten.student.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 学生信息表 服务类
 * </p>
 *
 * @author lxcecho
 * @since 2022-12-06
 */
public interface StudentService extends IService<Student> {

    PageInfo<List<Student>> getList(StudentPageDTO studentPageDTO);

    Student getInfoById(Long id);

    void save(StudentDTO studentDTO);

    void modify(StudentDTO studentDTO);
}
