package com.scorpion.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "shopping_cart")
public class ShoppingCartVo implements Serializable {
    public ShoppingCartVo() {
    }

    public ShoppingCartVo(Integer cartId, Integer productId, Integer skuId, String skuProps, Integer userId, Integer cartNumber, Date cartTime, BigDecimal productPrice, String status, Integer revision, String createdBy, Date createdTime, String updatedBy, Date updatedTime, String productContent, String productName, String productImg, Double originalPrice, Double sellPrice, String skuName, String skuImg, Integer stock) {
        this.cartId = cartId;
        this.productId = productId;
        this.skuId = skuId;
        this.skuProps = skuProps;
        this.userId = userId;
        this.cartNumber = cartNumber;
        this.cartTime = cartTime;
        this.productPrice = productPrice;
        this.status = status;
        this.revision = revision;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
        this.updatedBy = updatedBy;
        this.updatedTime = updatedTime;
        this.productContent = productContent;
        this.productName = productName;
        this.productImg = productImg;
        this.originalPrice = originalPrice;
        this.sellPrice = sellPrice;
        this.skuName = skuName;
        this.skuImg = skuImg;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ShoppingCartVo{" +
                "cartId=" + cartId +
                ", productId=" + productId +
                ", skuId=" + skuId +
                ", skuProps='" + skuProps + '\'' +
                ", userId=" + userId +
                ", cartNumber=" + cartNumber +
                ", cartTime=" + cartTime +
                ", productPrice=" + productPrice +
                ", status='" + status + '\'' +
                ", revision=" + revision +
                ", createdBy='" + createdBy + '\'' +
                ", createdTime=" + createdTime +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedTime=" + updatedTime +
                ", productContent='" + productContent + '\'' +
                ", productName='" + productName + '\'' +
                ", productImg='" + productImg + '\'' +
                ", originalPrice=" + originalPrice +
                ", sellPrice=" + sellPrice +
                ", skuName='" + skuName + '\'' +
                ", skuImg='" + skuImg + '\'' +
                ", stock=" + stock +
                '}';
    }

    /**
     * 购物车主键ID
     */
    @Id
    @Column(name = "cart_id")
    private Integer cartId;

    /**
     * 商品外键ID
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * sku外键ID
     */
    @Column(name = "sku_id")
    private Integer skuId;

    /**
     *商品套餐属性
     */
    @Column(name = "sku_props")
    private String skuProps;

    /**
     * 用户外键ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 购物车商品数量
     */
    @Column(name = "cart_number")
    private Integer cartNumber;

    /**
     * 添加购物车时间
     */
    @Column(name = "cart_time")
    private Date cartTime;

    /**
     * 添加购物车时商品价格
     */
    @Column(name = "product_price")
    private BigDecimal productPrice;

    /**
     * 购物车状态
     */
    private String status;

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
     * 商品描述
     */
    private String productContent;
    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品主图
     */
    private String productImg;

    /**
     * 商品原价
     */
    private Double originalPrice;

    /**
     * 销售价格
     */
    private Double sellPrice;

    /**
     * 套餐名称
     */
    private String skuName;
    private String skuImg;

    public String getSkuImg() {
        return skuImg;
    }

    public void setSkuImg(String skuImg) {
        this.skuImg = skuImg;
    }

    /**
     * 商品套餐库存
     */
    private Integer stock;

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getProductContent() {
        return productContent;
    }

    public void setProductContent(String productContent) {
        this.productContent = productContent;
    }

    public String getUrl() {
        return productImg;
    }

    public void setUrl(String url) {
        productImg = url;
    }

    /**
     * 获取购物车主键ID
     *
     * @return cart_id - 购物车主键ID
     */
    public Integer getCartId() {
        return cartId;
    }

    /**
     * 设置购物车主键ID
     *
     * @param cartId 购物车主键ID
     */
    public void setCartId(Integer cartId) {
        this.cartId = cartId;
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
     * 获取sku外键ID
     *
     * @return sku_id - sku外键ID
     */
    public Integer getSkuId() {
        return skuId;
    }

    /**
     * 设置sku外键ID
     *
     * @param skuId sku外键ID
     */
    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public String getSkuProps() {
        return skuProps;
    }

    public void setSkuProps(String skuProps) {
        this.skuProps = skuProps;
    }

    /**
     * 获取用户外键ID
     *
     * @return user_id - 用户外键ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户外键ID
     *
     * @param userId 用户外键ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取购物车商品数量
     *
     * @return cart_number - 购物车商品数量
     */
    public Integer getCartNumber() {
        return cartNumber;
    }

    /**
     * 设置购物车商品数量
     *
     * @param cartNumber 购物车商品数量
     */
    public void setCartNumber(Integer cartNumber) {
        this.cartNumber = cartNumber;
    }

    /**
     * 获取添加购物车时间
     *
     * @return cart_time - 添加购物车时间
     */
    public Date getCartTime() {
        return cartTime;
    }

    /**
     * 设置添加购物车时间
     *
     * @param cartTime 添加购物车时间
     */
    public void setCartTime(Date cartTime) {
        this.cartTime = cartTime;
    }

    /**
     * 获取添加购物车时商品价格
     *
     * @return product_price - 添加购物车时商品价格
     */
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    /**
     * 设置添加购物车时商品价格
     *
     * @param productPrice 添加购物车时商品价格
     */
    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * 获取购物车状态
     *
     * @return status - 购物车状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置购物车状态
     *
     * @param status 购物车状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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