package com.kindergarten.index.service;

import com.kindergarten.basic.result.ResultVO;
import com.kindergarten.index.vo.StatsCountVO;
import com.kindergarten.recipe.entity.Recipe;

import java.util.Map;


public interface IndexService {

    /**
     * 获取首页各项统计数据
     */
    ResultVO<StatsCountVO> getStatsCount();

    /**
     * 获取所有食谱信息
     * @return Map<String, Recipe> key：星期，value：食谱信息
     */
    ResultVO<Map<String, Recipe>> getRecipeList();


}
