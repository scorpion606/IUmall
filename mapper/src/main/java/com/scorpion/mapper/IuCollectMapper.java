package com.scorpion.mapper;

import com.scorpion.entity.IuCollect;
import com.scorpion.generator.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IuCollectMapper extends BaseMapper<IuCollect> {

    public List<IuCollect> selectCollect(int id);

    public int updateStatus(@Param("userId") int userId,@Param("valueId") int valueId,@Param("status") Boolean status);
}