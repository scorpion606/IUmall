package com.scorpion.mapper;

import com.scorpion.entity.DtsRegion;
import com.scorpion.entity.DtsRegionVO;
import com.scorpion.generator.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface DtsRegionMapper extends BaseMapper<DtsRegion> {

    /**
     * 查找一级、二级、三级行政区域
     * @return
     */
    public List<DtsRegionVO> selectDtsRegion();
}