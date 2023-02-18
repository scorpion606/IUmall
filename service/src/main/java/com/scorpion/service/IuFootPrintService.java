package com.scorpion.service;

import com.scorpion.vo.ResultVo;

/**
 * @author scorpion
 * @date 2022/7/1
 */
public interface IuFootPrintService {
    /**
     * 添加我的足迹
     * @param token 用户令牌
     * @param productId 商品ID
     * @return 如果查找成功返回ResultVo对象
     */
    public ResultVo addFootprint(String token,int productId);

    /**
     * 查找我的足迹列表
     * @param token 用户令牌
     * @return 如果查找成功返回ResultVo对象
     */
    public ResultVo listFootPrint(String token);

    /**
     * 查找某一天内的足迹浏览历史
     * @param token 用户令牌
     * @param date 如果查找成功返回ResultVo对象
     * @return
     */
    public ResultVo listLessOneDayFootPrint(String token,String date);
}
