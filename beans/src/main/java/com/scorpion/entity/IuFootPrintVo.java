package com.scorpion.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author scorpion
 * @date 2022/7/1
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class IuFootPrintVo implements Serializable {

    private Integer id;

    /**
     * 用户表的用户ID
     */

    private Integer userId;

    /**
     * 浏览商品ID
     */

    private Integer goodsId;

    /**
     * 创建时间
     */

    private Date addTime;

    /**
     * 更新时间
     */

    private Date updateTime;

    /**
     * 逻辑删除
     */

    private Boolean deleted;

    private ProductVo productVos;
}
