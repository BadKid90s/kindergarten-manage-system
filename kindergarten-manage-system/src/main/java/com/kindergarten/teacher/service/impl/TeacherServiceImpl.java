package com.kindergarten.teacher.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.kindergarten.teacher.dto.TeacherDTO;
import com.kindergarten.teacher.entity.Teacher;
import com.kindergarten.teacher.mapper.TeacherMapper;
import com.kindergarten.teacher.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 老师信息表 服务实现类
 * </p>
 *
 * @author lxcecho
 * @since 2022-12-06
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public PageInfo<List<Teacher>> getList(int pageNum, int pageSize) {
        PageMethod.startPage(pageNum, pageSize);
        List<Teacher> teachers = teacherMapper.selectList(new QueryWrapper<>());
        return new PageInfo(teachers);
    }

    @Override
    public Teacher getInfoById(Long id) {
        QueryWrapper<Teacher> teacherQueryWrapper = new QueryWrapper<>();
        teacherQueryWrapper.eq("id", id);
        return teacherMapper.selectOne(teacherQueryWrapper);
    }

    @Override
    public int save(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacherDTO, teacher);
        return teacherMapper.insert(teacher);
    }

    @Override
    public Teacher modify(TeacherDTO teacherDTO) {
        Teacher teacher = this.getInfoById(teacherDTO.getId());
        BeanUtils.copyProperties(teacherDTO, teacher);
        teacherMapper.updateById(teacher);
        return teacher;
    }

    @Override
    public int deleteByIds(List<Long> ids) {
        return teacherMapper.deleteBatchIds(ids);
    }

}
