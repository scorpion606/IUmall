package com.scorpion.utils;

import java.util.Base64;

/**
 * @author scorpion
 * @date 2021/10/29
 */
public class Base64Util {
    /**
     * 加密
     * @param msg
     * @return
     */
    public static String encoder(String msg){
        return Base64.getEncoder().encodeToString(msg.getBytes());
    }

    /**
     * 解密
     * @param msg
     * @return
     */
    public static String decode(String msg){
        return new String(Base64.getDecoder().decode(msg));
    }
}
