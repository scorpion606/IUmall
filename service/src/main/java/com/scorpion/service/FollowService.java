package com.scorpion.service;

import com.scorpion.vo.ResultVo;

/**
 * @author scorpion
 * @date 2022/10/4
 */
public interface FollowService {
    /**
     * 添加关注
     * @param token 用户令牌
     * @param followId 关注人ID
     * @return 返回ResultVo对象
     */
    ResultVo addFollow(String token, int followId);

    /**
     * 获取动态总数，关注总数，粉丝总数
     * @param token 用户令牌
     * @return
     */
    ResultVo listCount(String token);

    /**
     * 获取关注列表
     * @param token 用户令牌
     * @return 返回ResultVo对象
     */
    ResultVo listFollow(String token);

    /**
     * 添加特别关注
     * @param token 用户令牌
     * @param followId 关注人ID
     * @return 返回ResultVO
     */
    ResultVo addSpecialFollow(String token,int followId);

    /**
     * 取消关注
     * @param token 用户令牌
     * @param followId 关注人ID
     * @return 返回ResultVo对象
     */
    ResultVo cancelFollow(String token,int followId);

    /**
     * 搜索我的关注
     * @param token 用户令牌
     * @param keyWord 我的关注关键词
     * @return 返回ResultVO对象
     */
    ResultVo searchFollow(String token,String keyWord);
}
