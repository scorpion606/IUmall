package com.scorpion.service;

import com.scorpion.vo.ResultVo;

/**
 * @author scorpion
 * @date 2022/6/19
 */
public interface IuNavigationToProductService {
    public ResultVo listNavigationToProduct(int navigationId,int pageNum,int limit);
}
