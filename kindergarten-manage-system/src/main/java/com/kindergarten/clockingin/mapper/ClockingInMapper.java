package com.kindergarten.clockingin.mapper;

import com.kindergarten.clockingin.entity.ClockingIn;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 学生考勤表 Mapper 接口
 * </p>
 *
 * @author lxcecho
 * @since 2022-12-06
 */
@Repository
@Mapper
public interface ClockingInMapper extends BaseMapper<ClockingIn> {

   List<Long> selectWeekData(@Param("starDate") LocalDateTime starDate, @Param("endDate") LocalDateTime endDate);

}
