package com.scorpion.service;

import com.scorpion.entity.IuFeedBack;
import com.scorpion.vo.ResultVo;

/**
 * @author scorpion
 * @date 2022/7/5
 */
public interface IuFeedBackService {
    /**
     * 查找意见反馈
     * @param token 用户令牌
     * @param pageNum 页码
     * @param limit 每页数量
     * @return 如果查找成功返回ResultVo对象
     */
    public ResultVo listFeedback(String token,int pageNum,int limit);

    /**
     * 添加意见反馈
     * @param token 用户令牌
     * @param feedBack feedBakc对象
     * @return 如果添加成功返回ResultVo对象
     */
    public ResultVo addFeedBack(String token, IuFeedBack feedBack);

    /**
     * 通过id查找意见反馈
     * @param id 意见反馈Id
     * @return 如果查找成功返回ResultVo对象
     */
    public ResultVo getFeedBackById(int id);
}
