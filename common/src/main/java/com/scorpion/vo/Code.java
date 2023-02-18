package com.scorpion.vo;

import lombok.*;

import java.io.Serializable;

/**
 * @author scorpion
 * @date 2022/9/28
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Code implements Serializable {
    private String session_key;
    private String openid;
}
