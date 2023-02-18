package com.scorpion.entity;

import javax.persistence.*;

@Table(name = "pms_sku_sale_attr_value")
public class PmsSkuSaleAttrValue {
    /**
     * id
     */
    @Id
    private Long id;

    /**
     * sku_id
     */
    @Column(name = "sku_id")
    private Long skuId;

    /**
     * attr_id
     */
    @Column(name = "attr_id")
    private Long attrId;

    /**
     * 销售属性名
     */
    @Column(name = "attr_name")
    private String attrName;

    /**
     * 销售属性值
     */
    @Column(name = "attr_value")
    private String attrValue;

    /**
     * 顺序
     */
    @Column(name = "attr_sort")
    private Integer attrSort;

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
     * 获取sku_id
     *
     * @return sku_id - sku_id
     */
    public Long getSkuId() {
        return skuId;
    }

    /**
     * 设置sku_id
     *
     * @param skuId sku_id
     */
    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    /**
     * 获取attr_id
     *
     * @return attr_id - attr_id
     */
    public Long getAttrId() {
        return attrId;
    }

    /**
     * 设置attr_id
     *
     * @param attrId attr_id
     */
    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    /**
     * 获取销售属性名
     *
     * @return attr_name - 销售属性名
     */
    public String getAttrName() {
        return attrName;
    }

    /**
     * 设置销售属性名
     *
     * @param attrName 销售属性名
     */
    public void setAttrName(String attrName) {
        this.attrName = attrName == null ? null : attrName.trim();
    }

    /**
     * 获取销售属性值
     *
     * @return attr_value - 销售属性值
     */
    public String getAttrValue() {
        return attrValue;
    }

    /**
     * 设置销售属性值
     *
     * @param attrValue 销售属性值
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
}