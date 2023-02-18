package com.scorpion.entity;

import javax.persistence.*;

@Table(name = "pms_product_attr_value")
public class PmsProductAttrValue {
    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 商品id
     */
    @Column(name = "spu_id")
    private Long spuId;

    /**
     * 属性id
     */
    @Column(name = "attr_id")
    private Long attrId;

    /**
     * 属性名
     */
    @Column(name = "attr_name")
    private String attrName;

    /**
     * 属性值
     */
    @Column(name = "attr_value")
    private String attrValue;

    /**
     * 顺序
     */
    @Column(name = "attr_sort")
    private Integer attrSort;

    /**
     * 快速展示【是否展示在介绍上；0-否 1-是】
     */
    @Column(name = "quick_show")
    private Byte quickShow;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取商品id
     *
     * @return spu_id - 商品id
     */
    public Long getSpuId() {
        return spuId;
    }

    /**
     * 设置商品id
     *
     * @param spuId 商品id
     */
    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    /**
     * 获取属性id
     *
     * @return attr_id - 属性id
     */
    public Long getAttrId() {
        return attrId;
    }

    /**
     * 设置属性id
     *
     * @param attrId 属性id
     */
    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    /**
     * 获取属性名
     *
     * @return attr_name - 属性名
     */
    public String getAttrName() {
        return attrName;
    }

    /**
     * 设置属性名
     *
     * @param attrName 属性名
     */
    public void setAttrName(String attrName) {
        this.attrName = attrName == null ? null : attrName.trim();
    }

    /**
     * 获取属性值
     *
     * @return attr_value - 属性值
     */
    public String getAttrValue() {
        return attrValue;
    }

    /**
     * 设置属性值
     *
     * @param attrValue 属性值
     */
    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue == null ? null : attrValue.trim();
    }

    /**
     * 获取顺序
     *
     * @return attr_sort - 顺序
     */
    public Integer getAttrSort() {
        return attrSort;
    }

    /**
     * 设置顺序
     *
     * @param attrSort 顺序
     */
    public void setAttrSort(Integer attrSort) {
        this.attrSort = attrSort;
    }

    /**
     * 获取快速展示【是否展示在介绍上；0-否 1-是】
     *
     * @return quick_show - 快速展示【是否展示在介绍上；0-否 1-是】
     */
    public Byte getQuickShow() {
        return quickShow;
    }

    /**
     * 设置快速展示【是否展示在介绍上；0-否 1-是】
     *
     * @param quickShow 快速展示【是否展示在介绍上；0-否 1-是】
     */
    public void setQuickShow(Byte quickShow) {
        this.quickShow = quickShow;
    }
}