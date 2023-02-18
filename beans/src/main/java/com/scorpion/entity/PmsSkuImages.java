package com.scorpion.entity;

import javax.persistence.*;

@Table(name = "pms_sku_images")
public class PmsSkuImages {
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
     * 图片地址
     */
    @Column(name = "img_url")
    private String imgUrl;

    /**
     * 排序
     */
    @Column(name = "img_sort")
    private Integer imgSort;

    /**
     * 默认图[0 - 不是默认图，1 - 是默认图]
     */
    @Column(name = "default_img")
    private Integer defaultImg;

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
     * 获取图片地址
     *
     * @return img_url - 图片地址
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 设置图片地址
     *
     * @param imgUrl 图片地址
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * 获取排序
     *
     * @return img_sort - 排序
     */
    public Integer getImgSort() {
        return imgSort;
    }

    /**
     * 设置排序
     *
     * @param imgSort 排序
     */
    public void setImgSort(Integer imgSort) {
        this.imgSort = imgSort;
    }

    /**
     * 获取默认图[0 - 不是默认图，1 - 是默认图]
     *
     * @return default_img - 默认图[0 - 不是默认图，1 - 是默认图]
     */
    public Integer getDefaultImg() {
        return defaultImg;
    }

    /**
     * 设置默认图[0 - 不是默认图，1 - 是默认图]
     *
     * @param defaultImg 默认图[0 - 不是默认图，1 - 是默认图]
     */
    public void setDefaultImg(Integer defaultImg) {
        this.defaultImg = defaultImg;
    }
}