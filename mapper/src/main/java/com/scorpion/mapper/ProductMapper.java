package com.scorpion.mapper;

import com.scorpion.entity.Product;
import com.scorpion.entity.ProductToProductImgVo;
import com.scorpion.entity.ProductVo;
import com.scorpion.generator.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;


public interface ProductMapper extends BaseMapper<Product> {
    /**
     * 查询最新上架的四个商品并推荐
     * @return 如果查找成功返回以ProductVo形式的List集合，否则返回null
     */
    public List<ProductVo> selectRecommendProductions();

    /**
     * 查询销量前六的商品
     * @param categoryId
     * @return
     */
    public List<ProductVo> selectTopSexProductions(int categoryId);

    /**
     * 分类查询商品信息并分页展示
     * @param categoryId 商品分类ID
     * @param start 开始索引
     * @param limit 每页显示商品数量
     * @return 如果查找成功返回以productVo为对象的List集合
     */
    public List<ProductVo> selectCategoryProducts(@Param("categoryId") int categoryId, @Param("start") int start, @Param("limit") int limit);

    /**
     * 分类查询商品品牌
     * @param categoryId 商品分类ID
     * @return 如果查找成功以String对象返回List集合
     */
    public List<String> selectBrandByCategoryId(int categoryId);

    /**
     * 根据关键词查找商品
     * @param keyWord 搜索关键词
     * @param start 开始的索引
     * @param limit 每页显示商品数量
     * @return 如果查找成功返回以productVo为对象的List集合
     */
    public List<ProductVo> selectProductByKeyWord(@Param("keyWord") String keyWord, @Param("start") int start, @Param("limit") int limit);

    /**
     * 查询全部商品信息
     * @return 如果查找成功返回以productVo为对象的List集合
     */
    public List<ProductVo> selectProductToEs();

    /**
     * 根据关键词查找商品品牌
     * @param keyWord 关键词
     * @return 如果查找成功返回以String为对象的list集合
     */
    public List<String> selectBrandByKeyWord(String keyWord);

    public List<ProductVo> selectSwitchProduct(@Param("categoryId") int categoryId,
                                               @Param("start") int start,
                                               @Param("limit") int limit);

    /**
     * 根据商品ID查找商品信息
     * @param productId 商品ID
     * @return 如果查找成功返回ProductVo对象
     */
    public List<ProductVo> selectProductBypId(String productId);

    public ProductVo selectProductByProductId(int productId);

    public ProductToProductImgVo selectProductToProductImg(int productId);

}