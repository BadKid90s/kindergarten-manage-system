package com.kindergarten.subjects.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class SubjectsPageDTO {
    @ApiModelProperty(value = "查询页码")
    private Integer pageNum;

    @ApiModelProperty(value = "每页数目")
    private Integer pageSize;

    @ApiModelProperty(value = "姓名")
    private String name;

}
