package com.scorpion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "product_sku")
public class ProductSku implements Serializable {
    public ProductSku() {
    }

    public ProductSku(Integer skuId, Integer productId, String skuName, String skuImg, Integer untilled, BigDecimal originalPrice, BigDecimal sellPrice, BigDecimal discount, Integer stock, Integer status, String oldness, Integer revision, String createdBy, Date createdTime, String updatedBy, Date updatedTime, Date purchasedTime) {
        this.skuId = skuId;
        this.productId = productId;
        this.skuName = skuName;
        this.skuImg = skuImg;
        this.untilled = untilled;
        this.originalPrice = originalPrice;
        this.sellPrice = sellPrice;
        this.discount = discount;
        this.stock = stock;
        this.status = status;
        this.oldness = oldness;
        this.revision = revision;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
        this.updatedBy = updatedBy;
        this.updatedTime = updatedTime;
        this.purchasedTime = purchasedTime;
    }

    @Override
    public String toString() {
        return "ProductSku{" +
                "skuId=" + skuId +
                ", productId=" + productId +
                ", skuName='" + skuName + '\'' +
                ", skuImg='" + skuImg + '\'' +
                ", untilled=" + untilled +
                ", originalPrice=" + originalPrice +
                ", sellPrice=" + sellPrice +
                ", discount=" + discount +
                ", stock=" + stock +
                ", status=" + status +
                ", oldness='" + oldness + '\'' +
                ", revision=" + revision +
                ", createdBy='" + createdBy + '\'' +
                ", createdTime=" + createdTime +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedTime=" + updatedTime +
                ", purchasedTime='" + purchasedTime + '\'' +
                '}';
    }

    /**
     * skuID
     */
    @Id
    @Column(name = "sku_id")
    private Integer skuId;

    /**
     * 商品外键ID
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * sku名称
     */
    @Column(name = "sku_name")
    private String skuName;

    /**
     * sku图片
     */
    @Column(name = "sku_img")
    private String skuImg;

    /**
     * 属性组合(格式k1:v1,k2:v2)
     */
    private Integer untilled;

    /**
     * 原价
     */
    @Column(name = "original_price")
    private BigDecimal originalPrice;

    /**
     * 销售价格
     */
    @Column(name = "sell_price")
    private BigDecimal sellPrice;

    /**
     * 折扣力度
     */
    private BigDecimal discount;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 状态(1启用，0禁用，-1删除)
     */
    private Integer status;

    @Column(name = "oldness")
    private String oldness;

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

    @Column(name = "purchased_time")
    private Date purchasedTime;

    public String getOldness() {
        return oldness;
    }

    public void setOldness(String oldness) {
        this.oldness = oldness;
    }

    public Date getPurchasedTime() {
        return purchasedTime;
    }

    public void setPurchasedTime(Date purchasedTime) {
        this.purchasedTime = purchasedTime;
    }

    /**
     * 获取skuID
     *
     * @return sku_id - skuID
     */
    public Integer getSkuId() {
        return skuId;
    }

    /**
     * 设置skuID
     *
     * @param skuId skuID
     */
    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    /**
     * 获取商品外键ID
     *
     * @return product_id - 商品外键ID
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置商品外键ID
     *
     * @param productId 商品外键ID
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取sku名称
     *
     * @return sku_name - sku名称
     */
    public String getSkuName() {
        return skuName;
    }

    /**
     * 设置sku名称
     *
     * @param skuName sku名称
     */
    public void setSkuName(String skuName) {
        this.skuName = skuName == null ? null : skuName.trim();
    }

    /**
     * 获取sku图片
     *
     * @return sku_img - sku图片
     */
    public String getSkuImg() {
        return skuImg;
    }

    /**
     * 设置sku图片
     *
     * @param skuImg sku图片
     */
    public void setSkuImg(String skuImg) {
        this.skuImg = skuImg == null ? null : skuImg.trim();
    }

    /**
     * 获取属性组合(格式k1:v1,k2:v2)
     *
     * @return untilled - 属性组合(格式k1:v1,k2:v2)
     */
    public Integer getUntilled() {
        return untilled;
    }

    /**
     * 设置属性组合(格式k1:v1,k2:v2)
     *
     * @param untilled 属性组合(格式k1:v1,k2:v2)
     */
    public void setUntilled(Integer untilled) {
        this.untilled = untilled;
    }

    /**
     * 获取原价
     *
     * @return original_price - 原价
     */
    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    /**
     * 设置原价
     *
     * @param originalPrice 原价
     */
    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * 获取销售价格
     *
     * @return sell_price - 销售价格
     */
    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    /**
     * 设置销售价格
     *
     * @param sellPrice 销售价格
     */
    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    /**
     * 获取折扣力度
     *
     * @return discount - 折扣力度
     */
    public BigDecimal getDiscount() {
        return discount;
    }

    /**
     * 设置折扣力度
     *
     * @param discount 折扣力度
     */
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    /**
     * 获取库存
     *
     * @return stock - 库存
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * 设置库存
     *
     * @param stock 库存
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * 获取状态(1启用，0禁用，-1删除)
     *
     * @return status - 状态(1启用，0禁用，-1删除)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态(1启用，0禁用，-1删除)
     *
     * @param status 状态(1启用，0禁用，-1删除)
     */
    public void setStatus(Integer status) {
        this.status = status;
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
}