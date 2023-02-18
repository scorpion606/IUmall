package com.scorpion.service.impl;

import com.scorpion.entity.IuNavigationProductRelation;
import com.scorpion.entity.IuNavigationProductRelationVO;
import com.scorpion.entity.ProductSkuVo;
import com.scorpion.mapper.IuNavigationProductRelationMapper;
import com.scorpion.service.IuNavigationToProductService;
import com.scorpion.vo.PageHelper;
import com.scorpion.vo.ResponseStatus;
import com.scorpion.vo.ResultVo;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author scorpion
 * @date 2022/6/19
 */
@Service
public class IuNavigationToProductServiceImpl implements IuNavigationToProductService {
    @Resource
    private IuNavigationProductRelationMapper iuNavigationProductRelationMapper;

    @Override
    public ResultVo listNavigationToProduct(int navigationId,int pageNum,int limit) {
        Example example = new Example(IuNavigationProductRelation.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("navigationId",navigationId);
        int count = iuNavigationProductRelationMapper.selectCountByExample(example);
        int pageCount=count%limit==0?count/limit:count/limit+1;
        int start=(pageNum-1)*limit;
        List<IuNavigationProductRelationVO> iuNavigationProductRelationVOS = iuNavigationProductRelationMapper.selectNavigationToProductVo(navigationId,start,limit);
        return new ResultVo(ResponseStatus.success,"list success",new PageHelper<>(count,pageCount,iuNavigationProductRelationVOS));
    }
}
