package com.kindergarten.index.controller;

import com.kindergarten.index.service.IndexService;
import com.kindergarten.index.vo.ClockingVO;
import com.kindergarten.index.vo.StatsCountVO;
import com.kindergarten.recipe.entity.Recipe;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Resource
    private IndexService indexService;

    @GetMapping("/statistic")
    public StatsCountVO getStatsCount() {
        return indexService.getStatsCount();
    }

    @GetMapping("/clocking")
    public ClockingVO getClocking() {
        return indexService.getClocking();
    }

    @GetMapping("/recipe")
    public List<Recipe> getRecipeList() {
        return indexService.getRecipeList();
    }

}
