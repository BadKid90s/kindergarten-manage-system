package com.kindergarten.teacher.controller;


import com.kindergarten.basic.result.PageInfo;
import com.kindergarten.teacher.dto.TeacherDTO;
import com.kindergarten.teacher.dto.TeacherPageDTO;
import com.kindergarten.teacher.entity.Teacher;
import com.kindergarten.teacher.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 老师信息表 前端控制器
 * </p>
 *
 * @author lxcecho
 * @since 2022-12-06
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("list")
    public PageInfo<List<Teacher>> getList(TeacherPageDTO teacherPageDTO) {
        return teacherService.getList(teacherPageDTO);
    }

    @GetMapping("getById")
    public Teacher getById(@RequestParam Long id) {
        return teacherService.getInfoById(id);
    }

    @PostMapping("save")
    public int save(@RequestBody TeacherDTO teacherDTO) {
        return teacherService.save(teacherDTO);
    }

    @PutMapping("modify")
    public Teacher modify(@RequestBody TeacherDTO teacherDTO) {
        return teacherService.modify(teacherDTO);
    }

    @DeleteMapping("remove")
    public int deleteByIds(@RequestBody TeacherDTO teacherDTO) {
        return teacherService.deleteByIds(teacherDTO.getIds());
    }

}
