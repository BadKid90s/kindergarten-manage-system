package com.kindergarten.student.controller;


import com.kindergarten.basic.result.PageInfo;
import com.kindergarten.student.dto.StudentDTO;
import com.kindergarten.student.entity.Student;
import com.kindergarten.student.service.StudentService;
import com.kindergarten.student.dto.StudentPageDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 学生信息表 前端控制器
 * </p>
 *
 * @author lxcecho
 * @since 2022-12-06
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("list")
    public PageInfo<List<Student>> getList(StudentPageDTO studentPageDTO) {
        return studentService.getList(studentPageDTO);
    }

    @GetMapping("getById")
    public Student getById(@RequestParam Long id) {
        return studentService.getInfoById(id);
    }

    @PostMapping("save")
    public void save(@RequestBody StudentDTO studentDTO) {
        studentService.save(studentDTO);
    }

    @PutMapping("modify")
    public void modify(@RequestBody StudentDTO studentDTO) {
        studentService.modify(studentDTO);
    }

    @DeleteMapping("remove")
    public void deleteByIds(@RequestBody StudentDTO studentDTO) {
        studentService.removeByIds(studentDTO.getIds());
    }
}
