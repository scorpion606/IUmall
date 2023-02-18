package com.scorpion.entity;

import javax.persistence.*;
import java.io.Serializable;

public class Category implements Serializable {
    public Category() {
    }

    public Category(Integer categoryId, String categoryName, Integer categoryLevel, Integer parentId, String categoryIcon, String categorySlogan, String categoryPic, String categoryBgColor, Integer categoryStyle, Integer categorySeq, Integer categoryStatus, String url, Integer deleted) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryLevel = categoryLevel;
        this.parentId = parentId;
        this.categoryIcon = categoryIcon;
        this.categorySlogan = categorySlogan;
        this.categoryPic = categoryPic;
        this.categoryBgColor = categoryBgColor;
        this.categoryStyle = categoryStyle;
        this.categorySeq = categorySeq;
        this.categoryStatus = categoryStatus;
        this.url = url;
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryLevel=" + categoryLevel +
                ", parentId=" + parentId +
                ", categoryIcon='" + categoryIcon + '\'' +
                ", categorySlogan='" + categorySlogan + '\'' +
                ", categoryPic='" + categoryPic + '\'' +
                ", categoryBgColor='" + categoryBgColor + '\'' +
                ", categoryStyle=" + categoryStyle +
                ", categorySeq=" + categorySeq +
                ", categoryStatus=" + categoryStatus +
                ", url='" + url + '\'' +
                ", deleted=" + deleted +
                '}';
    }

    /**
     * 商品分类主键ID
     */
    @Id
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 商品名称
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * 分类层级
     */
    @Column(name = "category_level")
    private Integer categoryLevel;

    /**
     * 父层级ID
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 图标
     */
    @Column(name = "category_icon")
    private String categoryIcon;

    /**
     * 口号
     */
    @Column(name = "category_slogan")
    private String categorySlogan;

    /**
     * 分类图
     */
    @Column(name = "category_pic")
    private String categoryPic;

    /**
     * 背景颜色
     */
    @Column(name = "category_bg_color")
    private String categoryBgColor;

    /**
     * 分类类型
     */
    @Column(name="category_style")
    private Integer categoryStyle;

    /**
     * 分类展示顺序
     */
    @Column(name = "category_seq")
    private Integer categorySeq;

    /**
     * 分类类别是否在首页显示（0：不显示，1：显示）
     */
    @Column(name = "category_status")
    private Integer categoryStatus;

    /**
     * 跳转链接url
     */
    @Column(name = "url")
    private String url;

    /**
     * 逻辑删除（0：未删除，1：已删除）
     * @return
     */
    @Column(name = "deleted")
    private Integer deleted;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(Integer categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    public Integer getCategoryStyle() {
        return categoryStyle;
    }

    public void setCategoryStyle(Integer categoryStyle) {
        this.categoryStyle = categoryStyle;
    }

    /**
     * 获取商品分类主键ID
     *
     * @return category_id - 商品分类主键ID
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置商品分类主键ID
     *
     * @param categoryId 商品分类主键ID
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取商品名称
     *
     * @return category_name - 商品名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置商品名称
     *
     * @param categoryName 商品名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * 获取分类层级
     *
     * @return category_level - 分类层级
     */
    public Integer getCategoryLevel() {
        return categoryLevel;
    }

    /**
     * 设置分类层级
     *
     * @param categoryLevel 分类层级
     */
    public void setCategoryLevel(Integer categoryLevel) {
        this.categoryLevel = categoryLevel;
    }

    /**
     * 获取父层级ID
     *
     * @return parent_id - 父层级ID
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父层级ID
     *
     * @param parentId 父层级ID
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取图标
     *
     * @return category_icon - 图标
     */
    public String getCategoryIcon() {
        return categoryIcon;
    }

    /**
     * 设置图标
     *
     * @param categoryIcon 图标
     */
    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon == null ? null : categoryIcon.trim();
    }

    /**
     * 获取口号
     *
     * @return category_slogan - 口号
     */
    public String getCategorySlogan() {
        return categorySlogan;
    }

    /**
     * 设置口号
     *
     * @param categorySlogan 口号
     */
    public void setCategorySlogan(String categorySlogan) {
        this.categorySlogan = categorySlogan == null ? null : categorySlogan.trim();
    }

    /**
     * 获取分类图
     *
     * @return category_pic - 分类图
     */
    public String getCategoryPic() {
        return categoryPic;
    }

    /**
     * 设置分类图
     *
     * @param categoryPic 分类图
     */
    public void setCategoryPic(String categoryPic) {
        this.categoryPic = categoryPic == null ? null : categoryPic.trim();
    }

    /**
     * 获取背景颜色
     *
     * @return category_bg_color - 背景颜色
     */
    public String getCategoryBgColor() {
        return categoryBgColor;
    }

    /**
     * 设置背景颜色
     *
     * @param categoryBgColor 背景颜色
     */
    public void setCategoryBgColor(String categoryBgColor) {
        this.categoryBgColor = categoryBgColor == null ? null : categoryBgColor.trim();
    }

    public Integer getCategorySeq() {
        return categorySeq;
    }

    public void setCategorySeq(Integer categorySeq) {
        this.categorySeq = categorySeq;
    }
}