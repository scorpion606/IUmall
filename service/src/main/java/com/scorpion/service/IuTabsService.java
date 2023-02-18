package com.scorpion.service;

import com.scorpion.vo.ResultVo;

/**
 * @author scorpion
 * @date 2022/6/17
 */
public interface IuTabsService {
    /**
     * 查找首页标签
     * @return 如果查找成功返回ResultVo对象
     */
    public ResultVo listIuTabs();

    /**
     * 查找我的收藏标签
     * @return 如果查找成功返回ResultVo对象
     */
    public ResultVo listTabsToCollect();

}
