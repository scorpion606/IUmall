package com.scorpion.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * @author scorpion
 * @date 2022/4/3
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@ApiModel(value = "com.scorpion.vo.WxAuth",description = "微信认证对象")
public class WxAuth implements Serializable {


    @ApiModelProperty(value = "encryptedData")
    private String encryptedData;
    @ApiModelProperty(value = "iv")
    private String iv;
    @ApiModelProperty(value="code")
    private String code;
}
