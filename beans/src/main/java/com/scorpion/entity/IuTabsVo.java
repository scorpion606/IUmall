package com.scorpion.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author scorpion
 * @date 2022/7/8
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class IuTabsVo implements Serializable {
    /**
     * 导航标签id
     */
    @Id
    private Integer id;

    /**
     * 标签名字
     */
    private String name;

    /**
     * 滑块背景图
     */
    @Column(name = "line_bg")
    private String lineBg;

    /**
     * 标签顺序
     */
    @Column(name = "seq")
    private Integer seq;

    @Column(name = "collect_name")
    private String collectName;

    @Column(name="is_collect")
    private Boolean isCollect;
    /**
     * 是否启动（0：启动，1未启动）
     */
    private Integer status;

    /**
     * 逻辑删除（0：未删除，1：已删除）
     */
    private Integer deleted;

    /**
     * 创建人姓名
     */
    @Column(name = "created_by")
    private String createdBy;

    /**
     * 创建时间
     */
    @Column(name = "creted_time")
    private Date cretedTime;

    /**
     * 修改人姓名
     */
    @Column(name = "updated_by")
    private String updatedBy;

    /**
     * 修改时间
     */
    @Column(name = "updated_time")
    private Date updatedTime;

    private List<IuCollect> collects;
}
