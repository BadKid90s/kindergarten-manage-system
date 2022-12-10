package com.kindergarten.index.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClockingVO {
    /**
     * 本周数据
     */
    private List<Long> currentWeekData;

    /**
     * 上周数据
     */
    private List<Long> lastWeekData;
}
