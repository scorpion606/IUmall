package com.scorpion.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "product_commonts")
public class ProductCommonts implements Serializable {
    @Override
    public String toString() {
        return "ProductCommonts{" +
                "comontId=" + comontId +
                ", productId=" + productId +
                ", orderItemId=" + orderItemId +
                ", userId=" + userId +
                ", isAnonymous=" + isAnonymous +
                ", commentType=" + commentType +
                ", commentLevel=" + commentLevel +
                ", commentImgs='" + commentImgs + '\'' +
                ", commentTime=" + commentTime +
                ", replyStatus=" + replyStatus +
                ", replyTime=" + replyTime +
                ", isShow=" + isShow +
                ", commentContent='" + commentContent + '\'' +
                ", replyContent='" + replyContent + '\'' +
                '}';
    }

    /**
     * 商品评价主键ID
     */
    @Id
    @Column(name = "comont_id")
    private Integer comontId;

    /**
     * 商品外键ID
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 订单项外键ID
     */
    @Column(name = "order_item_id")
    private Integer orderItemId;

    /**
     * 商品外键ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 是否匿名(1,是2,否)
     */
    @Column(name = "is_anonymous")
    private Integer isAnonymous;

    /**
     * 评价类型(0,好评1,中评-1,差评)
     */
    @Column(name = "comment_type")
    private Integer commentType;

    /**
     * 评价等级
     */
    @Column(name = "comment_level")
    private Integer commentLevel;

    /**
     * 评价晒图
     */
    @Column(name = "comment_imgs")
    private String commentImgs;

    /**
     * 评价时间
     */
    @Column(name = "comment_time")
    private Date commentTime;

    /**
     * 是否回复(0,未回复1,已回复)
     */
    @Column(name = "reply_status")
    private Integer replyStatus;

    /**
     * 回复时间
     */
    @Column(name = "reply_time")
    private Date replyTime;

    /**
     * 是否显示(1,是2,否)
     */
    @Column(name = "is_show")
    private Integer isShow;

    /**
     * 评价内容
     */
    @Column(name = "comment_content")
    private String commentContent;

    /**
     * 恢复内容
     */
    @Column(name = "reply_content")
    private String replyContent;

    /**
     * 获取商品评价主键ID
     *
     * @return comont_id - 商品评价主键ID
     */
    public Integer getComontId() {
        return comontId;
    }

    /**
     * 设置商品评价主键ID
     *
     * @param comontId 商品评价主键ID
     */
    public void setComontId(Integer comontId) {
        this.comontId = comontId;
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
     * 获取订单项外键ID
     *
     * @return order_item_id - 订单项外键ID
     */
    public Integer getOrderItemId() {
        return orderItemId;
    }

    /**
     * 设置订单项外键ID
     *
     * @param orderItemId 订单项外键ID
     */
    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    /**
     * 获取商品外键ID
     *
     * @return user_id - 商品外键ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置商品外键ID
     *
     * @param userId 商品外键ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取是否匿名(1,是2,否)
     *
     * @return is_anonymous - 是否匿名(1,是2,否)
     */
    public Integer getIsAnonymous() {
        return isAnonymous;
    }

    /**
     * 设置是否匿名(1,是2,否)
     *
     * @param isAnonymous 是否匿名(1,是2,否)
     */
    public void setIsAnonymous(Integer isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    /**
     * 获取评价类型(0,好评1,中评-1,差评)
     *
     * @return comment_type - 评价类型(0,好评1,中评-1,差评)
     */
    public Integer getCommentType() {
        return commentType;
    }

    /**
     * 设置评价类型(0,好评1,中评-1,差评)
     *
     * @param commentType 评价类型(0,好评1,中评-1,差评)
     */
    public void setCommentType(Integer commentType) {
        this.commentType = commentType;
    }

    /**
     * 获取评价等级
     *
     * @return comment_level - 评价等级
     */
    public Integer getCommentLevel() {
        return commentLevel;
    }

    /**
     * 设置评价等级
     *
     * @param commentLevel 评价等级
     */
    public void setCommentLevel(Integer commentLevel) {
        this.commentLevel = commentLevel;
    }

    /**
     * 获取评价晒图
     *
     * @return comment_imgs - 评价晒图
     */
    public String getCommentImgs() {
        return commentImgs;
    }

    /**
     * 设置评价晒图
     *
     * @param commentImgs 评价晒图
     */
    public void setCommentImgs(String commentImgs) {
        this.commentImgs = commentImgs == null ? null : commentImgs.trim();
    }

    /**
     * 获取评价时间
     *
     * @return comment_time - 评价时间
     */
    public Date getCommentTime() {
        return commentTime;
    }

    /**
     * 设置评价时间
     *
     * @param commentTime 评价时间
     */
    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    /**
     * 获取是否回复(0,未回复1,已回复)
     *
     * @return reply_status - 是否回复(0,未回复1,已回复)
     */
    public Integer getReplyStatus() {
        return replyStatus;
    }

    /**
     * 设置是否回复(0,未回复1,已回复)
     *
     * @param replyStatus 是否回复(0,未回复1,已回复)
     */
    public void setReplyStatus(Integer replyStatus) {
        this.replyStatus = replyStatus;
    }

    /**
     * 获取回复时间
     *
     * @return reply_time - 回复时间
     */
    public Date getReplyTime() {
        return replyTime;
    }

    /**
     * 设置回复时间
     *
     * @param replyTime 回复时间
     */
    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    /**
     * 获取是否显示(1,是2,否)
     *
     * @return is_show - 是否显示(1,是2,否)
     */
    public Integer getIsShow() {
        return isShow;
    }

    /**
     * 设置是否显示(1,是2,否)
     *
     * @param isShow 是否显示(1,是2,否)
     */
    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    /**
     * 获取评价内容
     *
     * @return comment_content - 评价内容
     */
    public String getCommentContent() {
        return commentContent;
    }

    /**
     * 设置评价内容
     *
     * @param commentContent 评价内容
     */
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    /**
     * 获取恢复内容
     *
     * @return reply_content - 恢复内容
     */
    public String getReplyContent() {
        return replyContent;
    }

    /**
     * 设置恢复内容
     *
     * @param replyContent 恢复内容
     */
    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }
}