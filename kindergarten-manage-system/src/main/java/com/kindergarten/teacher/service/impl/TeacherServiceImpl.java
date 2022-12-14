package com.kindergarten.teacher.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kindergarten.basic.exception.KindergartenException;
import com.kindergarten.basic.result.PageInfo;
import com.kindergarten.basic.result.ResultEnum;
import com.kindergarten.teacher.dto.TeacherDTO;
import com.kindergarten.teacher.dto.TeacherPageDTO;
import com.kindergarten.teacher.entity.Teacher;
import com.kindergarten.teacher.mapper.TeacherMapper;
import com.kindergarten.teacher.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 老师信息表 服务实现类
 * </p>
 *
 * @author lxcecho
 * @since 2022-12-06
 */
@Service
@Slf4j
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public PageInfo<List<Teacher>> getList(TeacherPageDTO teacherPageDTO) {
        Page<Teacher> page = new Page<>(teacherPageDTO.getPageNum(), teacherPageDTO.getPageSize());

        LambdaQueryWrapper<Teacher> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.hasLength(teacherPageDTO.getName()), Teacher::getName, teacherPageDTO.getName())
                .eq(Objects.nonNull(teacherPageDTO.getGender()), Teacher::getGender, teacherPageDTO.getGender())
                .eq(StringUtils.hasLength(teacherPageDTO.getHobbyTag()), Teacher::getHobbyTag, teacherPageDTO.getHobbyTag());
        IPage<Teacher> selectPage = teacherMapper.selectPage(page, wrapper);

        return PageInfo.formDbPage(selectPage);
    }

    @Override
    public Teacher getInfoById(Long id) {
        QueryWrapper<Teacher> teacherQueryWrapper = new QueryWrapper<>();
        teacherQueryWrapper.eq("id", id);
        return teacherMapper.selectOne(teacherQueryWrapper);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int save(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacherDTO, teacher);
        return teacherMapper.insert(teacher);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Teacher modify(TeacherDTO teacherDTO) {
        Teacher teacher = this.getInfoById(teacherDTO.getId());
        BeanUtils.copyProperties(teacherDTO, teacher);
        teacherMapper.updateById(teacher);
        return teacher;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteByIds(List<Long> ids) {
        return teacherMapper.deleteBatchIds(ids);
    }

}
