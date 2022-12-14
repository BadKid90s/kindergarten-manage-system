package com.kindergarten.teacher.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author lxcecho 909231497@qq.com
 * @since 13:22 11-12-2022
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class TeacherPageDTO {

    @ApiModelProperty(value = "查询页码")
    private Integer pageNum;

    @ApiModelProperty(value = "每页数目")
    private Integer pageSize;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private Integer gender;

    @ApiModelProperty(value = "爱好")
    private String hobbyTag;

}
