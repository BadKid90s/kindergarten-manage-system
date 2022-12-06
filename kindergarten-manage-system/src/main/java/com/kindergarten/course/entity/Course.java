package com.kindergarten.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 课程信息表
 * </p>
 *
 * @author lxcecho
 * @since 2022-12-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Course对象", description="课程信息表")
public class Course extends Model<Course> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "科目Id")
    private Long subjectsId;

    @ApiModelProperty(value = "班级Id")
    private Long classInfoId;

    @ApiModelProperty(value = "老师Id")
    private Long teacherId;


    @Override
    public Serializable pkVal() {
        return serialVersionUID;
    }

}
