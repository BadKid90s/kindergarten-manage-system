package com.kindergarten.datemanage.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 时间管理表
 * </p>
 *
 * @author lxcecho
 * @since 2022-12-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DateManage对象", description="时间管理表")
public class DateManage extends Model<DateManage> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "开始时间")
    private Date startDate;

    @ApiModelProperty(value = "结束时间")
    private Date endDate;

    @ApiModelProperty(value = "时长（分钟）")
    private Integer time;

    @ApiModelProperty(value = "课程Id")
    private Long courseId;


    @Override
    public Serializable pkVal() {
        return serialVersionUID;
    }

}
