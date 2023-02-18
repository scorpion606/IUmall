package com.scorpion.controller;

import com.github.wxpay.sdk.WXPayUtil;
import com.scorpion.service.OrderService;
import com.scorpion.websocket.WebSocketServer;
import com.sun.media.sound.SoftTuning;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author scorpion
 * @date 2021/12/7
 */
@Api(tags = "支付回调接口",value ="提供支付回调相关接口")
@RestController
@CrossOrigin
@RequestMapping(value = "/pay")
public class PayController {
    @Resource
    private OrderService orderService;


    @RequestMapping(value="/success")
    public String Pay(HttpServletRequest request)throws Exception{
        //获取输入流
        ServletInputStream inputStream = request.getInputStream();
        byte[] bytes = new byte[1024];
        int len=-1;
        StringBuilder stringBuilder = new StringBuilder();
        while((len=inputStream.read(bytes))!=-1){
            stringBuilder.append(new String(bytes,0,len));
        }
        String s = stringBuilder.toString();
        //使用微信帮助类将xml数据转化为map集合
        Map<String, String> map = WXPayUtil.xmlToMap(s);
        if(map!=null && "SUCCESS".equalsIgnoreCase(map.get("result_code"))){
            //支付成功
            //1，修改订单状态为已支付/已发货
            //获取订单号
            String orderId=map.get("out_trade_no");
            int i = orderService.updateOrderStatus(orderId, "2");

            //支付成功通过websocket发送支付成功信息
            WebSocketServer.sendMsg(orderId,"1");
            if(i>0) {
                //2，响应微信支付平台
                HashMap<String, String> responseMap = new HashMap<>();
                //响应返回码
                responseMap.put("return_code", "SUCCESS");
                //响应返回信息
                responseMap.put("return_msg", "OK");
                //响应appid
                responseMap.put("appid", map.get("appid"));
                //响应结果码
                responseMap.put("result_code", "SUCCESS");
                //将map集合转化为xml文件响应给微信平台
                String mapToXml = WXPayUtil.mapToXml(responseMap);
                return mapToXml;
            }
        }
        return null;
    }
}
