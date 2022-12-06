package com.kindergarten.recipe.entity;

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
 * 食谱信息表
 * </p>
 *
 * @author lxcecho
 * @since 2022-12-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Recipe对象", description="食谱信息表")
public class Recipe extends Model<Recipe> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "早餐")
    private String breakfast;

    @ApiModelProperty(value = "午餐")
    private String lunch;

    @ApiModelProperty(value = "晚餐")
    private String dinner;

    @ApiModelProperty(value = "星期几")
    private String name;

    @ApiModelProperty(value = "顺序")
    private Integer sort;


    @Override
    public Serializable pkVal() {
        return serialVersionUID;
    }

}
