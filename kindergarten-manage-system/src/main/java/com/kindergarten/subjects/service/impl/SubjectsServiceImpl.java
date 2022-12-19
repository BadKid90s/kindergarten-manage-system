package com.kindergarten.subjects.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kindergarten.basic.result.PageInfo;
import com.kindergarten.student.entity.Student;
import com.kindergarten.subjects.dto.SubjectsDTO;
import com.kindergarten.subjects.dto.SubjectsPageDTO;
import com.kindergarten.subjects.entity.Subjects;
import com.kindergarten.subjects.mapper.SubjectsMapper;
import com.kindergarten.subjects.service.SubjectsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 科目信息表 服务实现类
 * </p>
 *
 * @author lxcecho
 * @since 2022-12-06
 */
@Service
public class SubjectsServiceImpl extends ServiceImpl<SubjectsMapper, Subjects> implements SubjectsService {

    @Override
    public PageInfo<List<Subjects>> getList(SubjectsPageDTO subjectsPageDTO) {
        Page<Subjects> page = new Page<>(subjectsPageDTO.getPageNum(), subjectsPageDTO.getPageSize());

        LambdaQueryWrapper<Subjects> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.hasLength(subjectsPageDTO.getName()), Subjects::getName, subjectsPageDTO.getName());
        IPage<Subjects> selectPage = baseMapper.selectPage(page, wrapper);

        return PageInfo.formDbPage(selectPage);
    }

    @Override
    public Subjects getInfoById(Long id) {
        return this.getById(id);
    }

    @Override
    public void save(SubjectsDTO subjectsDTO) {
        Subjects subjects = new Subjects();
        BeanUtils.copyProperties(subjectsDTO, subjects);
        this.save(subjects);
    }

    @Override
    public void modify(SubjectsDTO subjectsDTO) {
        Subjects subjects = new Subjects();
        BeanUtils.copyProperties(subjectsDTO, subjects);
        this.updateById(subjects);
    }
}
