package com.scorpion.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "product_params")
public class ProductParams implements Serializable {

    public ProductParams() {
    }

    public ProductParams(Integer paramsId, Integer productId, String brand, String description, String genericSpec, String specialSpec, String packingList, String afterService, String paramsImg, Integer revision, String createdBy, Date createdTime, String updatedBy, Date updatedTime) {
        this.paramsId = paramsId;
        this.productId = productId;
        this.brand = brand;
        this.description = description;
        this.genericSpec = genericSpec;
        this.specialSpec = specialSpec;
        this.packingList = packingList;
        this.afterService = afterService;
        this.paramsImg = paramsImg;
        this.revision = revision;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
        this.updatedBy = updatedBy;
        this.updatedTime = updatedTime;
    }

    /**
     * 商品参数主键ID
     */
    @Id
    @Column(name = "params_id")
    private Integer paramsId;

    /**
     * 商品外键ID
     */
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "brand")
    private String brand;

    /**
     * 商品描述信息
     */
    @Column(name = "description")
    private String description;


    /**
     * 通用规格键值对 (json格式)
     */
    @Column(name = "generic_spec")
    private String genericSpec;



    /**
     * 特有规格可选值 (json格式)
     */
    @Column(name = "special_spec")
    private String specialSpec;



    /**
     * 包装清单
     */
    @Column(name = "packing_list")
    private String packingList;

    /**
     * 售后服务
     */
    @Column(name = "after_service")
    private String afterService;



    /**
     * 商品参数图片
     */
    @Column(name = "params_img")
    private String paramsImg;
    /**
     * 乐观锁
     */
    @Column(name = "REVISION")
    private Integer revision;

    /**
     * 创建人
     */
    @Column(name = "CREATED_BY")
    private String createdBy;

    /**
     * 创建时间
     */
    @Column(name = "CREATED_TIME")
    private Date createdTime;

    /**
     * 更新人
     */
    @Column(name = "UPDATED_BY")
    private String updatedBy;

    /**
     * 更新时间
     */
    @Column(name = "UPDATED_TIME")
    private Date updatedTime;

    public Integer getParamsId() {
        return paramsId;
    }

    public void setParamsId(Integer paramsId) {
        this.paramsId = paramsId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenericSpec() {
        return genericSpec;
    }

    public void setGenericSpec(String genericSpec) {
        this.genericSpec = genericSpec;
    }

    public String getSpecialSpec() {
        return specialSpec;
    }

    public void setSpecialSpec(String specialSpec) {
        this.specialSpec = specialSpec;
    }

    public String getPackingList() {
        return packingList;
    }

    public void setPackingList(String packingList) {
        this.packingList = packingList;
    }

    public String getAfterService() {
        return afterService;
    }

    public void setAfterService(String afterService) {
        this.afterService = afterService;
    }

    public Integer getRevision() {
        return revision;
    } public String getParamsImg() {
        return paramsImg;
    }

    public void setParamsImg(String paramsImg) {
        this.paramsImg = paramsImg;
    }


    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "ProductParams{" +
                "paramsId=" + paramsId +
                ", productId=" + productId +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", genericSpec='" + genericSpec + '\'' +
                ", specialSpec='" + specialSpec + '\'' +
                ", packingList='" + packingList + '\'' +
                ", afterService='" + afterService + '\'' +
                ", paramsImg='" + paramsImg + '\'' +
                ", revision=" + revision +
                ", createdBy='" + createdBy + '\'' +
                ", createdTime=" + createdTime +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedTime=" + updatedTime +
                '}';
    }
}