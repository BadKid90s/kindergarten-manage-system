package com.kindergarten.index.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kindergarten.classinfo.mapper.ClassInfoMapper;
import com.kindergarten.course.mapper.CourseMapper;
import com.kindergarten.index.service.IndexService;
import com.kindergarten.index.vo.StatsCountVO;
import com.kindergarten.recipe.entity.Recipe;
import com.kindergarten.recipe.mapper.RecipeMapper;
import com.kindergarten.student.mapper.StudentMapper;
import com.kindergarten.teacher.mapper.TeacherMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class IndexServiceImpl implements IndexService {

    @Resource
    private CourseMapper courseMapper;

    @Resource
    private ClassInfoMapper classInfoMapper;

    @Resource
    private TeacherMapper teacherMapper;

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private RecipeMapper recipeMapper;

    @Override
    public StatsCountVO getStatsCount() {
        Long courseNum = courseMapper.selectCount(new QueryWrapper<>());
        Long classNum = classInfoMapper.selectCount(new QueryWrapper<>());
        Long teacherNum = teacherMapper.selectCount(new QueryWrapper<>());
        Long studentNum = studentMapper.selectCount(new QueryWrapper<>());
        return new StatsCountVO(courseNum, classNum, teacherNum, studentNum);
    }

    @Override
    public Map<String, Recipe> getRecipeList() {
        List<Recipe> recipes = recipeMapper.selectList(new QueryWrapper<>());
        Map<String, Recipe> recipeMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(recipes)) {
            recipeMap = recipes
                    .stream()
                    .collect(Collectors.toMap(Recipe::getName, recipe -> recipe));
        }
        return recipeMap;
    }
}
