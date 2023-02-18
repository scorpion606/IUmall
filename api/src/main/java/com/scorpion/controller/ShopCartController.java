package com.scorpion.controller;
import com.scorpion.entity.ShoppingCart;
import com.scorpion.service.ShoppingCartService;

import com.scorpion.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author scorpion
 * @date 2021/11/3
 */
@RestController
@RequestMapping(value="/cart")
@CrossOrigin
@Api(tags = "购物车管理", value ="提供购物车相关业务接口")
public class ShopCartController {
    @Resource
    private ShoppingCartService shoppingCartService;

    @ApiOperation(value = "购物车列表接口")
    @ApiImplicitParams({

            @ApiImplicitParam(dataType = "string",name = "token",value = "授权令牌",required = true)
    })
    @GetMapping(value="/list")
    public ResultVo listCarts(@RequestHeader("token") String token){
        ResultVo resultVo = shoppingCartService.listShoppingCart(token);
        return resultVo;
    }

    @ApiOperation(value = "添加购物车接口")
    @ApiImplicitParams(
            {
              @ApiImplicitParam(dataType = "String",name = "token",value = "授权令牌",required = true)
            }
    )
    @PostMapping(value="/addShoppingCart")
    public ResultVo postShoppingCart(@RequestBody() ShoppingCart cart, @RequestHeader("token") String token){
        ResultVo resultVo = shoppingCartService.addShoppingCart(cart,token);
        return resultVo;
    }

    @ApiOperation(value = "修改商品套餐数量")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Integer", name = "cartId",value="购物车ID" ,required = true),
            @ApiImplicitParam(dataType = "Integer", name = "cartNumber",value="购物车套餐数量" ,required = true),
            @ApiImplicitParam(dataType = "String",name = "token",value = "授权令牌",required = true)
    })
    @PutMapping(value = "/update/cartNum/{cartId}/{cartNumber}")
    public ResultVo putCartNum(@PathVariable("cartId") Integer cartId,
                               @PathVariable("cartNumber") Integer cartNumber,
                               @RequestHeader("token") String token){
        ResultVo resultVo = shoppingCartService.updateCartNumber(cartId, cartNumber);
        return resultVo;
    }

    @ApiOperation(value = "查询选择商品列表接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType="String",name = "cIds",value="购物车ID集合(以逗号隔开)",required = true),
            @ApiImplicitParam(dataType = "String",name = "token",value = "授权令牌",required = true)
    })
    @GetMapping(value = "/listChooseShoppingCart")
    public ResultVo getChooseShoppingCart(String cIds,@RequestHeader("token") String token){
        ResultVo resultVo = shoppingCartService.listChooseShoppingCart(cIds);
        return resultVo;
    }

    @ApiOperation(value = "删除单个商品列表接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Integer",name = "cId",value = "购物车ID",required = true),
            @ApiImplicitParam(dataType = "String",name = "token",value = "授权令牌",required = true)
    })
    @DeleteMapping(value="/deleteChooseShoppingCart/{cId}")
    public ResultVo deleteChooseShoppingCart(@PathVariable("cId") int cId, @RequestHeader("token") String token){
        ResultVo resultVo = shoppingCartService.deleteChooseShoppingCart(cId);
        return resultVo;

    }

    @ApiOperation(value="删除勾选的全部商品")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "ArrayList",name = "cIds",value ="购物车ID集合",required = true),
            @ApiImplicitParam(dataType = "String",name = "token",value = "授权令牌",required = true)
    })
    @DeleteMapping("/deleteChooseAll")
    public ResultVo deleteChooseAll(@RequestBody List<Integer> cIds,@RequestHeader("token") String token){
        ResultVo resultVo = shoppingCartService.deleteChooseAll(cIds);
        return resultVo;
    }

    @ApiOperation(value = "修改购物车勾选状态")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name = "token",value = "授权令牌",required = true)
    }
    )
    @PutMapping("/updateCartStatus/{cartId}/{status}")
    public ResultVo putCartStatus(@PathVariable("cartId") int cartId,@PathVariable("status") int status,@RequestHeader("token") String token){
        ResultVo resultVo = shoppingCartService.updateCartStatus(cartId, status);
        return resultVo;
    }
}
