package com.scorpion.service;

import com.scorpion.vo.ResultVo;

/**
 * @author scorpion
 * @date 2021/11/20
 */
public interface ProductCommontsService {
    /**
     * 实现查询商品评论功能，调用Mapper层的selectProductCommontsByProductId方法
     * @param ProductId 商品ID
     * @param pageNum 商品当前页码
     * @param limit  商品每页显示的评论数
     * @return 如果查找成功放回ResultVo对象
     */
    public ResultVo listProductCommonts(int ProductId,int pageNum,int limit);

    /**
     * 实现根据商品ID统计商品评价信息
     * @param ProductId 商品ID
     * @return 如果查找成功返回ResultVo对象
     */
    public ResultVo listProductCount(int ProductId);
}
