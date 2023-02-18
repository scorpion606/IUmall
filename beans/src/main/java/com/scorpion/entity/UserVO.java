package com.scorpion.entity;

import lombok.*;

/**
 * @author scorpion
 * @date 2022/10/5
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class UserVO {
    private Integer userId;
    private String nickName;
    private String userIntro;
    private String avatra;
    
}
