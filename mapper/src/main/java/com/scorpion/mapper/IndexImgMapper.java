package com.scorpion.mapper;

import com.scorpion.entity.IndexImg;
import com.scorpion.generator.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface IndexImgMapper extends BaseMapper<IndexImg> {
    /**
     * 根据status查询轮播图信息，顺序按照seq排序
     * @return 以IndexImg对象List集合返回数据
     */
    public List<IndexImg> listIndexImg();
}