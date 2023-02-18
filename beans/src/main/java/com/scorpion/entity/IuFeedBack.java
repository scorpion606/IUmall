package com.scorpion.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@ApiModel(value = "feedBack对象",description = "意见反馈对象")
@Table(name = "iu_feedback")
public class IuFeedBack implements Serializable {
    @Id
    private Integer id;

    /**
     * 用户表的用户ID
     */
    @ApiModelProperty("用户表的用户ID")
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户名称
     */
    @ApiModelProperty("用户名称")
    private String username;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    @Column(name = "mobile")
    private String mobile;

    /**
     * 反馈类型(1：功能建议，2：BUG反馈，3：业务咨询，4：其他)
     */
    @Column(name = "feed_type")
    @ApiModelProperty("反馈类型(1：功能建议，2：BUG反馈，3：业务咨询，4：其他)")
    private String feedType;

    /**
     * 反馈内容
     */
    @ApiModelProperty("反馈内容")
    @Column(name = "content")
    private String content;

    @ApiModelProperty("回复内容")
    @Column(name = "reply")
    private String reply;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    @Column(name = "status")
    private Integer status;

    /**
     * 是否含有图片
     */
    @ApiModelProperty("是否含有图片")
    @Column(name = "has_picture")
    private Boolean hasPicture;

    /**
     * 图片地址列表，采用JSON数组格式
     */
    @ApiModelProperty("图片地址列表，采用JSON数组格式")
    @Column(name = "pic_urls")
    private String picUrls;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @Column(name = "add_time")
    private Date addTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 逻辑删除
     */
    @ApiModelProperty("逻辑删除")
    private Boolean deleted;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户表的用户ID
     *
     * @return user_id - 用户表的用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户表的用户ID
     *
     * @param userId 用户表的用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名称
     *
     * @return username - 用户名称
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名称
     *
     * @param username 用户名称
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取反馈类型(0：功能建议，1：BUG反馈，2：业务咨询，3：其他)
     *
     * @return feed_type - 反馈类型(0：功能建议，1：BUG反馈，2：业务咨询，3：其他)
     */
    public String getFeedType() {
        return feedType;
    }

    /**
     * 设置反馈类型(0：功能建议，1：BUG反馈，2：业务咨询，3：其他)
     *
     * @param feedType 反馈类型(0：功能建议，1：BUG反馈，2：业务咨询，3：其他)
     */
    public void setFeedType(String feedType) {
        this.feedType = feedType == null ? null : feedType.trim();
    }

    /**
     * 获取反馈内容
     *
     * @return content - 反馈内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置反馈内容
     *
     * @param content 反馈内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取是否含有图片
     *
     * @return has_picture - 是否含有图片
     */
    public Boolean getHasPicture() {
        return hasPicture;
    }

    /**
     * 设置是否含有图片
     *
     * @param hasPicture 是否含有图片
     */
    public void setHasPicture(Boolean hasPicture) {
        this.hasPicture = hasPicture;
    }

    /**
     * 获取图片地址列表，采用JSON数组格式
     *
     * @return pic_urls - 图片地址列表，采用JSON数组格式
     */
    public String getPicUrls() {
        return picUrls;
    }

    /**
     * 设置图片地址列表，采用JSON数组格式
     *
     * @param picUrls 图片地址列表，采用JSON数组格式
     */
    public void setPicUrls(String picUrls) {
        this.picUrls = picUrls == null ? null : picUrls.trim();
    }

    /**
     * 获取创建时间
     *
     * @return add_time - 创建时间
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 设置创建时间
     *
     * @param addTime 创建时间
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取逻辑删除
     *
     * @return deleted - 逻辑删除
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * 设置逻辑删除
     *
     * @param deleted 逻辑删除
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}