package com.scorpion.entity;

import lombok.*;

import java.util.Date;
import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "iu_search_history")
public class IuSearchHistory {
    @Id
    private Integer id;

    /**
     * 用户表的用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 搜索关键字
     */
    @Column(name = "keyword")
    private String keyword;

    /**
     * 搜索来源，如pc、wx、app
     */
    @Column(name = "from_name")
    private String fromName;

    /**
     * 搜索关键词次数
     */
    @Column(name = "number")
    private Integer number;

    /**
     * 创建时间
     */
    @Column(name = "add_time")
    private Date addTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 逻辑删除
     */
    @Column(name = "deleted")
    private Boolean deleted;

}