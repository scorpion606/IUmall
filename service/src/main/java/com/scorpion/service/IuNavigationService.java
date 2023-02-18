package com.scorpion.service;

import com.scorpion.vo.ResultVo;
import org.springframework.stereotype.Service;

/**
 * @author scorpion
 * @date 2022/6/18
 */
public interface IuNavigationService {
    /**
     * 查找首页导航分类信息
     * @param parentId 父ID
     * @return 如果查找成功返回ResultVo对象
     */
    public ResultVo listNavigation(int parentId);
}
