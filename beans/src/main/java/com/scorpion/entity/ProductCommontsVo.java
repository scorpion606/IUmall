package com.scorpion.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

public class ProductCommontsVo implements Serializable {
    public ProductCommontsVo() {
    }

    public ProductCommontsVo(Integer comontId, Integer productId, Integer orderItemId, Integer userId, Integer isAnonymous, Integer commentType, Integer commentLevel, String commentImgs, Date commentTime, Integer replyStatus, Date replyTime, Integer isShow, String commentContent, String replyContent, String userName, String nickName, String avatra) {
        this.comontId = comontId;
        this.productId = productId;
        this.orderItemId = orderItemId;
        this.userId = userId;
        this.isAnonymous = isAnonymous;
        this.commentType = commentType;
        this.commentLevel = commentLevel;
        this.commentImgs = commentImgs;
        this.commentTime = commentTime;
        this.replyStatus = replyStatus;
        this.replyTime = replyTime;
        this.isShow = isShow;
        this.commentContent = commentContent;
        this.replyContent = replyContent;
        this.userName = userName;
        this.nickName = nickName;
        this.avatra = avatra;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
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
     * 用户名
     */
    private String userName;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 用户头像
     */
    private String avatra;

    public Integer getComontId() {
        return comontId;
    }

    public void setComontId(Integer comontId) {
        this.comontId = comontId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIsAnonymous() {
        return isAnonymous;
    }

    public void setIsAnonymous(Integer isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    public Integer getCommentType() {
        return commentType;
    }

    public void setCommentType(Integer commentType) {
        this.commentType = commentType;
    }

    public Integer getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(Integer commentLevel) {
        this.commentLevel = commentLevel;
    }

    public String getCommentImgs() {
        return commentImgs;
    }

    public void setCommentImgs(String commentImgs) {
        this.commentImgs = commentImgs;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getReplyStatus() {
        return replyStatus;
    }

    public void setReplyStatus(Integer replyStatus) {
        this.replyStatus = replyStatus;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatra() {
        return avatra;
    }

    public void setAvatra(String avatra) {
        this.avatra = avatra;
    }

    @Override
    public String toString() {
        return "ProductCommontsVo{" +
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
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", avatra='" + avatra + '\'' +
                '}';
    }
}