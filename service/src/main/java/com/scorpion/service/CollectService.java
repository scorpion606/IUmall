package com.scorpion.service;

import com.scorpion.vo.ResultVo;

/**
 * @author scorpion
 * @date 2022/9/7
 */
public interface CollectService {
    /**
     *
     * @param token 用户令牌
     * @param valueId 被收藏Id
     * @param type 收藏类型
     * @return 返回ResultVo对象
     */
    public ResultVo addCollect(String token, int valueId, int type);

    /**
     *
     * @param token 用户令牌
     * @param valueId 被收藏Id
     * @param type 收藏类型
     * @return 返回ResultVo对象
     */
    public ResultVo cancelCollect(String token,int valueId,int type);

    /**
     * 查找收藏数据
     * @param token 用户令牌
     * @param type 收藏类型
     * @return 如果查找成功返回ResultVo对象
     */
    public ResultVo selectCollect(String token,int type);

    /**
     * 查找是否存在该收藏
     * @param token 用户令牌
     * @param valueId 被收藏Id
     * @param type 收藏类型
     * @return 如果查找成功返回ResultVo对象
     */
    public ResultVo hasCollect(String token,int valueId,int type);
}
