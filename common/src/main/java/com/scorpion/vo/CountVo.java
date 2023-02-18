package com.scorpion.vo;

import lombok.*;

/**
 * @author scorpion
 * @date 2022/10/4
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CountVo {
    private Long dynamicsCount;
    private Long followCount;
    private Long FansCount;
}
