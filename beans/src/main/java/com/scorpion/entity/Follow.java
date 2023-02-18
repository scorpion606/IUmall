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
@Table(name = "iu_follow")
public class Follow {
    /**
     * follow表主键
     */
    @Id
    private Integer id;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 关注人ID
     */
    @Column(name = "followed_id")
    private Integer followedId;

    /**
     * 关注状态，0 未关注  1 已关注
     */
    @Column(name="status")
    private Boolean status;

    /**
     * 特别关注，0 不是特别关注  1 是特别关注
     */
    @Column(name = "special attention")
    private Boolean specialAttention;

    /**
     * 逻辑删除，0 未删除  1 已删除
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