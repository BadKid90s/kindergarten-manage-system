package com.kindergarten.index.controller;

import com.kindergarten.basic.exception.KindergartenException;
import com.kindergarten.student.entity.Student;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/index")
public class IndexController {
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

}
