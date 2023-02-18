package com.scorpion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Users implements Serializable {
    public Users() {
    }

    public Users(Integer userId, String userName, String nickName, String userIntro, String avatra, String email, String phoneNumber, String userSex, Date userBirthday, String userPassword, String passwordSalt, String userStatus, Integer userScore, BigDecimal totalCostAmt, Date lastLoginTime, String openId, String unionId, String createdBy, Date createdTime, String updatedBy, Date updatedTime) {
        this.userId = userId;
        this.userName = userName;
        this.nickName = nickName;
        this.userIntro = userIntro;
        this.avatra = avatra;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userSex = userSex;
        this.userBirthday = userBirthday;
        this.userPassword = userPassword;
        this.passwordSalt = passwordSalt;
        this.userStatus = userStatus;
        this.userScore = userScore;
        this.totalCostAmt = totalCostAmt;
        this.lastLoginTime = lastLoginTime;
        this.openId = openId;
        this.unionId = unionId;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
        this.updatedBy = updatedBy;
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userIntro='" + userIntro + '\'' +
                ", avatra='" + avatra + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBirthday=" + userBirthday +
                ", userPassword='" + userPassword + '\'' +
                ", passwordSalt='" + passwordSalt + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", userScore=" + userScore +
                ", totalCostAmt=" + totalCostAmt +
                ", lastLoginTime=" + lastLoginTime +
                ", openId='" + openId + '\'' +
                ", unionId='" + unionId + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdTime=" + createdTime +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedTime=" + updatedTime +
                '}';
    }

    /**
     * 用户ID
     */
    @Id
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户名称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 个性签名
     */
    @Column(name = "user_intro")
    private String userIntro;

    /**
     * 头像图片
     */
    private String avatra;

    /**
     * 邮件地址
     */
    private String email;

    /**
     * 手机号
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 性别
     */
    @Column(name = "user_sex")
    private String userSex;

    /**
     * 生日
     */
    @Column(name = "user_birthday")
    private Date userBirthday;

    /**
     * 密码
     */
    @Column(name = "user_password")
    private String userPassword;

    /**
     * 密码盐
     */
    @Column(name = "password_salt")
    private String passwordSalt;

    /**
     * 用户状态
     */
    @Column(name = "user_status")
    private String userStatus;

    /**
     * 用户打分
     */
    @Column(name = "user_score")
    private Integer userScore;

    /**
     * 累计消费金额
     */
    @Column(name = "total_cost_amt")
    private BigDecimal totalCostAmt;

    /**
     * 最后登录时间
     */
    @Column(name = "last_login_time")
    private Date lastLoginTime;

    /**
     * 微信登录唯一标识
     */
    @Column(name = "open_id")
    private String openId;

    @Column(name = "union_id")
    private String unionId;

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
     * 更新人
     */
    @Column(name = "updated_by")
    private String updatedBy;

    /**
     * 更新时间
     */
    @Column(name = "updated_time")
    private Date updatedTime;

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名称
     *
     * @return user_name - 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名称
     *
     * @param userName 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取用户昵称
     *
     * @return nick_name - 用户昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置用户昵称
     *
     * @param nickName 用户昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 获取个性签名
     *
     * @return user_intro - 个性签名
     */
    public String getUserIntro() {
        return userIntro;
    }

    /**
     * 设置个性签名
     *
     * @param userIntro 个性签名
     */
    public void setUserIntro(String userIntro) {
        this.userIntro = userIntro == null ? null : userIntro.trim();
    }

    /**
     * 获取头像图片
     *
     * @return avatra - 头像图片
     */
    public String getAvatra() {
        return avatra;
    }

    /**
     * 设置头像图片
     *
     * @param avatra 头像图片
     */
    public void setAvatra(String avatra) {
        this.avatra = avatra == null ? null : avatra.trim();
    }

    /**
     * 获取邮件地址
     *
     * @return email - 邮件地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮件地址
     *
     * @param email 邮件地址
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取手机号
     *
     * @return phone_number - 手机号
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置手机号
     *
     * @param phoneNumber 手机号
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * 获取性别
     *
     * @return user_sex - 性别
     */
    public String getUserSex() {
        return userSex;
    }

    /**
     * 设置性别
     *
     * @param userSex 性别
     */
    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    /**
     * 获取生日
     *
     * @return user_birthday - 生日
     */
    public Date getUserBirthday() {
        return userBirthday;
    }

    /**
     * 设置生日
     *
     * @param userBirthday 生日
     */
    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    /**
     * 获取密码
     *
     * @return user_password - 密码
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 设置密码
     *
     * @param userPassword 密码
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    /**
     * 获取密码盐
     *
     * @return password_salt - 密码盐
     */
    public String getPasswordSalt() {
        return passwordSalt;
    }

    /**
     * 设置密码盐
     *
     * @param passwordSalt 密码盐
     */
    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt == null ? null : passwordSalt.trim();
    }

    /**
     * 获取用户状态
     *
     * @return user_status - 用户状态
     */
    public String getUserStatus() {
        return userStatus;
    }

    /**
     * 设置用户状态
     *
     * @param userStatus 用户状态
     */
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus == null ? null : userStatus.trim();
    }

    /**
     * 获取用户打分
     *
     * @return user_score - 用户打分
     */
    public Integer getUserScore() {
        return userScore;
    }

    /**
     * 设置用户打分
     *
     * @param userScore 用户打分
     */
    public void setUserScore(Integer userScore) {
        this.userScore = userScore;
    }

    /**
     * 获取累计消费金额
     *
     * @return total_cost_amt - 累计消费金额
     */
    public BigDecimal getTotalCostAmt() {
        return totalCostAmt;
    }

    /**
     * 设置累计消费金额
     *
     * @param totalCostAmt 累计消费金额
     */
    public void setTotalCostAmt(BigDecimal totalCostAmt) {
        this.totalCostAmt = totalCostAmt;
    }

    /**
     * 获取最后登录时间
     *
     * @return last_login_time - 最后登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    /**
     * 设置最后登录时间
     *
     * @param lastLoginTime 最后登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
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
     * 获取更新人
     *
     * @return updated_by - 更新人
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
     * @return updated_time - 更新时间
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