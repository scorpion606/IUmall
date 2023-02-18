package com.scorpion.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_address")
public class UserAddress implements Serializable {
    @Override
    public String toString() {
        return "UserAddress{" +
                "addressId=" + addressId +
                ", userId=" + userId +
                ", receiverName='" + receiverName + '\'' +
                ", receiverNumber='" + receiverNumber + '\'' +
                ", seqNumber=" + seqNumber +
                ", campus='" + campus + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                ", dormitoryNumber='" + dormitoryNumber + '\'' +
                ", addressDetails='" + addressDetails + '\'' +
                ", status=" + status +
                ", defaultAddress=" + defaultAddress +
                ", createdBy='" + createdBy + '\'' +
                ", createdTime=" + createdTime +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedTime=" + updatedTime +
                '}';
    }

    /**
     * 用户地址主键ID
     */
    @Id
    @Column(name = "address_id")
    private Integer addressId;

    /**
     * 用户外键ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 收件人姓名
     */
    @Column(name = "receiver_name")
    private String receiverName;

    /**
     * 收件人号码
     */
    @Column(name = "receiver_number")
    private String receiverNumber;

    /**
     * 顺序号
     */
    @Column(name = "seq_number")
    private Integer seqNumber;

    /**
     * 校区
     */
    private String campus;

    /**
     * 宿舍楼号
     */
    @Column(name = "building_number")
    private String buildingNumber;

    /**
     * 寝室号码
     */
    @Column(name = "dormitory_number")
    private String dormitoryNumber;

    /**
     * 详细地址
     */
    @Column(name = "address_details")
    private String addressDetails;

    /**
     * 状态，正常1,0无效
     */
    private Integer status;

    /**
     * 是否默认地址，1是
     */
    @Column(name = "default_address")
    private Integer defaultAddress;

    /**
     * 创建人
     */
    @Column(name = "CREATED_BY")
    private String createdBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "UPDATED_TIME")
    private Date updatedTime;

    /**
     * 获取用户地址主键ID
     *
     * @return address_id - 用户地址主键ID
     */
    public Integer getAddressId() {
        return addressId;
    }

    /**
     * 设置用户地址主键ID
     *
     * @param addressId 用户地址主键ID
     */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    /**
     * 获取用户外键ID
     *
     * @return user_id - 用户外键ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户外键ID
     *
     * @param userId 用户外键ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取收件人姓名
     *
     * @return receiver_name - 收件人姓名
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * 设置收件人姓名
     *
     * @param receiverName 收件人姓名
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    /**
     * 获取收件人号码
     *
     * @return receiver_number - 收件人号码
     */
    public String getReceiverNumber() {
        return receiverNumber;
    }

    /**
     * 设置收件人号码
     *
     * @param receiverNumber 收件人号码
     */
    public void setReceiverNumber(String receiverNumber) {
        this.receiverNumber = receiverNumber == null ? null : receiverNumber.trim();
    }

    /**
     * 获取顺序号
     *
     * @return seq_number - 顺序号
     */
    public Integer getSeqNumber() {
        return seqNumber;
    }

    /**
     * 设置顺序号
     *
     * @param seqNumber 顺序号
     */
    public void setSeqNumber(Integer seqNumber) {
        this.seqNumber = seqNumber;
    }

    /**
     * 获取校区
     *
     * @return campus - 校区
     */
    public String getCampus() {
        return campus;
    }

    /**
     * 设置校区
     *
     * @param campus 校区
     */
    public void setCampus(String campus) {
        this.campus = campus == null ? null : campus.trim();
    }

    /**
     * 获取宿舍楼号
     *
     * @return building_number - 宿舍楼号
     */
    public String getBuildingNumber() {
        return buildingNumber;
    }

    /**
     * 设置宿舍楼号
     *
     * @param buildingNumber 宿舍楼号
     */
    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber == null ? null : buildingNumber.trim();
    }

    /**
     * 获取寝室号码
     *
     * @return dormitory_number - 寝室号码
     */
    public String getDormitoryNumber() {
        return dormitoryNumber;
    }

    /**
     * 设置寝室号码
     *
     * @param dormitoryNumber 寝室号码
     */
    public void setDormitoryNumber(String dormitoryNumber) {
        this.dormitoryNumber = dormitoryNumber == null ? null : dormitoryNumber.trim();
    }

    /**
     * 获取详细地址
     *
     * @return address_details - 详细地址
     */
    public String getAddressDetails() {
        return addressDetails;
    }

    /**
     * 设置详细地址
     *
     * @param addressDetails 详细地址
     */
    public void setAddressDetails(String addressDetails) {
        this.addressDetails = addressDetails == null ? null : addressDetails.trim();
    }

    /**
     * 获取状态，正常1,0无效
     *
     * @return status - 状态，正常1,0无效
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态，正常1,0无效
     *
     * @param status 状态，正常1,0无效
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取是否默认地址，1是
     *
     * @return default_address - 是否默认地址，1是
     */
    public Integer getDefaultAddress() {
        return defaultAddress;
    }

    /**
     * 设置是否默认地址，1是
     *
     * @param defaultAddress 是否默认地址，1是
     */
    public void setDefaultAddress(Integer defaultAddress) {
        this.defaultAddress = defaultAddress;
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