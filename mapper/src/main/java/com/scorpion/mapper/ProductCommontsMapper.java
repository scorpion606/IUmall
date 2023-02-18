package com.scorpion.mapper;

import com.scorpion.entity.ProductCommonts;
import com.scorpion.entity.ProductCommontsVo;
import com.scorpion.generator.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ProductCommontsMapper extends BaseMapper<ProductCommonts> {
    /**
     * 分页查询商品评论,注意当mapper层需要传入多个参数，需要借助@param注解表示每一个参数
     * @param productId 商品ID
     * @param start 开始索引
     * @param limit 每页显示条数
     * @return 如果查找成功返回ProductCommentsVo对象List集合
     */
    public List<ProductCommontsVo> selectProductCommontsByProductId(@Param("productId") int productId,
                                                                    @Param("start") int start,
                                                                    @Param("limit") int limit);
}