package com.scorpion.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @author scorpion
 * @date 2022/10/16
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class DynamicVo implements Serializable {
    /**
     * 动态表ID主键
     */
    private Integer id;
    /**
     * 动态标题
     */
    private String dynamicName;
    /**
     * 点赞量
     */
    private Integer praiseTotal;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 图片地址
     */
    private String url;
}
