package com.scorpion.mapper;

import com.scorpion.entity.Category;
import com.scorpion.entity.CategoryVo;
import com.scorpion.generator.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface CategoryMapper extends BaseMapper<Category> {
    /**
     * 实现通过连接查询查找商品分类信息
     * @return 如果查找成功返回以CategoryVo为对象的List集合
     */
    public List<CategoryVo> listCategory();

    /**
     * 实现通过子查询查找商品分类信息
     * @param parentID 父级ID
     * @return 如果查找成功返回以CategoryVo为对象的List集合
     */
    public List<CategoryVo> listCategory2(int parentID);

    /**
     * 实现查询一级分类下的销量前十的商品
     * @return 如果查找成功以CategoryVo对象返回List集合
     */
    public List<CategoryVo> selectFirstLevelCategories();


    /**
     * 实现切换分类查询
     * @return 如果查找成功以CategoryVo对象返回List集合
     */
    public List<CategoryVo> selectSwitchNavigation();

    /**
     * 实现查询楼层分类信息
     * @return
     */
    public List<CategoryVo> selectFloorCategory();

    /**
     * 子查询三级分类信息
     * @param categoryId 分类ID
     * @return 如果查找成功以Category对象返回List集合
     */
    public List<Category> selectThirdLevelCategory(int categoryId);

}