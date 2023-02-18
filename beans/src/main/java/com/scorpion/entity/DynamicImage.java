package com.scorpion.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "iu_dynamic_image")
public class DynamicImage {
    /**
     * 动态图片ID
     */
    @Id
    private Integer id;

    /**
     * 动态外键ID
     */
    @Column(name = "dynamic_id")
    private Integer dynamicId;

    /**
     * 图片地址
     */
    private String url;

    /**
     * 图片顺序
     */
    private Integer order;

    /**
     * 是否主图，0 不是主图   1 是主图
     */
    @Column(name = "is_main")
    private Byte isMain;

    /**
     * 图片属于tab标签类型
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
     * 获取动态图片ID
     *
     * @return id - 动态图片ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置动态图片ID
     *
     * @param id 动态图片ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取动态外键ID
     *
     * @return dynamic_id - 动态外键ID
     */
    public Integer getDynamicId() {
        return dynamicId;
    }

    /**
     * 设置动态外键ID
     *
     * @param dynamicId 动态外键ID
     */
    public void setDynamicId(Integer dynamicId) {
        this.dynamicId = dynamicId;
    }

    /**
     * 获取图片地址
     *
     * @return url - 图片地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置图片地址
     *
     * @param url 图片地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取图片顺序
     *
     * @return order - 图片顺序
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * 设置图片顺序
     *
     * @param order 图片顺序
     */
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
     * 获取是否主图，0 不是主图   1 是主图
     *
     * @return is_main - 是否主图，0 不是主图   1 是主图
     */
    public Byte getIsMain() {
        return isMain;
    }

    /**
     * 设置是否主图，0 不是主图   1 是主图
     *
     * @param isMain 是否主图，0 不是主图   1 是主图
     */
    public void setIsMain(Byte isMain) {
        this.isMain = isMain;
    }

    /**
     * 获取图片属于tab标签类型
     *
     * @return tab_type - 图片属于tab标签类型
     */
    public Integer getTabType() {
        return tabType;
    }

    /**
     * 设置图片属于tab标签类型
     *
     * @param tabType 图片属于tab标签类型
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