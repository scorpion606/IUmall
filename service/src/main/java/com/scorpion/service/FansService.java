package com.scorpion.service;

import com.scorpion.vo.ResultVo;

/**
 * @author scorpion
 * @date 2022/10/4
 */
public interface FansService {

    /**
     * 获取粉丝列表
     * @param token 用户令牌
     * @return 返回ResultVo对象
     */
    ResultVo listFans(String token);

    /**
     * 搜索我的粉丝
     * @param token 用户令牌
     * @param keyWord 我的粉丝关键词
     * @return 返回ResultVo对象
     */
    ResultVo searchFans(String token,String keyWord);
}
