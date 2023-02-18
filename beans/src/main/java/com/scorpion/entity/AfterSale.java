package com.scorpion.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "li_after_sale")
public class AfterSale {
    /**
     * ID
     */
    @Id
    private Long id;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 删除标志 true/false 删除/未删除
     */
    @Column(name = "delete_flag")
    private Boolean deleteFlag;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 账号类型
     */
    @Column(name = "account_type")
    private String accountType;

    /**
     * 实际退款金额
     */
    @Column(name = "actual_refund_price")
    private Double actualRefundPrice;

    /**
     * 评价图片
     */
    @Column(name = "after_sale_image")
    private String afterSaleImage;

    /**
     * 申请退款金额
     */
    @Column(name = "apply_refund_price")
    private Double applyRefundPrice;

    /**
     * 商家备注
     */
    @Column(name = "audit_remark")
    private String auditRemark;

    /**
     * 银行开户名
     */
    @Column(name = "bank_account_name")
    private String bankAccountName;

    /**
     * 银行账户
     */
    @Column(name = "bank_account_number")
    private String bankAccountNumber;

    /**
     * 银行开户行
     */
    @Column(name = "bank_deposit_name")
    private String bankDepositName;

    /**
     * 实际金额
     */
    @Column(name = "flow_price")
    private Double flowPrice;

    /**
     * 商品ID
     */
    @Column(name = "goods_id")
    private String goodsId;

    /**
     * 商品图片
     */
    @Column(name = "goods_image")
    private String goodsImage;

    /**
     * 商品名称
     */
    @Column(name = "goods_name")
    private String goodsName;

    /**
     * 买家 发货时间
     */
    @Column(name = "m_deliver_time")
    private Date mDeliverTime;

    /**
     * 买家 物流公司CODE
     */
    @Column(name = "m_logistics_code")
    private String mLogisticsCode;

    /**
     * 买家 物流公司名称
     */
    @Column(name = "m_logistics_name")
    private String mLogisticsName;

    /**
     * 买家 发货单号
     */
    @Column(name = "m_logistics_no")
    private String mLogisticsNo;

    /**
     * 用户ID
     */
    @Column(name = "member_id")
    private String memberId;

    /**
     * 用户名称
     */
    @Column(name = "member_name")
    private String memberName;

    /**
     * 申请数量
     */
    private Integer num;

    /**
     * 订单编号
     */
    @Column(name = "order_sn")
    private String orderSn;

    /**
     * 订单支付方式返回的交易号
     */
    @Column(name = "pay_order_no")
    private String payOrderNo;

    /**
     * 问题描述
     */
    @Column(name = "problem_desc")
    private String problemDesc;

    /**
     * 申请原因
     */
    private String reason;

    /**
     * 退还积分
     */
    @Column(name = "refund_point")
    private Integer refundPoint;

    /**
     * 退款时间
     */
    @Column(name = "refund_time")
    private Date refundTime;

    /**
     * 退款方式
     */
    @Column(name = "refund_way")
    private String refundWay;

    /**
     * 店铺ID
     */
    @Column(name = "store_id")
    private String storeId;

    /**
     * 店铺名称
     */
    @Column(name = "store_name")
    private String storeName;

    /**
     * 售后单状态
     */
    @Column(name = "service_status")
    private String serviceStatus;

    /**
     * 售后类型
     */
    @Column(name = "service_type")
    private String serviceType;

    /**
     * 货品ID
     */
    @Column(name = "sku_id")
    private String skuId;

    /**
     * 售后服务单号
     */
    private String sn;

    /**
     * 交易编号
     */
    @Column(name = "trade_sn")
    private String tradeSn;

    /**
     * 订单货物编号
     */
    @Column(name = "order_item_sn")
    private String orderItemSn;

