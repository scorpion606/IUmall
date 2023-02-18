package com.scorpion.service.impl;

import com.scorpion.entity.Dynamic;
import com.scorpion.entity.DynamicVo;
import com.scorpion.mapper.DynamicMapper;
import com.scorpion.service.DynamicService;
import com.scorpion.vo.Page;
import com.scorpion.vo.ResponseStatus;
import com.scorpion.vo.ResultVo;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author scorpion
 * @date 2022/10/16
 */
@Service
public class DynamicServiceImpl implements DynamicService {

    @Resource
    private DynamicMapper dynamicMapper;

    /**
     * 1，计算start start=(pageNum-1)*limit
     * 2，通过start和limit分页获取动态列表
     * 3，计算count动态总数量
     * 4，计算pageCount 页数：pageCount=count%limit==0?count/limit:count/limit+1
     * 5，返回pageVo对象
     * @param pageNum 初始索引
     * @param limit 每页显示数量
     * @return
     */
    @Override
    public ResultVo listDynamic(int pageNum, int limit) {
        int start=(pageNum-1)*limit;
        List<DynamicVo> dynamicVos = dynamicMapper.selectListDynamic(start, limit);
        Example example = new Example(Dynamic.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("deleted",0);
        int count = dynamicMapper.selectCountByExample(example);
        int pageCount=count%limit==0?count/limit:count/limit+1;
        return new ResultVo(ResponseStatus.success,"list success",new Page<>(count,pageCount,dynamicVos));
    }
}
