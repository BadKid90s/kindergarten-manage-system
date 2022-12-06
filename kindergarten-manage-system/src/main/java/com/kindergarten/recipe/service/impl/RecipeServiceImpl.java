package com.kindergarten.recipe.service.impl;

import com.kindergarten.recipe.entity.Recipe;
import com.kindergarten.recipe.mapper.RecipeMapper;
import com.kindergarten.recipe.service.RecipeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 食谱信息表 服务实现类
 * </p>
 *
 * @author lxcecho
 * @since 2022-12-06
 */
@Service
public class RecipeServiceImpl extends ServiceImpl<RecipeMapper, Recipe> implements RecipeService {

}
