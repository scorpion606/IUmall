package com.scorpion.mapper;

import com.scorpion.entity.IuFeedBack;
import com.scorpion.generator.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IuFeedBackMapper extends BaseMapper<IuFeedBack> {
    public List<IuFeedBack> selectIuFeedBack(@Param("userId") int userId,
                                             @Param("start") int start,
                                             @Param("limit") int limit);
}