package com.scorpion.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "iu_user_account")
public class IuUserAccount {
    @Id
    private Integer id;

    /**
     * 用户表的用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 账户总余额
     */
    @Column(name = "remain_amount")
    private BigDecimal remainAmount;

    /**
     * 账户总额
     */
    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 结算利率：5 表示5%或0.05
     */
    @Column(name = "settlement_rate")
    private Integer settlementRate;

    /**
     * 账户状态
     */
    private Byte status;

    /**
     * 分享推广二维码URL
     */
    @Column(name = "share_url")
    private String shareUrl;

    /**
     * 逻辑删除(0:正常,1:删除)
     */
    private Integer deleted;

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
     * 获取账户总余额
     *
     * @return remain_amount - 账户总余额
     */
    public BigDecimal getRemainAmount() {
        return remainAmount;
    }

    /**
     * 设置账户总余额
     *
     * @param remainAmount 账户总余额
     */
    public void setRemainAmount(BigDecimal remainAmount) {
        this.remainAmount = remainAmount;
    }

    /**
     * 获取账户总额
     *
     * @return total_amount - 账户总额
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * 设置账户总额
     *
     * @param totalAmount 账户总额
     */
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取结算利率：5 表示5%或0.05
     *
     * @return settlement_rate - 结算利率：5 表示5%或0.05
     */
    public Integer getSettlementRate() {
        return settlementRate;
    }

    /**
     * 设置结算利率：5 表示5%或0.05
     *
     * @param settlementRate 结算利率：5 表示5%或0.05
     */
    public void setSettlementRate(Integer settlementRate) {
        this.settlementRate = settlementRate;
    }

    /**
     * 获取账户状态
     *
     * @return status - 账户状态
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置账户状态
     *
     * @param status 账户状态
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取分享推广二维码URL
     *
     * @return share_url - 分享推广二维码URL
     */
    public String getShareUrl() {
        return shareUrl;
    }

    /**
     * 设置分享推广二维码URL
     *
     * @param shareUrl 分享推广二维码URL
     */
    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl == null ? null : shareUrl.trim();
    }

    /**
     * 获取逻辑删除(0:正常,1:删除)
     *
     * @return deleted - 逻辑删除(0:正常,1:删除)
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 设置逻辑删除(0:正常,1:删除)
     *
     * @param deleted 逻辑删除(0:正常,1:删除)
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}