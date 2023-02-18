package com.scorpion.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "iu_tabs")
public class IuTabs implements Serializable {
    /**
     * 导航标签id
     */
    @Id
    private Integer id;

    /**
     * 标签名字
     */
    private String name;

    /**
     * 滑块背景图
     */
    @Column(name = "line_bg")
    private String lineBg;

    /**
     * 标签顺序
     */
    @Column(name = "seq")
    private Integer seq;

    @Column(name = "collect_name")
    private String collectName;

    @Column(name="is_collect")
    private Boolean isCollect;
    /**
     * 是否启动（0：启动，1未启动）
     */
    private Integer status;

    /**
     * 逻辑删除（0：未删除，1：已删除）
     */
    private Integer deleted;

    /**
     * 创建人姓名
     */
    @Column(name = "created_by")
    private String createdBy;

    /**
     * 创建时间
     */
    @Column(name = "creted_time")
    private Date cretedTime;

    /**
     * 修改人姓名
     */
    @Column(name = "updated_by")
    private String updatedBy;

    /**
     * 修改时间
     */
    @Column(name = "updated_time")
    private Date updatedTime;

    /**
     * 获取导航标签id
     *
     * @return id - 导航标签id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置导航标签id
     *
     * @param id 导航标签id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取标签名字
     *
     * @return name - 标签名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置标签名字
     *
     * @param name 标签名字
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取滑块背景图
     *
     * @return line_bg - 滑块背景图
     */
    public String getLineBg() {
        return lineBg;
    }

    /**
     * 设置滑块背景图
     *
     * @param lineBg 滑块背景图
     */
    public void setLineBg(String lineBg) {
        this.lineBg = lineBg == null ? null : lineBg.trim();
    }

    /**
     * 获取标签顺序
     *
     * @return seq - 标签顺序
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * 设置标签顺序
     *
     * @param seq 标签顺序
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * 获取是否启动（0：启动，1未启动）
     *
     * @return status - 是否启动（0：启动，1未启动）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置是否启动（0：启动，1未启动）
     *
     * @param status 是否启动（0：启动，1未启动）
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
     * 获取创建人姓名
     *
     * @return created_by - 创建人姓名
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置创建人姓名
     *
     * @param createdBy 创建人姓名
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    /**
     * 获取创建时间
     *
     * @return creted_time - 创建时间
     */
    public Date getCretedTime() {
        return cretedTime;
    }

    /**
     * 设置创建时间
     *
     * @param cretedTime 创建时间
     */
    public void setCretedTime(Date cretedTime) {
        this.cretedTime = cretedTime;
    }

    /**
     * 获取修改人姓名
     *
     * @return updated_by - 修改人姓名
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置修改人姓名
     *
     * @param updatedBy 修改人姓名
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

    public String getCollectName() {
        return collectName;
    }

    public void setCollectName(String collectName) {
        this.collectName = collectName;
    }

    public Boolean getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(Boolean collect) {
        isCollect = collect;
    }
}