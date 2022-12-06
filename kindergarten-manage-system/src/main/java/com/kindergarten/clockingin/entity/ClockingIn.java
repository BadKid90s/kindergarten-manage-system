package com.kindergarten.clockingin.entity;

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
 * 学生考勤表
 * </p>
 *
 * @author lxcecho
 * @since 2022-12-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ClockingIn对象", description="学生考勤表")
public class ClockingIn extends Model<ClockingIn> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "学生Id")
    private Long studentId;

    @ApiModelProperty(value = "考勤时间")
    private Date dateTime;

    @ApiModelProperty(value = "考勤类型（1-正常，2-病假，3-事假，4-迟到，5-早退，6-其他）")
    private Integer clockingInType;


    @Override
    public Serializable pkVal() {
        return serialVersionUID;
    }

}
