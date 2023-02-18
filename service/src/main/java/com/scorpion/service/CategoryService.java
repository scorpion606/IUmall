package com.scorpion.service;

import com.scorpion.vo.ResultVo;

/**
 * @author scorpion
 * @date 2021/11/8
 */
public interface CategoryService {
    /**
     * 实现查询商品分类信息功能，调用mapper层的ListCategory方法
     * @return 如果查找成功以ResultVo形式返回
     */
    public ResultVo listCategory();

    /**
     * 实现查询商品分类信息功能，调用mapper层的listCategory2方法
     * @return 如果查找成功以ResultVo形式返回
     */
    public ResultVo listCategoryChildren();

    /**
     * 实现查询一级分类下销量前十的商品功能，调用Mapper层的
     * @return 如果查找成功以ResultVo形式返回selectFirstLevelCategories方法
     */
    public ResultVo listFirstLevelCategories();


    /**
     * 实现查找切换分类的商品信息
     * @return
     */
    public ResultVo listSwitchCategoryProduct(int pageNum,int limit);

    /**
     * 实现查找楼层分类信息
     * @return
     */
    public ResultVo listFloorCategory();
}
