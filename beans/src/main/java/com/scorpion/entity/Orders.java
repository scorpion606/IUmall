package com.scorpion.entity;

import lombok.Builder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
@Builder
public class Orders implements Serializable {
    public Orders() {
    }

    public Orders(String orderId, Integer userId, String productName, String receiverName, String receiverPhone, String receiverAddress, BigDecimal totalAccount, BigDecimal actualAccount, Integer payType, String orderRemark, String status, String deliveryType, String deliveryFlowId, BigDecimal orderFreight, Integer deleteStatus, Integer revision, String createdBy, Date createdTime, String updatedBy, Date updatedTime, Date payTime, Date deliveryTime, Date finishTime, Date cancelTime, Integer cancelType) {
        this.orderId = orderId;
        this.userId = userId;
        this.productName = productName;
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.receiverAddress = receiverAddress;
        this.totalAccount = totalAccount;
        this.actualAccount = actualAccount;
        this.payType = payType;
        this.orderRemark = orderRemark;
        this.status = status;
        this.deliveryType = deliveryType;
        this.deliveryFlowId = deliveryFlowId;
        this.orderFreight = orderFreight;
        this.deleteStatus = deleteStatus;
        this.revision = revision;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
        this.updatedBy = updatedBy;
        this.updatedTime = updatedTime;
        this.payTime = payTime;
        this.deliveryTime = deliveryTime;
        this.finishTime = finishTime;
        this.cancelTime = cancelTime;
        this.cancelType = cancelType;
    }

    /**
     * 订单主键ID
     */
    @Id
    @Column(name = "order_id")
    private String orderId;


    /**
     * 用户外键ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 产品名称(多个产品用,隔开)
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 收货人快照
     */
    @Column(name = "receiver_name")
    private String receiverName;

    /**
     * 收货人手机号码快照
     */
    @Column(name = "receiver_phone")
    private String receiverPhone;

    /**
     * 收货地址快照
     */
    @Column(name = "receiver_address")
    private String receiverAddress;

    /**
     * 订单总价格
     */
    @Column(name = "total_account")
    private BigDecimal totalAccount;

    /**
     * 实际支付总价格
     */
    @Column(name = "actual_account")
    private BigDecimal actualAccount;

    /**
     * 支付方式
     */
    @Column(name = "pay_type")
    private Integer payType;

    /**
     * 订单备注
     */
    @Column(name = "order_remark")
    private String orderRemark;

    /**
     * 订单状态1,待支付2,待发货3,待收货4,待评价5,已关闭
     */
    private String status;

    /**
     * 配送方式
     */
    @Column(name = "delivery_type")
    private String deliveryType;

    /**
     * 物流单号
     */
    @Column(name = "delivery_flow_id")
    private String deliveryFlowId;

    /**
     * 订单运费
     */
    @Column(name = "order_freight")
    private BigDecimal orderFreight;

    /**
     * 逻辑删除状态
     */
    @Column(name = "delete_status")
    private Integer deleteStatus;

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
     * 创建时间(成交时间)
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
     * 付款时间
     */
    @Column(name = "pay_time")
    private Date payTime;

    /**
     * 发货时间
     */
    @Column(name = "delivery_time")
    private Date deliveryTime;

    /**
     * 完成时间
     */
    @Column(name = "finish_time")
    private Date finishTime;

    /**
     * 取消时间
     */
    @Column(name = "cancel_time")
    private Date cancelTime;

    /**
     * 订单关闭类型1,超时未支付2,退款关闭3,买家取消4,已通过货到付款交易
     */
    @Column(name = "cancel_type")
    private Integer cancelType;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public BigDecimal getTotalAccount() {
        return totalAccount;
    }

    public void setTotalAccount(BigDecimal totalAccount) {
        this.totalAccount = totalAccount;
    }

    public BigDecimal getActualAccount() {
        return actualAccount;
    }

    public void setActualAccount(BigDecimal actualAccount) {
        this.actualAccount = actualAccount;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getDeliveryFlowId() {
        return deliveryFlowId;
    }

    public void setDeliveryFlowId(String deliveryFlowId) {
        this.deliveryFlowId = deliveryFlowId;
    }

    public BigDecimal getOrderFreight() {
        return orderFreight;
    }

    public void setOrderFreight(BigDecimal orderFreight) {
        this.orderFreight = orderFreight;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public Integer getCancelType() {
        return cancelType;
    }

    public void setCancelType(Integer cancelType) {
        this.cancelType = cancelType;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId='" + orderId + '\'' +
                ", userId=" + userId +
                ", productName='" + productName + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", receiverPhone='" + receiverPhone + '\'' +
                ", receiverAddress='" + receiverAddress + '\'' +
                ", totalAccount=" + totalAccount +
                ", actualAccount=" + actualAccount +
                ", payType=" + payType +
                ", orderRemark='" + orderRemark + '\'' +
                ", status='" + status + '\'' +
                ", deliveryType='" + deliveryType + '\'' +
                ", deliveryFlowId='" + deliveryFlowId + '\'' +
                ", orderFreight=" + orderFreight +
                ", deleteStatus=" + deleteStatus +
                ", revision=" + revision +
                ", createdBy='" + createdBy + '\'' +
                ", createdTime=" + createdTime +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedTime=" + updatedTime +
                ", payTime=" + payTime +
                ", deliveryTime=" + deliveryTime +
                ", finishTime=" + finishTime +
                ", cancelTime=" + cancelTime +
                ", cancelType=" + cancelType +
                '}';
    }
}