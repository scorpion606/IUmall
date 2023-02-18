package com.scorpion.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "product_img")
public class ProductImg implements Serializable {
    public ProductImg() {
    }

    public ProductImg(Integer id, Integer itemId, String url, Integer seq, Integer isMain, Integer isAd, Integer revision, Integer deleted, String createdBy, Date createdTime, String updatedBy, Date updatedTime) {
        this.id = id;
        this.itemId = itemId;
        this.url = url;
        this.seq = seq;
        this.isMain = isMain;
        this.isAd = isAd;
        this.revision = revision;
        this.deleted = deleted;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
        this.updatedBy = updatedBy;
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "ProductImg{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", url='" + url + '\'' +
                ", seq=" + seq +
                ", isMain=" + isMain +
                ", isAd=" + isAd +
                ", revision=" + revision +
                ", deleted=" + deleted +
                ", createdBy='" + createdBy + '\'' +
                ", createdTime=" + createdTime +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedTime=" + updatedTime +
                '}';
    }

    /**
     * 商品图片主键ID
     */
    @Id
    private Integer id;

    /**
     * 商品外键ID
     */
    @Column(name = "item_id")
    private Integer itemId;

    /**
     * 图片地址
     */
    private String url;

    /**
     * 顺序
     */
    private Integer seq;

    /**
     * 是够主图
     */
    @Column(name = "is_main")
    private Integer isMain;

    /**
     * 是否图片
     */
    @Column(name = "is_ad")
    private Integer isAd;

    /**
     * 乐观锁
     */
    @Column(name = "REVISION")
    private Integer revision;

    @Column(name = "deleted")
    private Integer deleted;

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
     * 获取商品图片主键ID
     *
     * @return id - 商品图片主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置商品图片主键ID
     *
     * @param id 商品图片主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取商品外键ID
     *
     * @return item_id - 商品外键ID
     */
    public Integer getItemId() {
        return itemId;
    }

    /**
     * 设置商品外键ID
     *
     * @param itemId 商品外键ID
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
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
     * 获取顺序
     *
     * @return seq - 顺序
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * 设置顺序
     *
     * @param seq 顺序
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * 获取是够主图
     *
     * @return is_main - 是够主图
     */
    public Integer getIsMain() {
        return isMain;
    }

    /**
     * 设置是够主图
     *
     * @param isMain 是够主图
     */
    public void setIsMain(Integer isMain) {
        this.isMain = isMain;
    }

    public Integer getIsAd() {
        return isAd;
    }

    public void setIsAd(Integer isAd) {
        this.isAd = isAd;
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

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
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