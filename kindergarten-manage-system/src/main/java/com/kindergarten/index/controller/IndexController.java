package com.kindergarten.index.controller;

import com.kindergarten.index.service.IndexService;
import com.kindergarten.index.vo.StatsCountVO;
import com.kindergarten.recipe.entity.Recipe;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Resource
    private IndexService indexService;

    @RequestMapping("/getStatsCount")
    public StatsCountVO getStatsCount() {
        return indexService.getStatsCount();
    }

    @RequestMapping("/getRecipeList")
    public Map<String, Recipe> getRecipeList() {
        return indexService.getRecipeList();
    }

}
