package com.scorpion.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Product implements Serializable {
    public Product() {
    }

    public Product(Integer productId, Integer categoryId, Integer rootCategoryId, Integer navId, Integer tabId, String productName, String shareUrl, String productUnit, Integer soldNum, Integer productStatus, Integer approveStatus, String approveContent, String keyWord, Integer revision, String createdBy, Date createdTime, String updatedBy, Date updatedTime, String productContent) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.rootCategoryId = rootCategoryId;
        this.navId = navId;
        this.tabId = tabId;
        this.productName = productName;
        this.shareUrl = shareUrl;
        this.productUnit = productUnit;
        this.soldNum = soldNum;
        this.productStatus = productStatus;
        this.approveStatus = approveStatus;
        this.approveContent = approveContent;
        this.keyWord = keyWord;
        this.revision = revision;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
        this.updatedBy = updatedBy;
        this.updatedTime = updatedTime;
        this.productContent = productContent;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", categoryId=" + categoryId +
                ", rootCategoryId=" + rootCategoryId +
                ", navId=" + navId +
                ", tabId=" + tabId +
                ", productName='" + productName + '\'' +
                ", shareUrl='" + shareUrl + '\'' +
                ", productUnit='" + productUnit + '\'' +
                ", soldNum=" + soldNum +
                ", productStatus=" + productStatus +
                ", approveStatus=" + approveStatus +
                ", approveContent='" + approveContent + '\'' +
                ", keyWord='" + keyWord + '\'' +
                ", revision=" + revision +
                ", createdBy='" + createdBy + '\'' +
                ", createdTime=" + createdTime +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedTime=" + updatedTime +
                ", productContent='" + productContent + '\'' +
                '}';
    }

    /**
     * 商品主键ID
     */
    @Id
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 分类外键ID
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 一级分类外键ID
     */
    @Column(name = "root_category_id")
    private Integer rootCategoryId;

    /**
     * 商品所属首页分类ID
     */
    @Column(name="nav_id")
    private Integer navId;

    /**
     * 标签外键
     */
    @Column(name = "tab_id")
    private Integer tabId;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    @Column(name = "share_url")
    private String shareUrl;

    @Column(name = "product_unit")
    private String productUnit;

    /**
     * 销量
     */
    @Column(name = "sold_num")
    private Integer soldNum;

    /**
     * 状态，默认是1，表示正常状态，-1表示删除，0表示下架
     */
    @Column(name = "product_status")
    private Integer productStatus;

    @Column(name = "approve_status")
    private Integer approveStatus;

    @Column(name="approve_content")
    private String approveContent;

    @Column(name = "key_word")
    private String keyWord;
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

    /**
     * 商品内容
     */
    @Column(name = "product_content")
    private String productContent;

    /**
     * 获取商品主键ID
     *
     * @return product_id - 商品主键ID
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置商品主键ID
     *
     * @param productId 商品主键ID
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取分类外键ID
     *
     * @return category_id - 分类外键ID
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置分类外键ID
     *
     * @param categoryId 分类外键ID
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取一级分类外键ID
     *
     * @return root_category_id - 一级分类外键ID
     */
    public Integer getRootCategoryId() {
        return rootCategoryId;
    }

    /**
     * 设置一级分类外键ID
     *
     * @param rootCategoryId 一级分类外键ID
     */
    public void setRootCategoryId(Integer rootCategoryId) {
        this.rootCategoryId = rootCategoryId;
    }

    public Integer getNavId() {
        return navId;
    }

    public void setNavId(Integer navId) {
        this.navId = navId;
    }

    public Integer getTabId() {
        return tabId;
    }

    public void setTabId(Integer tabId) {
        this.tabId = tabId;
    }

    /**
     * 获取商品名称
     *
     * @return product_name - 商品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置商品名称
     *
     * @param productName 商品名称
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public Integer getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(Integer approveStatus) {
        this.approveStatus = approveStatus;
    }

    public String getApproveContent() {
        return approveContent;
    }

    public void setApproveContent(String approveContent) {
        this.approveContent = approveContent;
    }

    /**
     * 获取销量
     *
     * @return sold_num - 销量
     */
    public Integer getSoldNum() {
        return soldNum;
    }

    /**
     * 设置销量
     *
     * @param soldNum 销量
     */
    public void setSoldNum(Integer soldNum) {
        this.soldNum = soldNum;
    }

    /**
     * 获取状态，默认是1，表示正常状态，-1表示删除，0表示下架
     *
     * @return product_status - 状态，默认是1，表示正常状态，-1表示删除，0表示下架
     */
    public Integer getProductStatus() {
        return productStatus;
    }

    /**
     * 设置状态，默认是1，表示正常状态，-1表示删除，0表示下架
     *
     * @param productStatus 状态，默认是1，表示正常状态，-1表示删除，0表示下架
     */
    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    /**
     * 获取乐观锁
     *
     * @return REVISION - 乐观锁
     */
    public Integer getRevision() {
        return revision;
    }

    /**
     * 设置乐观锁
     *
     * @param revision 乐观锁
     */
    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    /**
     * 获取创建人
     *
     * @return CREATED_BY - 创建人
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置创建人
     *
     * @param createdBy 创建人
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    /**
     * 获取创建时间
     *
     * @return CREATED_TIME - 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建时间
     *
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取更新人
     *
     * @return UPDATED_BY - 更新人
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置更新人
     *
     * @param updatedBy 更新人
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    /**
     * 获取更新时间
     *
     * @return UPDATED_TIME - 更新时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置更新时间
     *
     * @param updatedTime 更新时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * 获取商品内容
     *
     * @return product_content - 商品内容
     */
    public String getProductContent() {
        return productContent;
    }

    /**
     * 设置商品内容
     *
     * @param productContent 商品内容
     */
    public void setProductContent(String productContent) {
        this.productContent = productContent == null ? null : productContent.trim();
    }
}