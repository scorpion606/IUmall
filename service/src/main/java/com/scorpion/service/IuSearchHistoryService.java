package com.scorpion.service;

import com.scorpion.vo.ResultVo;

/**
 * @author scorpion
 * @date 2022/4/21
 */
public interface IuSearchHistoryService {
    /**
     * 查找某个用户的搜索历史
     * @return 如果查找成功返回ResultVo对象
     */
    public ResultVo listSearchHistory(int userId,int start,int end);

    /**
     * 保存某个用户的搜索历史记录
     * @param userId 用户ID
     * @param top Redis存储搜索历史上限
     * @param keyWord 搜索记录
     * @return 如果查找成功返回ResultVo对象
     */
    public ResultVo saveSearchHistory(int userId,int top,String keyWord);

    /**
     * 通过搜索记录删除
     * @param userId 用户ID
     * @param keyword 搜索记录
     * @return 如果查找成功返回ResultVo对象
     */
    public ResultVo deleteSearchHistoryBuKeyword(int userId,String keyword);

    /**
     * 删除全部搜索历史记录
     * @param userId 用户Id
     * @return 如果查找成功返回ResultVo对象
     */
    public ResultVo deleteAll(int userId);
}
