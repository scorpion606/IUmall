package com.scorpion.service;

import com.scorpion.vo.ResultVo;

/**
 * @author scorpion
 * @date 2022/10/16
 */
public interface DynamicService {
    /**
     * 获取动态列表
     * @param pageNum 初始索引
     * @param limit 每页显示数量
     * @return 返回ResultVo对象
     */
    ResultVo listDynamic(int pageNum,int limit);
}
