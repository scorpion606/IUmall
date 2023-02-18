package com.scorpion.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author scorpion
 * @date 2021/10/6
 */
@ApiModel(value ="ResultVo对象",description = "封装响应给前端的数据")
public class ResultVo implements Serializable {
    //状态码
    @ApiModelProperty(dataType = "int",name = "code",value = "响应状态码",required = true)
    private int code;
    //响应给前端的信息
    @ApiModelProperty(dataType = "string",name = "message",value = "响应提示信息",required = true)
    private String message;
    //响应给前端的数据
    @ApiModelProperty(dataType = "object",name = "data",value = "响应数据",required = true)
    private Object data;

    public ResultVo() {
    }

    public ResultVo(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
