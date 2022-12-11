package com.kindergarten.teacher.service;

import com.github.pagehelper.PageInfo;
import com.kindergarten.teacher.dto.TeacherDTO;
import com.kindergarten.teacher.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 老师信息表 服务类
 * </p>
 *
 * @author lxcecho
 * @since 2022-12-06
 */
public interface TeacherService extends IService<Teacher> {

    /**
     * Getting the teacher paging list data.
     *
     * @param pageNum  Query page number
     * @param pageSize Number per page
     * @return list teachers
     */
    PageInfo<List<Teacher>> getList(int pageNum, int pageSize);

    /**
     * Getting teacher's info by primary key id.
     *
     * @param id primary key
     * @return Query Obj
     */
    Teacher getInfoById(Long id);

    /**
     * Saving teacher's info.
     *
     * @param teacherDTO input obj
     * @return Number of successful records saved.
     */
    int save(TeacherDTO teacherDTO);

    /**
     * Modifying teacher's info.
     *
     * @param teacherDTO input obj
     * @return The object to be modified.
     */
    Teacher modify(TeacherDTO teacherDTO);

    /**
     * Deleting teacher's info By Ids.
     *
     * @return Number of successful records deleted.
     */
    int deleteByIds(List<Long> ids);

}
