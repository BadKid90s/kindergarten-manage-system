package com.kindergarten.teacher.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kindergarten.basic.exception.KindergartenException;
import com.kindergarten.basic.result.PageInfo;
import com.kindergarten.basic.result.ResultEnum;
import com.kindergarten.teacher.dto.TeacherDTO;
import com.kindergarten.teacher.entity.Teacher;
import com.kindergarten.teacher.mapper.TeacherMapper;
import com.kindergarten.teacher.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
@Slf4j
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public PageInfo<List<Teacher>> getList(int pageNum, int pageSize) {
        Page<Teacher> page = new Page<>(pageNum, pageSize);

        IPage<Teacher> selectPage = teacherMapper.selectPage(page, new QueryWrapper<>());

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
        try {
            Teacher teacher = new Teacher();
            BeanUtils.copyProperties(teacherDTO, teacher);
            return teacherMapper.insert(teacher);
        } catch (Exception e) {
            log.error("ex: {}", e.getMessage());
            throw new KindergartenException(ResultEnum.SYSTEM_ERROR.getCode(), e.getMessage());
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Teacher modify(TeacherDTO teacherDTO) {
        try {
            Teacher teacher = this.getInfoById(teacherDTO.getId());
            BeanUtils.copyProperties(teacherDTO, teacher);
            teacherMapper.updateById(teacher);
            return teacher;
        } catch (Exception e) {
            log.error("ex: {}", e.getMessage());
            throw new KindergartenException(ResultEnum.SYSTEM_ERROR.getCode(), e.getMessage());
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteByIds(List<Long> ids) {
        try {
            return teacherMapper.deleteBatchIds(ids);
        } catch (Exception e) {
            log.error("ex: {}", e.getMessage());
            throw new KindergartenException(ResultEnum.SYSTEM_ERROR.getCode(), e.getMessage());
        }
    }

}
