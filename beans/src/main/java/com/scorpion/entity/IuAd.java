package com.scorpion.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "iu_ad")
public class IuAd implements Serializable {
    public IuAd() {
    }

    public IuAd(Integer id, String name, String link, String url, Byte position, String content, Date startTime, Date endTime, Integer status, Date createdTime, Date updateTime, Boolean deleted) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.url = url;
        this.position = position;
        this.content = content;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.createdTime = createdTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "IuAd{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", url='" + url + '\'' +
                ", position=" + position +
                ", content='" + content + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status=" + status +
                ", createdTime=" + createdTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }

    @Id
    private Integer id;

    /**
     * 广告标题
     */
    @Column(name = "name")
    private String name;

    /**
     * 所广告的商品页面或者活动页面链接地址
     */
    @Column(name = "link")
    private String link;

    /**
     * 广告宣传图片
     */
    @Column(name = "url")
    private String url;

    /**
     * 广告位置：1则是首页
     */
    @Column(name = "position")
    private Byte position;

    /**
     * 活动内容
     */
    @Column(name = "content")
    private String content;

    /**
     * 广告开始时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 广告结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 是否展示
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 逻辑删除
     */
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
     * 获取广告标题
     *
     * @return name - 广告标题
     */
    public String getName() {
        return name;
    }

    /**
     * 设置广告标题
     *
     * @param name 广告标题
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取所广告的商品页面或者活动页面链接地址
     *
     * @return link - 所广告的商品页面或者活动页面链接地址
     */
    public String getLink() {
        return link;
    }

    /**
     * 设置所广告的商品页面或者活动页面链接地址
     *
     * @param link 所广告的商品页面或者活动页面链接地址
     */
    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    /**
     * 获取广告宣传图片
     *
     * @return url - 广告宣传图片
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置广告宣传图片
     *
     * @param url 广告宣传图片
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取广告位置：1则是首页
     *
     * @return position - 广告位置：1则是首页
     */
    public Byte getPosition() {
        return position;
    }

    /**
     * 设置广告位置：1则是首页
     *
     * @param position 广告位置：1则是首页
     */
    public void setPosition(Byte position) {
        this.position = position;
    }

    /**
     * 获取活动内容
     *
     * @return content - 活动内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置活动内容
     *
     * @param content 活动内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取广告开始时间
     *
     * @return start_time - 广告开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置广告开始时间
     *
     * @param startTime 广告开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取广告结束时间
     *
     * @return end_time - 广告结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置广告结束时间
     *
     * @param endTime 广告结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取是否展示
     *
     * @return stauts - 是否展示
     */
    public int getStatus() {
        return status;
    }

    /**
     * 设置是否展示
     *
     * @param status 是否展示
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return created_time - 创建时间
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