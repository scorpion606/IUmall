package com.scorpion.controller;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import com.scorpion.entity.Orders;
import com.scorpion.service.OrderService;
import com.scorpion.service.timerjob.MyPayConfig;
import com.scorpion.vo.ResponseStatus;
import com.scorpion.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author scorpion
 * @date 2021/12/6
 */
@Api(tags = "订单管理",value="提供订单管理相关接口")
@CrossOrigin
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @ApiOperation(value = "保存订单接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "cIds", value = "购物车ID", required = true),
            @ApiImplicitParam(dataType = "String", name = "token", value = "授权令牌", required = true)
    })
    @PostMapping(value = "/addOrder")
    public ResultVo postOrder(String cIds, @RequestBody Orders orders, @RequestHeader(value = "token") String token) {
        ResultVo resultVo = null;
        try {
            resultVo = orderService.addOrder(cIds, orders);

        } catch (SQLException e) {
            resultVo = new ResultVo(ResponseStatus.fail, "保存订单失败!", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultVo;
    }

    @ApiOperation(value = "立即购买保存订单接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "token", value = "授权令牌", required = true)
    })
    @PostMapping("/save/{skuId}/{buyCount}")
    public ResultVo postBuyNowOrder(@RequestBody Orders order,
                                    @PathVariable("skuId") int skuId,
                                    @PathVariable("buyCount") int buyCount,
                                    @RequestHeader("token") String token){
       return orderService.saveOrder(order,skuId,buyCount);
    }

    /**
     * 实现通过订单ID查询订单支付状态
     *
     * @param orderId 订单ID
     * @param token   登录令牌
     * @return 如果查找成功返回ResultVo对象
     */
    @ApiOperation(value = "查询订单支付状态接口")
    @ApiImplicitParams(
            @ApiImplicitParam(dataType = "String", name = "token", value = "授权令牌", required = true)
    )
    @GetMapping(value = "/getOrderStatus/{orderId}")
    public ResultVo getOrderStatus(@PathVariable("orderId") String orderId, @RequestHeader("token") String token) {
        ResultVo resultVo = orderService.ListOrderStatus(orderId);
        return resultVo;
    }

    @ApiOperation(value = "查询订单列表并分页接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "token", value = "授权令牌", required = true),
            @ApiImplicitParam(dataType = "String", name = "status", value = "订单状态", required = false),
            @ApiImplicitParam(dataType = "Integer", name = "pageNum", value = "当前索引", required = true),
            @ApiImplicitParam(dataType = "Integer", name = "limit", value = "每页显示订单数量", required = true)

    })
    @GetMapping(value = "/listOrders")
    public ResultVo getOrders(@RequestHeader("token") String token,  String status, int pageNum, int limit) {
        ResultVo resultVo = orderService.listOrders(token, status, pageNum, limit);
        return resultVo;
    }

    @ApiOperation(value = "查找订单支付信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "token", value = "授权令牌", required = true)
    })
    @GetMapping("/getPayInfo/{orderId}")
    public ResultVo getOrders(@PathVariable("orderId") String orderId, @RequestHeader("token") String token) {

        try {
            ResultVo resultVo = orderService.listOrdersByOrderId(orderId);
            if (resultVo.getData() != null) {
                HashMap<String, Object> orderInfo = (HashMap<String, Object>) resultVo.getData();
                String oId = (String) orderInfo.get("orderId");
                String productName = (String) orderInfo.get("productName");
                int actualAccount = Integer.parseInt(orderInfo.get("totalPrice").toString());
                //实现微信支付
                WXPay wxPay = new WXPay(new MyPayConfig());
                //存储订单信息
                HashMap<String, String> data = new HashMap<>();
                //设置支付商品名称
                data.put("body", productName);
                //设置当前用户的订单号作为交易支付的交易号
                data.put("out_trade_no", oId);
                //设置支付媒介形态，如人民币或者美元
                data.put("fee_type", "CNY");
                //设置支付价格 actualAccount*100+""
                data.put("total_fee", "1");
                //设置交易类型
                data.put("trade_type", "NATIVE");
                //设置支付完成时的回调接口
                data.put("notify_url", "http://rain.gz2vip.91tunnel.com/pay/success");
                //发送请求,返回支付短链接
                Map<String, String> response = wxPay.unifiedOrder(data);
                orderInfo.put("code_url", response.get("code_url"));
                orderInfo.put("package","prepay_id="+response.get("prepay_id"));
                orderInfo.put("signType","MD5");
                orderInfo.put("timeStamp",String.valueOf(System.currentTimeMillis()));
                // 获取随机字符串
                String nonceStr = WXPayUtil.generateNonceStr();
                orderInfo.put("nonceStr",nonceStr);
                // 生成签名
                MyPayConfig pay=new MyPayConfig();
                String sign = WXPayUtil.generateSignature(data, pay.getKey());
                orderInfo.put("paySign",sign);

                return new ResultVo(ResponseStatus.success, "查询订单成功", orderInfo);

            }else{
                return new ResultVo(ResponseStatus.fail,"查询订单失败",null);
            }

        }catch (Exception e){
            return new ResultVo(ResponseStatus.fail,"pay fail",null);
        }
    }

    @ApiOperation(value = "修改订单支付方式接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "token", value = "授权令牌", required = true)
    })
    @PutMapping("/updatePayType/{orderId}/{payType}")
    public ResultVo putPayType(@PathVariable("orderId") String orderId,@PathVariable("payType") int payType,@RequestHeader("token") String token){
        ResultVo resultVo = orderService.updatePayType(orderId, payType);
        return resultVo;
    }

    @ApiOperation(value="删除已取消订单接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "token", value = "授权令牌", required = true)
    })
    @DeleteMapping("/removeOrder/{orderId}")
    public ResultVo deleteOrder(@PathVariable("orderId") String orderId,@RequestHeader("token") String token){
        ResultVo resultVo = orderService.deleteOrder(orderId);
        return resultVo;
    }

    @ApiOperation(value="查找订单详情接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "token", value = "授权令牌", required = true)
    })
    @GetMapping("/getOrderDetail/{oId}")
    public ResultVo getOrderDetail(@PathVariable("oId") String oId,@RequestHeader("token") String token){
        ResultVo resultVo = orderService.listOrdersDetail(oId);
        return resultVo;
    }

    @ApiOperation(value = "查找订单状态数量")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "token", value = "授权令牌", required = true)
    })
    @GetMapping("/getOrderStatusCount")
    public ResultVo getOrderStatusCount(@RequestHeader("token") String token){
        ResultVo resultVo = orderService.listOrderStatusCount(token);
        return resultVo;
    }

}
