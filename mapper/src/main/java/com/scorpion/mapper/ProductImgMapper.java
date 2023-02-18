package com.scorpion.mapper;

import com.scorpion.entity.ProductImg;
import com.scorpion.generator.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ProductImgMapper extends BaseMapper<ProductImg> {
    /**
     * 实现根据商品ID子查询商品图片
     * @param productId 商品ID
     * @return 如果查找成功以ProductImg对象返回List集合
     */
    public List<ProductImg> selectProductImgsByProductId(int productId);

    public List<ProductImg> selectProductDetailImagesByPid(int productId);
}