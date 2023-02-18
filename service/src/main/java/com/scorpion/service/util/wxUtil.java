package com.scorpion.service.util;

import cn.hutool.core.codec.Base64;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;

/**
 * @author scorpion
 * @date 2022/4/2
 */
@Component
public class wxUtil {
    @Resource
    private StringRedisTemplate stringRedisTemplate;


    public  String wxDecrypt(String res,String encryptedData, String vi)throws Exception{
//        开始解密

        JSONObject jsonObject = JSON.parseObject(res);
        String sessionKey = (String)jsonObject.get("session_key");
        byte[] encData = cn.hutool.core.codec.Base64.decode(encryptedData);
        byte[] iv = cn.hutool.core.codec.Base64.decode(vi);
        byte[] key = Base64.decode(sessionKey);
        AlgorithmParameterSpec ivSpec = new IvParameterSpec(iv);
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding","BC");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.DECRYPT_MODE,keySpec,ivSpec);
        return new String(cipher.doFinal(encData),"UTF-8");
    }

}
