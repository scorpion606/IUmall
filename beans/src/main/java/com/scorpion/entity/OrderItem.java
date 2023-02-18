package com.scorpion.entity;

import lombok.Builder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Builder
@Table(name = "order_item")
public class OrderItem implements Serializable {
    public OrderItem() {
    }

    public OrderItem(Integer itemId, String orderId, Integer productId, String productName, String productImg, Integer skuId, String skuName, BigDecimal productPrice, Integer buyCount, BigDecimal totalAccount, Date basketData, Date buyTime, Integer isCommont, String skuAttr, Integer deleted) {
        this.itemId = itemId;
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.productImg = productImg;
        this.skuId = skuId;
        this.skuName = skuName;
        this.productPrice = productPrice;
        this.buyCount = buyCount;
        this.totalAccount = totalAccount;
        this.basketData = basketData;
        this.buyTime = buyTime;
        this.isCommont = isCommont;
        this.skuAttr = skuAttr;
        this.deleted = deleted;
    }

    public OrderItem(String orderId, Integer productId, String productName, String productImg, Integer skuId, String skuName, BigDecimal productPrice, Integer buyCount, BigDecimal totalAccount, Date basketData, Date buyTime, Integer isCommont, String skuAttr,Integer deleted) {
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.productImg = productImg;
        this.skuId = skuId;
        this.skuName = skuName;
        this.productPrice = productPrice;
        this.buyCount = buyCount;
        this.totalAccount = totalAccount;
        this.basketData = basketData;
        this.buyTime = buyTime;
        this.isCommont = isCommont;
        this.skuAttr=skuAttr;
        this.deleted=deleted;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "itemId=" + itemId +
                ", orderId='" + orderId + '\'' +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productImg='" + productImg + '\'' +
                ", skuId=" + skuId +
                ", skuName='" + skuName + '\'' +
                ", productPrice=" + productPrice +
                ", buyCount=" + buyCount +
                ", totalAccount=" + totalAccount +
                ", basketData=" + basketData +
                ", buyTime=" + buyTime +
                ", isCommont=" + isCommont +
                ", skuAttr='" + skuAttr + '\'' +
                ", deleted=" + deleted +
                '}';
    }

    /**
     * 订单项主键ID
     */
    @Id
    @Column(name = "item_id")
    private Integer itemId;

    /**
     * 订单外键ID
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 商品外键ID
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 商品图片
     */
    @Column(name = "product_img")
    private String productImg;

    /**
     * sku外键ID
     */
    @Column(name = "sku_id")
    private Integer skuId;

    /**
     * sku名称
     */
    @Column(name = "sku_name")
    private String skuName;

    /**
     * 商品价格
     */
    @Column(name = "product_price")
    private BigDecimal productPrice;

    /**
     * 购买数量
     */
    @Column(name = "buy_count")
    private Integer buyCount;

    /**
     * 商品总金额
     */
    @Column(name = "total_account")
    private BigDecimal totalAccount;

    /**
     * 加入购物车时间
     */
    @Column(name = "basket_data")
    private Date basketData;

    /**
     * 购买时间
     */
    @Column(name = "buy_time")
    private Date buyTime;

    /**
     * 评论状态(0,未评价1,已评价)
     */
    @Column(name = "is_commont")
    private Integer isCommont;

    /**
     * 套餐销售属性
     */
    @Column(name = "sku_attr")
    private String skuAttr;

    /**
     * 逻辑删除
     */
    @Column(name="deleted")
    private Integer deleted;

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getSkuAttr() {
        return skuAttr;
    }

    public void setSkuAttr(String skuAttr) {
        this.skuAttr = skuAttr;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public BigDecimal getTotalAccount() {
        return totalAccount;
    }

    public void setTotalAccount(BigDecimal totalAccount) {
        this.totalAccount = totalAccount;
    }

    public Date getBasketData() {
        return basketData;
    }

    public void setBasketData(Date basketData) {
        this.basketData = basketData;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public Integer getIsCommont() {
        return isCommont;
    }

    public void setIsCommont(Integer isCommont) {
        this.isCommont = isCommont;
    }

}