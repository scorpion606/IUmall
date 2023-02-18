package com.scorpion.mapper;

import com.scorpion.entity.IuFootPrint;
import com.scorpion.entity.IuFootPrintVo;
import com.scorpion.generator.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface IuFootPrintMapper extends BaseMapper<IuFootPrint> {
   /**
    * 查询30天内的足迹浏览历史
    * @param userId 用户ID
    * @param deleted 逻辑删除状态
    * @return 如果查找成功以List集合返回IuFootPrintVo对象
    */
   public List<IuFootPrintVo> selectFootPrintByUserId(@Param("userId") int userId,@Param("deleted") int deleted);

   /**
    * 查找某一天内的足迹浏览历史
    * @param userId 用户ID
    * @param deleted 逻辑删除状态
    * @param date 日期
    * @return
    */
   public List<IuFootPrintVo> selectLessOneDayFootPrint(@Param("userId") int userId,@Param("deleted") int deleted,@Param("date") String date);

   /**
    * 查找某一天是否有该商品的浏览记录
    * @param userId
    * @param pId
    * @param deleted
    * @param date
    * @return
    */
   public IuFootPrint selectOneDayFootPrintByPid(@Param("userId") int userId,
                                                 @Param("pId") int pId,
                                                 @Param("deleted") int deleted,
                                                 @Param("date") String date);
}