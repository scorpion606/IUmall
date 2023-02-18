package com.scorpion.entity;

import javax.persistence.*;

@Table(name = "iu_navigation_product_relation")
public class IuNavigationProductRelation {
    /**
     * 主键id
     */
    @Id
    private Integer id;

    /**
     * 首页导航分类外键id
     */
    @Column(name = "navigation_id")
    private Integer navigationId;

    /**
     * 商品分类外键id
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取首页导航分类外键id
     *
     * @return navigation_id - 首页导航分类外键id
     */
    public Integer getNavigationId() {
        return navigationId;
    }

    /**
     * 设置首页导航分类外键id
     *
     * @param navigationId 首页导航分类外键id
     */
    public void setNavigationId(Integer navigationId) {
        this.navigationId = navigationId;
    }

    /**
     * 获取商品分类外键id
     *
     * @return product_id - 商品分类外键id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置商品分类外键id
     *
     * @param productId 商品分类外键id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}