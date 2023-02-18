package com.scorpion.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_login_history")
public class UserLoginHistory implements Serializable {
    @Override
    public String toString() {
        return "UserLoginHistory{" +
                "id=" + id +
                ", userId=" + userId +
                ", area='" + area + '\'' +
                ", country='" + country + '\'' +
                ", ip='" + ip + '\'' +
                ", loginTime=" + loginTime +
                '}';
    }

    /**
     * 登录历史主键ID
     */
    @Id
    private Integer id;

    /**
     * 用户外键ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 地区
     */
    private String area;

    /**
     * 国家
     */
    private String country;

    /**
     * IP
     */
    @Column(name = "IP")
    private String ip;

    /**
     * 登录时间
     */
    @Column(name = "login_time")
    private Date loginTime;

    /**
     * 获取登录历史主键ID
     *
     * @return id - 登录历史主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置登录历史主键ID
     *
     * @param id 登录历史主键ID
     */
    public void setId(Integer id) {
        this.id = id;
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
     * 获取地区
     *
     * @return area - 地区
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置地区
     *
     * @param area 地区
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * 获取国家
     *
     * @return country - 国家
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置国家
     *
     * @param country 国家
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * 获取IP
     *
     * @return IP - IP
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置IP
     *
     * @param ip IP
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * 获取登录时间
     *
     * @return login_time - 登录时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 设置登录时间
     *
     * @param loginTime 登录时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}