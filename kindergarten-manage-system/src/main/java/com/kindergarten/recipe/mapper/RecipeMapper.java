package com.kindergarten.recipe.mapper;

import com.kindergarten.recipe.entity.Recipe;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 食谱信息表 Mapper 接口
 * </p>
 *
 * @author lxcecho
 * @since 2022-12-06
 */
@Repository
@Mapper
public interface RecipeMapper extends BaseMapper<Recipe> {

}
