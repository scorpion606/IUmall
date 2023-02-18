package com.scorpion.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "iu_navigation_product_relation")
public class IuNavigationProductRelationVO implements Serializable {
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

    private List<Product> products;
    /**
     * 商品图片
     */
    private List<ProductImg> productImgs;

    /**
     * 商品套餐
     */
    private List<ProductSkuVo> productSkus;

}