    /**
     * 规格json
     */
    private String specs;

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
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
     * 获取删除标志 true/false 删除/未删除
     *
     * @return delete_flag - 删除标志 true/false 删除/未删除
     */
    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置删除标志 true/false 删除/未删除
     *
     * @param deleteFlag 删除标志 true/false 删除/未删除
     */
    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新者
     *
     * @param updateBy 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
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
     * 获取账号类型
     *
     * @return account_type - 账号类型
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * 设置账号类型
     *
     * @param accountType 账号类型
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType == null ? null : accountType.trim();
    }

    /**
     * 获取实际退款金额
     *
     * @return actual_refund_price - 实际退款金额
     */
    public Double getActualRefundPrice() {
        return actualRefundPrice;
    }

    /**
     * 设置实际退款金额
     *
     * @param actualRefundPrice 实际退款金额
     */
    public void setActualRefundPrice(Double actualRefundPrice) {
        this.actualRefundPrice = actualRefundPrice;
    }

    /**
     * 获取评价图片
     *
     * @return after_sale_image - 评价图片
     */
    public String getAfterSaleImage() {
        return afterSaleImage;
    }

    /**
     * 设置评价图片
     *
     * @param afterSaleImage 评价图片
     */
    public void setAfterSaleImage(String afterSaleImage) {
        this.afterSaleImage = afterSaleImage == null ? null : afterSaleImage.trim();
    }

    /**
     * 获取申请退款金额
     *
     * @return apply_refund_price - 申请退款金额
     */
    public Double getApplyRefundPrice() {
        return applyRefundPrice;
    }

    /**
     * 设置申请退款金额
     *
     * @param applyRefundPrice 申请退款金额
     */
    public void setApplyRefundPrice(Double applyRefundPrice) {
        this.applyRefundPrice = applyRefundPrice;
    }

    /**
     * 获取商家备注
     *
     * @return audit_remark - 商家备注
     */
    public String getAuditRemark() {
        return auditRemark;
    }

    /**
     * 设置商家备注
     *
     * @param auditRemark 商家备注
     */
    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark == null ? null : auditRemark.trim();
    }

    /**
     * 获取银行开户名
     *
     * @return bank_account_name - 银行开户名
     */
    public String getBankAccountName() {
        return bankAccountName;
    }

    /**
     * 设置银行开户名
     *
     * @param bankAccountName 银行开户名
     */
    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName == null ? null : bankAccountName.trim();
    }

    /**
     * 获取银行账户
     *
     * @return bank_account_number - 银行账户
     */
    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    /**
     * 设置银行账户
     *
     * @param bankAccountNumber 银行账户
     */
    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber == null ? null : bankAccountNumber.trim();
    }

    /**
     * 获取银行开户行
     *
     * @return bank_deposit_name - 银行开户行
     */
    public String getBankDepositName() {
        return bankDepositName;
    }

    /**
     * 设置银行开户行
     *
     * @param bankDepositName 银行开户行
     */
    public void setBankDepositName(String bankDepositName) {
        this.bankDepositName = bankDepositName == null ? null : bankDepositName.trim();
    }

    /**
     * 获取实际金额
     *
     * @return flow_price - 实际金额
     */
    public Double getFlowPrice() {
        return flowPrice;
    }

    /**
     * 设置实际金额
     *
     * @param flowPrice 实际金额
     */
    public void setFlowPrice(Double flowPrice) {
        this.flowPrice = flowPrice;
    }

    /**
     * 获取商品ID
     *
     * @return goods_id - 商品ID
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * 设置商品ID
     *
     * @param goodsId 商品ID
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    /**
     * 获取商品图片
     *
     * @return goods_image - 商品图片
     */
    public String getGoodsImage() {
        return goodsImage;
    }

    /**
     * 设置商品图片
     *
     * @param goodsImage 商品图片
     */
    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage == null ? null : goodsImage.trim();
    }

    /**
     * 获取商品名称
     *
     * @return goods_name - 商品名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 设置商品名称
     *
     * @param goodsName 商品名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * 获取买家 发货时间
     *
     * @return m_deliver_time - 买家 发货时间
     */
    public Date getmDeliverTime() {
        return mDeliverTime;
    }

    /**
     * 设置买家 发货时间
     *
     * @param mDeliverTime 买家 发货时间
     */
    public void setmDeliverTime(Date mDeliverTime) {
        this.mDeliverTime = mDeliverTime;
    }

    /**
     * 获取买家 物流公司CODE
     *
     * @return m_logistics_code - 买家 物流公司CODE
     */
    public String getmLogisticsCode() {
        return mLogisticsCode;
    }

    /**
     * 设置买家 物流公司CODE
     *
     * @param mLogisticsCode 买家 物流公司CODE
     */
    public void setmLogisticsCode(String mLogisticsCode) {
        this.mLogisticsCode = mLogisticsCode == null ? null : mLogisticsCode.trim();
    }

    /**
     * 获取买家 物流公司名称
     *
     * @return m_logistics_name - 买家 物流公司名称
     */
    public String getmLogisticsName() {
        return mLogisticsName;
    }

    /**
     * 设置买家 物流公司名称
     *
     * @param mLogisticsName 买家 物流公司名称
     */
    public void setmLogisticsName(String mLogisticsName) {
        this.mLogisticsName = mLogisticsName == null ? null : mLogisticsName.trim();
    }

    /**
     * 获取买家 发货单号
     *
     * @return m_logistics_no - 买家 发货单号
     */
    public String getmLogisticsNo() {
        return mLogisticsNo;
    }

    /**
     * 设置买家 发货单号
     *
     * @param mLogisticsNo 买家 发货单号
     */
    public void setmLogisticsNo(String mLogisticsNo) {
        this.mLogisticsNo = mLogisticsNo == null ? null : mLogisticsNo.trim();
    }

    /**
     * 获取用户ID
     *
     * @return member_id - 用户ID
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * 设置用户ID
     *
     * @param memberId 用户ID
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    /**
     * 获取用户名称
     *
     * @return member_name - 用户名称
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * 设置用户名称
     *
     * @param memberName 用户名称
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    /**
     * 获取申请数量
     *
     * @return num - 申请数量
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置申请数量
     *
     * @param num 申请数量
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 获取订单编号
     *
     * @return order_sn - 订单编号
     */
    public String getOrderSn() {
        return orderSn;
    }

    /**
     * 设置订单编号
     *
     * @param orderSn 订单编号
     */
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn == null ? null : orderSn.trim();
    }

    /**
     * 获取订单支付方式返回的交易号
     *
     * @return pay_order_no - 订单支付方式返回的交易号
     */
    public String getPayOrderNo() {
        return payOrderNo;
    }

    /**
     * 设置订单支付方式返回的交易号
     *
     * @param payOrderNo 订单支付方式返回的交易号
     */
    public void setPayOrderNo(String payOrderNo) {
        this.payOrderNo = payOrderNo == null ? null : payOrderNo.trim();
    }

    /**
     * 获取问题描述
     *
     * @return problem_desc - 问题描述
     */
    public String getProblemDesc() {
        return problemDesc;
    }

    /**
     * 设置问题描述
     *
     * @param problemDesc 问题描述
     */
    public void setProblemDesc(String problemDesc) {
        this.problemDesc = problemDesc == null ? null : problemDesc.trim();
    }

    /**
     * 获取申请原因
     *
     * @return reason - 申请原因
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置申请原因
     *
     * @param reason 申请原因
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    /**
     * 获取退还积分
     *
     * @return refund_point - 退还积分
     */
    public Integer getRefundPoint() {
        return refundPoint;
    }

    /**
     * 设置退还积分
     *
     * @param refundPoint 退还积分
     */
    public void setRefundPoint(Integer refundPoint) {
        this.refundPoint = refundPoint;
    }

    /**
     * 获取退款时间
     *
     * @return refund_time - 退款时间
     */
    public Date getRefundTime() {
        return refundTime;
    }

    /**
     * 设置退款时间
     *
     * @param refundTime 退款时间
     */
    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    /**
     * 获取退款方式
     *
     * @return refund_way - 退款方式
     */
    public String getRefundWay() {
        return refundWay;
    }

    /**
     * 设置退款方式
     *
     * @param refundWay 退款方式
     */
    public void setRefundWay(String refundWay) {
        this.refundWay = refundWay == null ? null : refundWay.trim();
    }

    /**
     * 获取店铺ID
     *
     * @return store_id - 店铺ID
     */
    public String getStoreId() {
        return storeId;
    }

    /**
     * 设置店铺ID
     *
     * @param storeId 店铺ID
     */
    public void setStoreId(String storeId) {
        this.storeId = storeId == null ? null : storeId.trim();
    }

    /**
     * 获取店铺名称
     *
     * @return store_name - 店铺名称
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * 设置店铺名称
     *
     * @param storeName 店铺名称
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    /**
     * 获取售后单状态
     *
     * @return service_status - 售后单状态
     */
    public String getServiceStatus() {
        return serviceStatus;
    }

    /**
     * 设置售后单状态
     *
     * @param serviceStatus 售后单状态
     */
    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus == null ? null : serviceStatus.trim();
    }

    /**
     * 获取售后类型
     *
     * @return service_type - 售后类型
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * 设置售后类型
     *
     * @param serviceType 售后类型
     */
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    /**
     * 获取货品ID
     *
     * @return sku_id - 货品ID
     */
    public String getSkuId() {
        return skuId;
    }

    /**
     * 设置货品ID
     *
     * @param skuId 货品ID
     */
    public void setSkuId(String skuId) {
        this.skuId = skuId == null ? null : skuId.trim();
    }

    /**
     * 获取售后服务单号
     *
     * @return sn - 售后服务单号
     */
    public String getSn() {
        return sn;
    }

    /**
     * 设置售后服务单号
     *
     * @param sn 售后服务单号
     */
    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    /**
     * 获取交易编号
     *
     * @return trade_sn - 交易编号
     */
    public String getTradeSn() {
        return tradeSn;
    }

    /**
     * 设置交易编号
     *
     * @param tradeSn 交易编号
     */
    public void setTradeSn(String tradeSn) {
        this.tradeSn = tradeSn == null ? null : tradeSn.trim();
    }

    /**
     * 获取订单货物编号
     *
     * @return order_item_sn - 订单货物编号
     */
    public String getOrderItemSn() {
        return orderItemSn;
    }

    /**
     * 设置订单货物编号
     *
     * @param orderItemSn 订单货物编号
     */
    public void setOrderItemSn(String orderItemSn) {
        this.orderItemSn = orderItemSn == null ? null : orderItemSn.trim();
    }

    /**
     * 获取规格json
     *
     * @return specs - 规格json
     */
    public String getSpecs() {
        return specs;
    }

    /**
     * 设置规格json
     *
     * @param specs 规格json
     */
    public void setSpecs(String specs) {
        this.specs = specs == null ? null : specs.trim();
    }
}