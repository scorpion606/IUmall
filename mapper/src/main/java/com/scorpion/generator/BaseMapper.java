package com.scorpion.generator;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author scorpion
 * @date 2021/10/21
 */
public interface BaseMapper<T>extends Mapper<T>, MySqlMapper<T> {
}
