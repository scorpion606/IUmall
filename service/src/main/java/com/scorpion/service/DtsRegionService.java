package com.scorpion.service;

import com.scorpion.vo.ResultVo;

/**
 * @author scorpion
 * @date 2022/3/27
 */
public interface DtsRegionService {
    /**
     * 实现查找一级、二级、三级行政区域
     * @return 如果查找成功返回ResultVo对象
     */
    public ResultVo listDtsRegion();
}
