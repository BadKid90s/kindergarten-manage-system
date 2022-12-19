package com.kindergarten.subjects.controller;


import com.kindergarten.basic.result.PageInfo;
import com.kindergarten.subjects.dto.SubjectsDTO;
import com.kindergarten.subjects.dto.SubjectsPageDTO;
import com.kindergarten.subjects.entity.Subjects;
import com.kindergarten.subjects.service.SubjectsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 科目信息表 前端控制器
 * </p>
 *
 * @author lxcecho
 * @since 2022-12-06
 */
@RestController
@RequestMapping("/subjects")
public class SubjectsController {

    private final SubjectsService subjectsService;

    public SubjectsController(SubjectsService subjectsService) {
        this.subjectsService = subjectsService;
    }

    @GetMapping("list")
    public PageInfo<List<Subjects>> getList(SubjectsPageDTO studentPageDTO) {
        return subjectsService.getList(studentPageDTO);
    }

    @GetMapping("getById")
    public Subjects getById(@RequestParam Long id) {
        return subjectsService.getInfoById(id);
    }

    @PostMapping("save")
    public void save(@RequestBody SubjectsDTO subjectsDTO) {
        subjectsService.save(subjectsDTO);
    }

    @PutMapping("modify")
    public void modify(@RequestBody SubjectsDTO subjectsDTO) {
        subjectsService.modify(subjectsDTO);
    }

    @DeleteMapping("remove")
    public void deleteByIds(@RequestBody SubjectsDTO subjectsDTO) {
        subjectsService.removeByIds(subjectsDTO.getIds());
    }
}
