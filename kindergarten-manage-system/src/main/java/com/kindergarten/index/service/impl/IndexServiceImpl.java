package com.kindergarten.index.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kindergarten.classinfo.mapper.ClassInfoMapper;
import com.kindergarten.clockingin.mapper.ClockingInMapper;
import com.kindergarten.course.mapper.CourseMapper;
import com.kindergarten.index.service.IndexService;
import com.kindergarten.index.vo.ClockingVO;
import com.kindergarten.index.vo.StatsCountVO;
import com.kindergarten.recipe.entity.Recipe;
import com.kindergarten.recipe.mapper.RecipeMapper;
import com.kindergarten.student.mapper.StudentMapper;
import com.kindergarten.subjects.mapper.SubjectsMapper;
import com.kindergarten.teacher.mapper.TeacherMapper;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class IndexServiceImpl implements IndexService {

    @Resource
    private SubjectsMapper subjectsMapper;

    @Resource
    private ClassInfoMapper classInfoMapper;

    @Resource
    private TeacherMapper teacherMapper;

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private RecipeMapper recipeMapper;

    @Resource
    private ClockingInMapper clockingInMapper;

    @Override
    public StatsCountVO getStatsCount() {
        Long subjectsNum = subjectsMapper.selectCount(new QueryWrapper<>());
        Long classNum = classInfoMapper.selectCount(new QueryWrapper<>());
        Long teacherNum = teacherMapper.selectCount(new QueryWrapper<>());
        Long studentNum = studentMapper.selectCount(new QueryWrapper<>());
        return new StatsCountVO(subjectsNum, classNum, teacherNum, studentNum);
    }

    @Override
    public List<Recipe> getRecipeList() {
        return recipeMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public ClockingVO getClocking() {
        LocalDate today = LocalDate.now();
        LocalDate monday = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate sunday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
        List<Long> currentWeekData = clockingInMapper.selectWeekData(monday.atStartOfDay(), sunday.atTime(23, 59, 59));

        today = today.plusWeeks(-1);
        monday = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        sunday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
        List<Long> lastWeekData = clockingInMapper.selectWeekData(monday.atStartOfDay(), sunday.atTime(23, 59, 59));

        return new ClockingVO(currentWeekData, lastWeekData);
    }
}
