package com.scorpion.service.impl;

import com.scorpion.entity.ProductCommonts;
import com.scorpion.entity.ProductCommontsVo;
import com.scorpion.mapper.ProductCommontsMapper;
import com.scorpion.service.ProductCommontsService;
import com.scorpion.vo.PageHelper;
import com.scorpion.vo.ResponseStatus;
import com.scorpion.vo.ResultVo;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author scorpion
 * @date 2021/11/20
 */
@Service
public class ProductCommontsServiceImpl implements ProductCommontsService {
    @Resource
    private ProductCommontsMapper ProductCommontsMapper;
    @Override
    public ResultVo listProductCommonts(int ProductId,int pageNum,int limit) {
        //根据productId查询总记录数
        Example example=new Example(ProductCommonts.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productId", ProductId);
        int count = ProductCommontsMapper.selectCountByExample(example);
        //根据总记录数计算总页数，需要前端或者后端确定每页显示多少条数据
        int pageCount=count%limit==0?count/limit:count/limit+1;
        //查找分页商品评论信息,start表示每页分页开始的索引
        int start=(pageNum-1)*limit;
        List<ProductCommontsVo> list = ProductCommontsMapper.selectProductCommontsByProductId(ProductId, start, limit);
        return new ResultVo(ResponseStatus.success,"success",new PageHelper<ProductCommontsVo>(count,pageCount,list));

    }

    @Override
    public ResultVo listProductCount(int ProductId) {
        //统计商品总评价数
        Example example=new Example(ProductCommonts.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productId",ProductId);
        int count = ProductCommontsMapper.selectCountByExample(example);
        //统计商品好评数
        criteria.andEqualTo("commentType",0);
        int height = ProductCommontsMapper.selectCountByExample(example);
        //统计商品中评数
        Example example2=new Example(ProductCommonts.class);
        Example.Criteria criteria2 = example2.createCriteria();
        criteria2.andEqualTo("productId",ProductId);
        criteria2.andEqualTo("commentType",1);
        int middle = ProductCommontsMapper.selectCountByExample(example2);
        //统计商品差评数
        Example example3=new Example(ProductCommonts.class);
        Example.Criteria criteria3 = example3.createCriteria();
        criteria3.andEqualTo("productId",ProductId);
        criteria3.andEqualTo("commentType",-1);
        int low = ProductCommontsMapper.selectCountByExample(example3);
        //计算好评率
        double percent=Double.parseDouble(height+"")/Double.parseDouble(count+"")*100;
        String percentValue=(percent+"").substring(0,(percent+"").lastIndexOf(".")+2);

        //将统计数据存储到HashMap集合
        Map<String,Object> map=new HashMap<>();
        map.put("total",count);
        map.put("heightTotal",height);
        map.put("midTotal",middle);
        map.put("lowTotal",low);
        map.put("percent",percentValue);
        return new ResultVo(ResponseStatus.success,"success",map);
    }
}
