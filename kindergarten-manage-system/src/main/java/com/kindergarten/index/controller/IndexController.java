package com.kindergarten.index.controller;

import com.kindergarten.basic.exception.KindergartenException;
import com.kindergarten.index.service.IndexService;
import com.kindergarten.index.vo.StatsCountVO;
import com.kindergarten.recipe.entity.Recipe;
import com.kindergarten.student.entity.Student;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Resource
    private IndexService indexService;

    @RequestMapping("/e1")
    public Object e1() {
         throw new KindergartenException("XXX");
    }
    @RequestMapping("/e2")
    public Object e2a() {
       throw new RuntimeException("xxxaaa");
    }
    @RequestMapping("/num")
    public Integer a() {
        return 10;
    }

    @RequestMapping(
            value = "/str",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public String str() {
        return "lalalala";
    }

    @RequestMapping("/obj")
    public Object obj() {
        return new Student();
    }

    @RequestMapping("/list")
    public List<Object> list() {
        return Collections.emptyList();
    }

    @RequestMapping("/getStatsCount")
    public StatsCountVO getStatsCount() {
        return indexService.getStatsCount();
    }

    @RequestMapping("/getRecipeList")
    public Map<String, Recipe> getRecipeList() {
        return indexService.getRecipeList();
    }

}
