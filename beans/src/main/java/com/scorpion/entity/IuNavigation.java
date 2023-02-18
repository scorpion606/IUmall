package com.scorpion.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "iu_navigation")
public class IuNavigation {
    /**
     * 导航分类id
     */
    @Id
    private Integer id;

    /**
     * 父id
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 导航分类名称
     */
    private String name;

    /**
     * 导航分类别称
     */
    private String slogan;

    /**
     * 跳转链接url
     */
    private String link;

    /**
     * 图标url
     */
    private String icon;

    /**
     * 导航分类顺序
     */
    private Integer seq;

    /**
     * 导航分类状态（0：展示，1：未展示）
     */
    private Integer status;

    /**
     * 逻辑删除（0：未删除，1：已删除）
     */
    private Integer deleted;

    /**
     * 创建人
     */
    @Column(name = "created_by")
    private String createdBy;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 修改人
     */
    @Column(name = "updated_by")
    private String updatedBy;

    /**
     * 修改时间
     */
    @Column(name = "updated_time")
    private Date updatedTime;

    /**
     * 获取导航分类id
     *
     * @return id - 导航分类id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置导航分类id
     *
     * @param id 导航分类id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取父id
     *
     * @return parent_id - 父id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父id
     *
     * @param parentId 父id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取导航分类名称
     *
     * @return name - 导航分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置导航分类名称
     *
     * @param name 导航分类名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取导航分类别称
     *
     * @return slogan - 导航分类别称
     */
    public String getSlogan() {
        return slogan;
    }

    /**
     * 设置导航分类别称
     *
     * @param slogan 导航分类别称
     */
    public void setSlogan(String slogan) {
        this.slogan = slogan == null ? null : slogan.trim();
    }

    /**
     * 获取跳转链接url
     *
     * @return link - 跳转链接url
     */
    public String getLink() {
        return link;
    }

    /**
     * 设置跳转链接url
     *
     * @param link 跳转链接url
     */
    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    /**
     * 获取图标url
     *
     * @return icon - 图标url
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标url
     *
     * @param icon 图标url
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 获取导航分类顺序
     *
     * @return seq - 导航分类顺序
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * 设置导航分类顺序
     *
     * @param seq 导航分类顺序
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * 获取导航分类状态（0：展示，1：未展示）
     *
     * @return status - 导航分类状态（0：展示，1：未展示）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置导航分类状态（0：展示，1：未展示）
     *
     * @param status 导航分类状态（0：展示，1：未展示）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取逻辑删除（0：未删除，1：已删除）
     *
     * @return deleted - 逻辑删除（0：未删除，1：已删除）
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 设置逻辑删除（0：未删除，1：已删除）
     *
     * @param deleted 逻辑删除（0：未删除，1：已删除）
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /**
     * 获取创建人
     *
     * @return created_by - 创建人
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
     * 获取修改人
     *
     * @return updated_by - 修改人
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置修改人
     *
     * @param updatedBy 修改人
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    /**
     * 获取修改时间
     *
     * @return updated_time - 修改时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置修改时间
     *
     * @param updatedTime 修改时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}