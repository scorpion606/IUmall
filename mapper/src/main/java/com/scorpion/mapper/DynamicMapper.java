package com.scorpion.mapper;

import com.scorpion.entity.Dynamic;
import com.scorpion.entity.DynamicVo;
import com.scorpion.generator.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicMapper extends BaseMapper<Dynamic> {

    List<DynamicVo> selectListDynamic(@Param("start") int start,@Param("limit") int limit);
}