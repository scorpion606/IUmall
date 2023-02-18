package com.scorpion.mapper;

import com.scorpion.entity.ProductVo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author scorpion
 * @date 2021/11/13
 */
@SpringBootTest
public class ProductMapperTest {
    @Resource
    private ProductMapper productMapper;
    @Test
    public void selectProductions(){
        List<ProductVo> productVos = productMapper.selectRecommendProductions();
        for (ProductVo p:productVos) {
            System.out.println(p);
        }

    }
}
