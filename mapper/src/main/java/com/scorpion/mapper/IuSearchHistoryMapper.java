package com.scorpion.mapper;

import com.scorpion.entity.IuSearchHistory;
import com.scorpion.generator.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface IuSearchHistoryMapper extends BaseMapper<IuSearchHistory> {
    public List<IuSearchHistory> selectSearchHistoryByUserId(int userId);

    public int updateDeletedStatus(@Param("userId") int userId,@Param("keyword") String keyword,@Param("status") int status);

    public int updateDeletedAllStatus(@Param("userId") int userId,@Param("status") int status);
}