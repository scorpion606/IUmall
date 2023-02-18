package com.scorpion.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "iu_fans")
public class Fans {
    /**
     * fans表主键
     */
    @Id
    private Integer id;

    /**
     * 用户外键
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 粉丝外键
     */
    @Column(name = "follower_id")
    private Integer followerId;

    /**
     * 关注状态，0 未关注  1 已关注
     */
    private Boolean status;

    /**
     * 逻辑删除，0 未删除  已删除
     */
    private Boolean deleted;

    /**
     * 添加时间
     */
    @Column(name = "add_time")
    private Date addTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;


}