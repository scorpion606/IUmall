package com.scorpion.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


@Builder
@ToString
@Table(name = "iu_collect")
public class IuCollect implements Serializable {
    public IuCollect() {
    }

    public IuCollect(Integer id, Integer userId, Integer valueId, Integer type, Boolean status, Date addTime, Date updateTime, Boolean deleted) {
        this.id = id;
        this.userId = userId;
        this.valueId = valueId;
        this.type = type;
        this.status = status;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
    }

    @Id
    private Integer id;

    /**
     * 用户表的用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 如果type=1，则是商品ID；如果type=2，则是推荐ID
     */
    @Column(name = "value_id")
    private Integer valueId;

    /**
     * 收藏类型，如果type=1，则是商品ID；如果type=2，则是推荐ID
     */
    private Integer type;

    @Column(name = "status")
    private Boolean status;

    /**
     * 创建时间
     */
    @Column(name = "add_time")
    private Date addTime;

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
     * 获取如果type=1，则是商品ID；如果type=2，则是推荐ID
     *
     * @return value_id - 如果type=1，则是商品ID；如果type=2，则是推荐ID
     */
    public Integer getValueId() {
        return valueId;
    }

    /**
     * 设置如果type=1，则是商品ID；如果type=2，则是推荐ID
     *
     * @param valueId 如果type=1，则是商品ID；如果type=2，则是推荐ID
     */
    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }

    /**
     * 获取收藏类型，如果type=1，则是商品ID；如果type=2，则是推荐ID
     *
     * @return type - 收藏类型，如果type=1，则是商品ID；如果type=2，则是推荐ID
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置收藏类型，如果type=1，则是商品ID；如果type=2，则是推荐ID
     *
     * @param type 收藏类型，如果type=1，则是商品ID；如果type=2，则是推荐ID
     */
    public void setType(Integer type) {
        this.type = type;
    }


    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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