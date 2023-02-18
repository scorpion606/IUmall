package com.scorpion.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "iu_dynamic")
public class Dynamic {
    /**
     * 动态表ID主键
     */
    @Id
    private Integer id;

    /**
     * 用户外键
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 动态标题
     */
    @Column(name = "dynamic_name")
    private String dynamicName;

    /**
     * 动态内容
     */
    @Column(name = "dynamic_content")
    private String dynamicContent;

    /**
     * 浏览量
     */
    @Column(name = "scan_total")
    private Integer scanTotal;

    /**
     * 点赞量
     */
    @Column(name = "praise_total")
    private Integer praiseTotal;

    /**
     * 评论量
     */
    @Column(name = "comment_total")
    private Integer commentTotal;

    /**
     * 收藏量
     */
    @Column(name = "collect_total")
    private Integer collectTotal;

    /**
     * 转发量
     */
    @Column(name = "forward_total")
    private Integer forwardTotal;

    /**
     * 是否为被转发动态，0 否  1 是
     */
    @Column(name = "is_forward")
    private Byte isForward;

    /**
     * 被转发动态ID
     */
    @Column(name = "forwarded_id")
    private Integer forwardedId;

    /**
     * 被转发发布人ID
     */
    @Column(name = "forwarded_user_id")
    private Integer forwardedUserId;

    /**
     * 被转发发布人昵称
     */
    @Column(name = "forwarded_nick_name")
    private String forwardedNickName;

    /**
     * 分享图片地址
     */
    @Column(name = "share_url")
    private String shareUrl;

    /**
     * 逻辑删除，0 未删除  1 已删除
     */
    private Byte deleted;

    /**
     * 添加时间
     */
    @Column(name = "add_time")
    private Date addTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取动态表ID主键
     *
     * @return id - 动态表ID主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置动态表ID主键
     *
     * @param id 动态表ID主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户外键
     *
     * @return user_id - 用户外键
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户外键
     *
     * @param userId 用户外键
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取动态标题
     *
     * @return dynamic_name - 动态标题
     */
    public String getDynamicName() {
        return dynamicName;
    }

    /**
     * 设置动态标题
     *
     * @param dynamicName 动态标题
     */
    public void setDynamicName(String dynamicName) {
        this.dynamicName = dynamicName == null ? null : dynamicName.trim();
    }

    /**
     * 获取动态内容
     *
     * @return dynamic_content - 动态内容
     */
    public String getDynamicContent() {
        return dynamicContent;
    }

    /**
     * 设置动态内容
     *
     * @param dynamicContent 动态内容
     */
    public void setDynamicContent(String dynamicContent) {
        this.dynamicContent = dynamicContent == null ? null : dynamicContent.trim();
    }

    /**
     * 获取浏览量
     *
     * @return scan_total - 浏览量
     */
    public Integer getScanTotal() {
        return scanTotal;
    }

    /**
     * 设置浏览量
     *
     * @param scanTotal 浏览量
     */
    public void setScanTotal(Integer scanTotal) {
        this.scanTotal = scanTotal;
    }

    /**
     * 获取点赞量
     *
     * @return praise_total - 点赞量
     */
    public Integer getPraiseTotal() {
        return praiseTotal;
    }

    /**
     * 设置点赞量
     *
     * @param praiseTotal 点赞量
     */
    public void setPraiseTotal(Integer praiseTotal) {
        this.praiseTotal = praiseTotal;
    }

    /**
     * 获取评论量
     *
     * @return comment_total - 评论量
     */
    public Integer getCommentTotal() {
        return commentTotal;
    }

    /**
     * 设置评论量
     *
     * @param commentTotal 评论量
     */
    public void setCommentTotal(Integer commentTotal) {
        this.commentTotal = commentTotal;
    }

    /**
     * 获取收藏量
     *
     * @return collect_total - 收藏量
     */
    public Integer getCollectTotal() {
        return collectTotal;
    }

    /**
     * 设置收藏量
     *
     * @param collectTotal 收藏量
     */
    public void setCollectTotal(Integer collectTotal) {
        this.collectTotal = collectTotal;
    }

    /**
     * 获取转发量
     *
     * @return forward_total - 转发量
     */
    public Integer getForwardTotal() {
        return forwardTotal;
    }

    /**
     * 设置转发量
     *
     * @param forwardTotal 转发量
     */
    public void setForwardTotal(Integer forwardTotal) {
        this.forwardTotal = forwardTotal;
    }

    /**
     * 获取是否为被转发动态，0 否  1 是
     *
     * @return is_forward - 是否为被转发动态，0 否  1 是
     */
    public Byte getIsForward() {
        return isForward;
    }

    /**
     * 设置是否为被转发动态，0 否  1 是
     *
     * @param isForward 是否为被转发动态，0 否  1 是
     */
    public void setIsForward(Byte isForward) {
        this.isForward = isForward;
    }

    /**
     * 获取被转发动态ID
     *
     * @return forwarded_id - 被转发动态ID
     */
    public Integer getForwardedId() {
        return forwardedId;
    }

    /**
     * 设置被转发动态ID
     *
     * @param forwardedId 被转发动态ID
     */
    public void setForwardedId(Integer forwardedId) {
        this.forwardedId = forwardedId;
    }

    /**
     * 获取被转发发布人ID
     *
     * @return forwarded_user_id - 被转发发布人ID
     */
    public Integer getForwardedUserId() {
        return forwardedUserId;
    }

    /**
     * 设置被转发发布人ID
     *
     * @param forwardedUserId 被转发发布人ID
     */
    public void setForwardedUserId(Integer forwardedUserId) {
        this.forwardedUserId = forwardedUserId;
    }

    /**
     * 获取被转发发布人昵称
     *
     * @return forwarded_nick_name - 被转发发布人昵称
     */
    public String getForwardedNickName() {
        return forwardedNickName;
    }

    /**
     * 设置被转发发布人昵称
     *
     * @param forwardedNickName 被转发发布人昵称
     */
    public void setForwardedNickName(String forwardedNickName) {
        this.forwardedNickName = forwardedNickName == null ? null : forwardedNickName.trim();
    }

    /**
     * 获取分享图片地址
     *
     * @return share_url - 分享图片地址
     */
    public String getShareUrl() {
        return shareUrl;
    }

    /**
     * 设置分享图片地址
     *
     * @param shareUrl 分享图片地址
     */
    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl == null ? null : shareUrl.trim();
    }

    /**
     * 获取逻辑删除，0 未删除  1 已删除
     *
     * @return deleted - 逻辑删除，0 未删除  1 已删除
     */
    public Byte getDeleted() {
        return deleted;
    }

    /**
     * 设置逻辑删除，0 未删除  1 已删除
     *
     * @param deleted 逻辑删除，0 未删除  1 已删除
     */
    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    /**
     * 获取添加时间
     *
     * @return add_time - 添加时间
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 设置添加时间
     *
     * @param addTime 添加时间
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}