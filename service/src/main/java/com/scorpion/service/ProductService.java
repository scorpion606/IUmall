package com.scorpion.service;

import com.scorpion.vo.ResultVo;


/**
 * @author scorpion
 * @date 2021/11/13
 */
public interface ProductService {
    /**
     * 实现商品推荐功能，调用mapper层的selectRecommendProductions方法
     * @return 如果查找成功返回ResultVo对象
     */
    public ResultVo listRecommendProductions();

    /**
     * 实现商品详情功能
     * @param productId 商品ID
     * @return 如果查找成功返回ResultVo对象
     */
    public ResultVo listProductsDetails(int productId);

    /**
     * 实现商品参数功能
     * @param productId 商品ID
     * @return 如果查找成功返回ResultVo对象
     */
    public ResultVo listProductPrams(int productId);

    /**
     *实现分类查找商品并分页显示
     * @param categoryId 分类ID
     * @param pageNum 商品当前页
     * @param limit 每页显示商品数量
     * @return
     */
    public ResultVo listCategoryProducts(int categoryId, int pageNum,int limit);



    /**
     * 查找某个分类下的品牌名称
     * @param categoryId
     * @return
     */
    public ResultVo listBrandProducts(int categoryId);

    /**
     * 根据关键词查找商品
     * @param keyWord 关键词
     * @param pageNum 当前页码
     * @param limit 每页显示的商品个数
     * @return 如果查找成功以ResultVo对象返回
     */
    public ResultVo listProductByKeyWord(String keyWord,int pageNum,int limit);


    /**
     * 根据关键词查找商品品牌
     * @param keyWord 关键词
     * @return 如果查找成功返回ResultVo对象
     */
    public ResultVo listBrandByKeyWord(String keyWord);

    /**
     * 根据输入的关键词查找商品信息
     * @param keyWord 关键词
     * @return 如果查找成功返回ResultVo对象
     */
    public ResultVo listSearchResultByKeyWord(String keyWord);

    /**
     * 根据关键词或者分类ID查找商品信息列表
     * @param keyWord 关键词
     * @param cId 分类ID
     * @param pageNum 分页索引
     * @param limit 每页显示数量
     * @return
     */
    public ResultVo listProductByCIdOrKeyWord(String keyWord,Integer cId,int pageNum,int limit);

    /**
     * 自动补全
     * @param prefix 搜索关键词
     * @param limit 显示个数
     * @return 如果查找成功返回ResultVo对象
     */
    public ResultVo autoCompletion(String prefix,int limit);


}
