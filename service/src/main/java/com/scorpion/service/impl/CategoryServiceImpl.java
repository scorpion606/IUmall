package com.scorpion.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scorpion.entity.Category;
import com.scorpion.entity.CategoryVo;
import com.scorpion.entity.Product;
import com.scorpion.entity.ProductVo;
import com.scorpion.mapper.CategoryMapper;
import com.scorpion.mapper.ProductMapper;
import com.scorpion.service.CategoryService;
import com.scorpion.vo.Page;
import com.scorpion.vo.ResponseStatus;
import com.scorpion.vo.ResultVo;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author scorpion
 * @date 2021/11/8
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private ProductMapper productMapper;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    private ObjectMapper objectMapper=new ObjectMapper();
    @Override
    public ResultVo listCategory() {
        List<CategoryVo> categoryVos = categoryMapper.listCategory();
        if(categoryVos.size()==0){
            return new ResultVo(ResponseStatus.fail,"fail",null);
        }else{
            return new ResultVo(ResponseStatus.success,"success",categoryVos);
        }
    }

    @Override
    public ResultVo listCategoryChildren() {
        /**
         * 1    商品分类信息子查询功能
         */
        List<CategoryVo> categoryVos=null;
        try {
            //  从redis中查询分类信息
            String categoriesJson = stringRedisTemplate.opsForValue().get("categories");
            if(categoriesJson!=null){
                //  如果从redis中查找到数据，返回数据
                JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, CategoryVo.class);
                categoryVos = objectMapper.readValue(categoriesJson,javaType);
            }else{
                //  双重检测锁解决缓存击穿
                synchronized (this){
                    String Json = stringRedisTemplate.opsForValue().get("categories");
                    if(Json==null){
                        //  如果从redis没有查找到数据，则从数据库中查找数据，并存入redis中
                        categoryVos = categoryMapper.listCategory2(0);

                        //  通过判断从数据是否查到数据的不同解决方式解决缓存穿透
                        if(categoryVos!=null){
                            stringRedisTemplate.opsForValue().set("categories", objectMapper.writeValueAsString(categoryVos),1, TimeUnit.DAYS);
                        }else{
                            stringRedisTemplate.opsForValue().set("categories", objectMapper.writeValueAsString("[]"),10, TimeUnit.SECONDS);
                        }

                    }else{
                        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, CategoryVo.class);
                        categoryVos = objectMapper.readValue(Json,javaType);

                    }
                }

            }
        }catch (JsonProcessingException e){

            e.printStackTrace();
        }
        return new ResultVo(ResponseStatus.success,"list success",categoryVos);
    }

    @Override
    public ResultVo listFirstLevelCategories() {
        List<CategoryVo> categoryVos=categoryMapper.selectFirstLevelCategories();
        if(categoryVos.size()==0){
            return new ResultVo(ResponseStatus.fail,"fail",null);
        }else{
            return new ResultVo(ResponseStatus.success,"success",categoryVos);
        }
    }



    @Override
    public ResultVo listSwitchCategoryProduct(int pageNum,int limit) {
      /* List<CategoryVo> categoryVos = categoryMapper.selectSwitchNavigation();
        return new ResultVo(ResponseStatus.success,"success",categoryVos);*/
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("categoryStyle",2)
                .andEqualTo("categoryStatus",1);
        example.setOrderByClause(" category_seq ASC");

        List<Category> categories = categoryMapper.selectByExample(example);
        Map<Integer,Object> map=new HashMap();

        int start=(pageNum-1)*limit;
        int count;
        int pageCount;
        for (int i = 0; i < categories.size(); i++) {
            Example example1 = new Example(Product.class);
            Example.Criteria criteria1 = example1.createCriteria();
            criteria1.andEqualTo("navId",categories.get(i).getCategoryId());
            count = productMapper.selectCountByExample(example1);
            pageCount=count%limit==0?count/limit:count/limit+1;
            List<ProductVo> productVos = productMapper.selectSwitchProduct(categories.get(i).getCategoryId(), start, limit);
            CategoryVo categoryVo = new CategoryVo();
            categoryVo.setProducts(productVos);
            categoryVo.setCategoryId(categories.get(i).getCategoryId());
            categoryVo.setCategoryName(categories.get(i).getCategoryName());
            categoryVo.setCategorySlogan(categories.get(i).getCategorySlogan());
            map.put(i,new Page<>(count,pageCount,categoryVo));
        }
        return new ResultVo(ResponseStatus.success,"list success",map);
    }

    @Override
    public ResultVo listFloorCategory() {
        List<CategoryVo> categoryVos = categoryMapper.selectFloorCategory();
        return new ResultVo(ResponseStatus.success,"success",categoryVos);
    }
}
