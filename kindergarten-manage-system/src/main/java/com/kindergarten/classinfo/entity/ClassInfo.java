package com.kindergarten.classinfo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 班级信息表
 * </p>
 *
 * @author lxcecho
 * @since 2022-12-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ClassInfo对象", description="班级信息表")
public class ClassInfo extends Model<ClassInfo> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "班级名称")
    private String name;

    @ApiModelProperty(value = "班级介绍")
    private String introduce;

    @ApiModelProperty(value = "班主任Id")
    private Long headTeacherId;


    @Override
    public Serializable pkVal() {
        return serialVersionUID;
    }

}
