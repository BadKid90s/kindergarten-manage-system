package com.kindergarten.subjects.service;

import com.kindergarten.basic.result.PageInfo;
import com.kindergarten.subjects.dto.SubjectsDTO;
import com.kindergarten.subjects.dto.SubjectsPageDTO;
import com.kindergarten.subjects.entity.Subjects;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 科目信息表 服务类
 * </p>
 *
 * @author lxcecho
 * @since 2022-12-06
 */
public interface SubjectsService extends IService<Subjects> {

    PageInfo<List<Subjects>> getList(SubjectsPageDTO studentPageDTO);

    Subjects getInfoById(Long id);

    void save(SubjectsDTO subjectsDTO);

    void modify(SubjectsDTO subjectsDTO);
}
