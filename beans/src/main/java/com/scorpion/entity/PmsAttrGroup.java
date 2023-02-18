package com.scorpion.entity;

import javax.persistence.*;

@Table(name = "pms_attr_group")
public class PmsAttrGroup {
    /**
     * 分组id
     */
    @Id
    @Column(name = "attr_group_id")
    private Long attrGroupId;

    /**
     * 组名
     */
    @Column(name = "attr_group_name")
    private String attrGroupName;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 描述
     */
    private String descript;

    /**
     * 组图标
     */
    private String icon;

    /**
     * 所属分类id
     */
    @Column(name = "catelog_id")
    private Long catelogId;

    /**
     * 获取分组id
     *
     * @return attr_group_id - 分组id
     */
    public Long getAttrGroupId() {
        return attrGroupId;
    }

    /**
     * 设置分组id
     *
     * @param attrGroupId 分组id
     */
    public void setAttrGroupId(Long attrGroupId) {
        this.attrGroupId = attrGroupId;
    }

    /**
     * 获取组名
     *
     * @return attr_group_name - 组名
     */
    public String getAttrGroupName() {
        return attrGroupName;
    }

    /**
     * 设置组名
     *
     * @param attrGroupName 组名
     */
    public void setAttrGroupName(String attrGroupName) {
        this.attrGroupName = attrGroupName == null ? null : attrGroupName.trim();
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取描述
     *
     * @return descript - 描述
     */
    public String getDescript() {
        return descript;
    }

    /**
     * 设置描述
     *
     * @param descript 描述
     */
    public void setDescript(String descript) {
        this.descript = descript == null ? null : descript.trim();
    }

    /**
     * 获取组图标
     *
     * @return icon - 组图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置组图标
     *
     * @param icon 组图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 获取所属分类id
     *
     * @return catelog_id - 所属分类id
     */
    public Long getCatelogId() {
        return catelogId;
    }

    /**
     * 设置所属分类id
     *
     * @param catelogId 所属分类id
     */
    public void setCatelogId(Long catelogId) {
        this.catelogId = catelogId;
    }
}