package com.scorpion.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "index_img")
public class IndexImg implements Serializable {
    @Override
    public String toString() {
        return "IndexImg{" +
                "imgId=" + imgId +
                ", prodId=" + prodId +
                ", categoryId=" + categoryId +
                ", imgUrl='" + imgUrl + '\'' +
                ", imgBgColor='" + imgBgColor + '\'' +
                ", indexType='" + indexType + '\'' +
                ", seq='" + seq + '\'' +
                ", status='" + status + '\'' +
                ", revision=" + revision +
                ", createdBy='" + createdBy + '\'' +
                ", createdTime=" + createdTime +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedTime=" + updatedTime +
                '}';
    }

    /**
     * 图片主键ID
     */
    @Id
    @Column(name = "img_id")
    private Integer imgId;

    /**
     * 商品外键ID
     */
    @Column(name = "prod_id")
    private Integer prodId;

    /**
     * 商品分类外键ID
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 图片地址
     */
    @Column(name = "img_url")
    private String imgUrl;

    /**
     * 背景色
     */
    @Column(name = "img_bg_color")
    private String imgBgColor;

    /**
     * 轮播图类型
     */
    @Column(name = "index_type")
    private String indexType;

    /**
     * 轮播图展示顺序
     */
    private String seq;

    /**
     * 是否展示，1表示正常显示，0表示下线
     */
    private String status;

    /**
     * 乐观锁
     */
    @Column(name = "REVISION")
    private Integer revision;

    /**
     * 创建人
     */
    @Column(name = "CREATED_BY")
    private String createdBy;

    /**
     * 创建时间
     */
    @Column(name = "CREATED_TIME")
    private Date createdTime;

    /**
     * 更新人
     */
    @Column(name = "UPDATED_BY")
    private String updatedBy;

    /**
     * 更新时间
     */
    @Column(name = "UPDATED_TIME")
    private Date updatedTime;

    /**
     * 获取图片主键ID
     *
     * @return img_id - 图片主键ID
     */
    public Integer getImgId() {
        return imgId;
    }

    /**
     * 设置图片主键ID
     *
     * @param imgId 图片主键ID
     */
    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    /**
     * 获取商品外键ID
     *
     * @return prod_id - 商品外键ID
     */
    public Integer getProdId() {
        return prodId;
    }

    /**
     * 设置商品外键ID
     *
     * @param prodId 商品外键ID
     */
    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    /**
     * 获取商品分类外键ID
     *
     * @return category_id - 商品分类外键ID
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置商品分类外键ID
     *
     * @param categoryId 商品分类外键ID
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取图片地址
     *
     * @return img_url - 图片地址
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 设置图片地址
     *
     * @param imgUrl 图片地址
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * 获取背景色
     *
     * @return img_bg_color - 背景色
     */
    public String getImgBgColor() {
        return imgBgColor;
    }

    /**
     * 设置背景色
     *
     * @param imgBgColor 背景色
     */
    public void setImgBgColor(String imgBgColor) {
        this.imgBgColor = imgBgColor == null ? null : imgBgColor.trim();
    }

    /**
     * 获取轮播图类型
     *
     * @return index_type - 轮播图类型
     */
    public String getIndexType() {
        return indexType;
    }

    /**
     * 设置轮播图类型
     *
     * @param indexType 轮播图类型
     */
    public void setIndexType(String indexType) {
        this.indexType = indexType == null ? null : indexType.trim();
    }

    /**
     * 获取轮播图展示顺序
     *
     * @return seq - 轮播图展示顺序
     */
    public String getSeq() {
        return seq;
    }

    /**
     * 设置轮播图展示顺序
     *
     * @param seq 轮播图展示顺序
     */
    public void setSeq(String seq) {
        this.seq = seq == null ? null : seq.trim();
    }

    /**
     * 获取是否展示，1表示正常显示，0表示下线
     *
     * @return status - 是否展示，1表示正常显示，0表示下线
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置是否展示，1表示正常显示，0表示下线
     *
     * @param status 是否展示，1表示正常显示，0表示下线
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取乐观锁
     *
     * @return REVISION - 乐观锁
     */
    public Integer getRevision() {
        return revision;
    }

    /**
     * 设置乐观锁
     *
     * @param revision 乐观锁
     */
    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    /**
     * 获取创建人
     *
     * @return CREATED_BY - 创建人
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
     * @return CREATED_TIME - 创建时间
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
     * 获取更新人
     *
     * @return UPDATED_BY - 更新人
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置更新人
     *
     * @param updatedBy 更新人
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    /**
     * 获取更新时间
     *
     * @return UPDATED_TIME - 更新时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置更新时间
     *
     * @param updatedTime 更新时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}