package com.scorpion.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "iu_praise")
public class Praise {
    /**
     * 点赞表主键ID
     */
    @Id
    private Integer id;

    /**
     * 点赞人ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 被点赞主题ID
     */
    @Column(name = "subject_id")
    private Integer subjectId;

    /**
     * 点赞属于tab标签类型
     */
    @Column(name = "tab_type")
    private Integer tabType;

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
     * 获取点赞表主键ID
     *
     * @return id - 点赞表主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置点赞表主键ID
     *
     * @param id 点赞表主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取点赞人ID
     *
     * @return user_id - 点赞人ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置点赞人ID
     *
     * @param userId 点赞人ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取被点赞主题ID
     *
     * @return subject_id - 被点赞主题ID
     */
    public Integer getSubjectId() {
        return subjectId;
    }

    /**
     * 设置被点赞主题ID
     *
     * @param subjectId 被点赞主题ID
     */
    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * 获取点赞属于tab标签类型
     *
     * @return tab_type - 点赞属于tab标签类型
     */
    public Integer getTabType() {
        return tabType;
    }

    /**
     * 设置点赞属于tab标签类型
     *
     * @param tabType 点赞属于tab标签类型
     */
    public void setTabType(Integer tabType) {
        this.tabType = tabType;
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