package com.scorpion.entity;

import javax.persistence.*;

@Table(name = "pms_attr_attrgroup_relation")
public class PmsAttrAttrgroupRelation {
    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 属性id
     */
    @Column(name = "attr_id")
    private Long attrId;

    /**
     * 属性分组id
     */
    @Column(name = "attr_group_id")
    private Long attrGroupId;

    /**
     * 属性组内排序
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
     * 获取属性分组id
     *
     * @return attr_group_id - 属性分组id
     */
    public Long getAttrGroupId() {
        return attrGroupId;
    }

    /**
     * 设置属性分组id
     *
     * @param attrGroupId 属性分组id
     */
    public void setAttrGroupId(Long attrGroupId) {
        this.attrGroupId = attrGroupId;
    }

    /**
     * 获取属性组内排序
     *
     * @return attr_sort - 属性组内排序
     */
    public Integer getAttrSort() {
        return attrSort;
    }

    /**
     * 设置属性组内排序
     *
     * @param attrSort 属性组内排序
     */
    public void setAttrSort(Integer attrSort) {
        this.attrSort = attrSort;
    }
}