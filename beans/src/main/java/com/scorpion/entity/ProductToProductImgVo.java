package com.scorpion.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * @author scorpion
 * @date 2022/7/1
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class ProductToProductImgVo {
    /**
     * 商品主键ID
     */

    private Integer productId;

    /**
     * 分类外键ID
     */

    private Integer categoryId;

    /**
     * 一级分类外键ID
     */

    private Integer rootCategoryId;

    /**
     * 商品所属首页分类ID
     */

    private Integer navId;
    private Integer tabId;

    /**
     * 商品名称
     */

    private String productName;


    private String shareUrl;


    private String productUnit;


    private Integer approveStatus;


    private String approveContent;

    /**
     * 销量
     */

    private Integer soldNum;

    /**
     * 状态，默认是1，表示正常状态，-1表示删除，0表示下架
     */

    private Integer productStatus;


    private String keyWord;

    /**
     * 乐观锁
     */

    private Integer revision;

    /**
     * 创建人
     */

    private String createdBy;

    /**
     * 创建时间
     */

    private Date createdTime;

    /**
     * 更新人
     */

    private String updatedBy;

    /**
     * 更新时间
     */

    private Date updatedTime;

    /**
     * 商品内容
     */

    private String productContent;
    /**
     * 商品图片
     */
    private List<ProductImg> productImgs;
}
