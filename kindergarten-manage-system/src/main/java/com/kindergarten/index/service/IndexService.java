package com.kindergarten.index.service;

import com.kindergarten.basic.result.ResultVO;
import com.kindergarten.index.vo.StatsCountVO;


public interface IndexService {

    /**
     * 获取首页各项统计数据
     */
    ResultVO<StatsCountVO> getStatsCount();
}
