package com.kindergarten.subjects.mapper;

import com.kindergarten.subjects.entity.Subjects;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 科目信息表 Mapper 接口
 * </p>
 *
 * @author lxcecho
 * @since 2022-12-06
 */
@Repository
@Mapper
public interface SubjectsMapper extends BaseMapper<Subjects> {

}
