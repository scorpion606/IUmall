package com.scorpion.vo;

import lombok.*;

import java.util.List;

/**
 * @author scorpion
 * @date 2021/11/27
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Page<T> {

    /**
     * 总记录数
     */
    private Integer count;
    /**
     * 总页数
     */
    private Integer pageCount;
    /**
     * 分页数据
     */
    private Object list;


}
