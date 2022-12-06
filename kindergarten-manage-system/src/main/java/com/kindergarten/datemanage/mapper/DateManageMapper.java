package com.kindergarten.datemanage.mapper;

import com.kindergarten.datemanage.entity.DateManage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 时间管理表 Mapper 接口
 * </p>
 *
 * @author lxcecho
 * @since 2022-12-06
 */
@Repository
@Mapper
public interface DateManageMapper extends BaseMapper<DateManage> {

}
