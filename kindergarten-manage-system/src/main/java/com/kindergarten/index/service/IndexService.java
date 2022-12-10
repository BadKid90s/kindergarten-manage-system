package com.kindergarten.index.service;

import com.kindergarten.index.vo.ClockingVO;
import com.kindergarten.index.vo.StatsCountVO;
import com.kindergarten.recipe.entity.Recipe;

import java.util.List;
import java.util.Map;


public interface IndexService {

    /**
     * 获取首页各项统计数据
     */
    StatsCountVO getStatsCount();

    /**
     * 获取所有食谱信息
     */
   List<Recipe> getRecipeList();


    /**
     * 获取本周和上周周一至周五的打卡人数
     */
    ClockingVO getClocking();
}
