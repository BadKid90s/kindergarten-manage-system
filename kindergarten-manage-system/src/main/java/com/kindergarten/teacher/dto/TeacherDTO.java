package com.kindergarten.teacher.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author lxcecho 909231497@qq.com
 * @since 13:22 11-12-2022
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class TeacherDTO {

    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private int age;

    @ApiModelProperty(value = "性别")
    private boolean gender;

    @ApiModelProperty(value = "爱好")
    private String hobbyTag;

    @ApiModelProperty(value = "个人简介")
    private String biography;

    @ApiModelProperty(value = "主键列表")
    private List<Long> ids;

}
