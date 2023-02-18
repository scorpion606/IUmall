package com.scorpion.entity;

import javax.persistence.*;

@Table(name = "pms_attr")
public class PmsAttr {
    /**
     * 属性id
     */
    @Id
    @Column(name = "attr_id")
    private Long attrId;

    /**
     * 属性名
     */
    @Column(name = "attr_name")
    private String attrName;

    /**
     * 是否需要检索[0-不需要，1-需要]
     */
    @Column(name = "search_type")
    private Byte searchType;

    /**
     * 值类型[0-为单个值，1-可以选择多个值]
     */
    @Column(name = "value_type")
    private Byte valueType;

    /**
     * 属性图标
     */
    private String icon;

    /**
     * 可选值列表[用逗号分隔]
     */
    @Column(name = "value_select")
    private String valueSelect;

    /**
     * 属性类型[0-销售属性，1-基本属性
     */
    @Column(name = "attr_type")
    private Byte attrType;

    /**
     * 启用状态[0 - 禁用，1 - 启用]
     */
    private Long enable;

    /**
     * 所属分类
     */
    @Column(name = "catelog_id")
    private Long catelogId;

    /**
     * 快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整
     */
    @Column(name = "show_desc")
    private Byte showDesc;

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
     * 获取是否需要检索[0-不需要，1-需要]
     *
     * @return search_type - 是否需要检索[0-不需要，1-需要]
     */
    public Byte getSearchType() {
        return searchType;
    }

    /**
     * 设置是否需要检索[0-不需要，1-需要]
     *
     * @param searchType 是否需要检索[0-不需要，1-需要]
     */
    public void setSearchType(Byte searchType) {
        this.searchType = searchType;
    }

    /**
     * 获取值类型[0-为单个值，1-可以选择多个值]
     *
     * @return value_type - 值类型[0-为单个值，1-可以选择多个值]
     */
    public Byte getValueType() {
        return valueType;
    }

    /**
     * 设置值类型[0-为单个值，1-可以选择多个值]
     *
     * @param valueType 值类型[0-为单个值，1-可以选择多个值]
     */
    public void setValueType(Byte valueType) {
        this.valueType = valueType;
    }

    /**
     * 获取属性图标
     *
     * @return icon - 属性图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置属性图标
     *
     * @param icon 属性图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 获取可选值列表[用逗号分隔]
     *
     * @return value_select - 可选值列表[用逗号分隔]
     */
    public String getValueSelect() {
        return valueSelect;
    }

    /**
     * 设置可选值列表[用逗号分隔]
     *
     * @param valueSelect 可选值列表[用逗号分隔]
     */
    public void setValueSelect(String valueSelect) {
        this.valueSelect = valueSelect == null ? null : valueSelect.trim();
    }

    /**
     * 获取属性类型[0-销售属性，1-基本属性
     *
     * @return attr_type - 属性类型[0-销售属性，1-基本属性
     */
    public Byte getAttrType() {
        return attrType;
    }

    /**
     * 设置属性类型[0-销售属性，1-基本属性
     *
     * @param attrType 属性类型[0-销售属性，1-基本属性
     */
    public void setAttrType(Byte attrType) {
        this.attrType = attrType;
    }

    /**
     * 获取启用状态[0 - 禁用，1 - 启用]
     *
     * @return enable - 启用状态[0 - 禁用，1 - 启用]
     */
    public Long getEnable() {
        return enable;
    }

    /**
     * 设置启用状态[0 - 禁用，1 - 启用]
     *
     * @param enable 启用状态[0 - 禁用，1 - 启用]
     */
    public void setEnable(Long enable) {
        this.enable = enable;
    }

    /**
     * 获取所属分类
     *
     * @return catelog_id - 所属分类
     */
    public Long getCatelogId() {
        return catelogId;
    }

    /**
     * 设置所属分类
     *
     * @param catelogId 所属分类
     */
    public void setCatelogId(Long catelogId) {
        this.catelogId = catelogId;
    }

    /**
     * 获取快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整
     *
     * @return show_desc - 快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整
     */
    public Byte getShowDesc() {
        return showDesc;
    }

    /**
     * 设置快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整
     *
     * @param showDesc 快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整
     */
    public void setShowDesc(Byte showDesc) {
        this.showDesc = showDesc;
    }
}