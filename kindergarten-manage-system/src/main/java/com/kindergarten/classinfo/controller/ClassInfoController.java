package com.kindergarten.classinfo.controller;


import com.kindergarten.classinfo.service.ClassInfoService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 班级信息表 前端控制器
 * </p>
 *
 * @author lxcecho
 * @since 2022-12-06
 */
@RestController
@RequestMapping("/class_info/class-info")
public class ClassInfoController {

    @Resource
    private ClassInfoService classInfoService;

}
