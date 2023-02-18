package com.scorpion.vo;

/**
 * @author scorpion
 * @date 2021/10/27
 */
public class ResponseStatus {
    public static final Integer success=10000;
    public static final Integer fail=10001;
    /**
     * 登录认证成功
     */
    public static final Integer LOGIN_SUCCESS=20000;
    /**
     * 登录认证失败
     */
    public  static final Integer LOGIN_FAIL=20001;
    /**
     * 登录认证过期
     */
    public static final Integer LOGIN_EXPIRED=20002;
    /**
     * token不合法
     */
    public static final Integer LOGIN_ILLEGAL=20003;

    /**
     * 商品套餐库存不足
     */
    public static final Integer STOCK_LESS=30001;

}
