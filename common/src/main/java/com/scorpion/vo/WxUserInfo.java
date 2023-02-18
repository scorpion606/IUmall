package com.scorpion.vo;

import lombok.*;

/**
 * @author scorpion
 * @date 2022/4/3
 */
@Data
public class WxUserInfo {
    private String openId;
    private String nickName;
    private String gender;
    private String city;
    private String province;
    private String country;
    private String avatarUrl;
    private String unionId;
}
