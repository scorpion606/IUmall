package com.scorpion.mapper;

import com.scorpion.entity.PmsSkuImages;
import com.scorpion.generator.BaseMapper;

import java.util.List;

public interface PmsSkuImagesMapper extends BaseMapper<PmsSkuImages> {
    public List<PmsSkuImages> selectSkuImages(int skuId);
}