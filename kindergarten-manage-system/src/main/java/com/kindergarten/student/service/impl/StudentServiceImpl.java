package com.kindergarten.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

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
        Page<Student> page = new Page<>(studentPageDTO.getPageNum(), studentPageDTO.getPageSize());

        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.hasLength(studentPageDTO.getName()), Student::getName, studentPageDTO.getName())
                .eq(Objects.nonNull(studentPageDTO.getGender()), Student::getGender, studentPageDTO.getGender())
                .like(StringUtils.hasLength(studentPageDTO.getGuardianName()), Student::getGuardianName, studentPageDTO.getGuardianName())
                .eq(Objects.nonNull(studentPageDTO.getGuardianPhone()), Student::getGuardianPhone, studentPageDTO.getGuardianPhone());
        IPage<Student> selectPage = baseMapper.selectPage(page, wrapper);

        return PageInfo.formDbPage(selectPage);
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
