package com.scorpion.mapper;

import com.scorpion.entity.UserAddress;
import com.scorpion.generator.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


public interface UserAddressMapper extends BaseMapper<UserAddress> {
    public int updateStatusByAId(@Param("aId") int aId,@Param("status") int status);
}