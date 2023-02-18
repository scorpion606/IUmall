package com.scorpion.mapper;

import com.scorpion.ApiApplication;
import com.scorpion.entity.CategoryVo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author scorpion
 * @date 2021/11/8
 */
@SpringBootTest(classes = ApiApplication.class)
public class CategoryMapperTest {
    @Resource
    private CategoryMapper categoryMapper;

    /**
     * 测试连接查询查找商品分类信息
     */
    @Test
    public void listCategoryTest() {
        List<CategoryVo> categories = categoryMapper.listCategory();
        for (CategoryVo c1 : categories) {
            System.out.println(c1);
            for (CategoryVo c2 : c1.getCategories()) {
                System.out.println("\t"+c2);
                for (CategoryVo c3 : c2.getCategories()) {
                    System.out.println("\t\t"+c3);
                }
            }
        }
    }
    /**
     * 测试子查询查找商品分类信息
     */
    @Test
    public void listCategory2Test() {
        List<CategoryVo> categories = categoryMapper.listCategory2(0);
        for (CategoryVo c1 : categories) {
            System.out.println(c1);
            for (CategoryVo c2 : c1.getCategories()) {
                System.out.println("\t"+c2);
                for (CategoryVo c3 : c2.getCategories()) {
                    System.out.println("\t\t"+c3);
                }
            }
        }
    }
    @Test
    public void selectFirstLevelCategories(){
        List<CategoryVo> categoryVos= categoryMapper.selectFirstLevelCategories();
        for (CategoryVo c:categoryVos) {
            System.out.println(c);
        }
    }
}
