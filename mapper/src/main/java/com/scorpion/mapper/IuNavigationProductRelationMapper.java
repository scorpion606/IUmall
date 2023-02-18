package com.scorpion.mapper;

import com.scorpion.entity.IuNavigationProductRelation;
import com.scorpion.entity.IuNavigationProductRelationVO;
import com.scorpion.generator.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface IuNavigationProductRelationMapper extends BaseMapper<IuNavigationProductRelation> {
    public List<IuNavigationProductRelationVO> selectNavigationToProductVo(@Param("navigationId") int navigationId,
                                                                           @Param("start") int start,
                                                                           @Param("limit") int limit);
}