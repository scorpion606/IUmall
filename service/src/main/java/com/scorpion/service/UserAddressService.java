package com.scorpion.service;

import com.scorpion.entity.UserAddress;
import com.scorpion.vo.ResultVo;

/**
 * @author scorpion
 * @date 2021/12/3
 */
public interface UserAddressService {
    /**
     * 实现通过用户ID查找用户地址，调用tkMapper中的select方法
     * @param token 用户令牌
     * @return 如果查找成功返回ResultVo对象
     */
    public ResultVo selectUserAddress(String token);

    /**
     * 实现通过用户地址ID删除用户地址
     * @param aId 用户地址ID
     * @return 如果删除成功返回ResultVo对象
     */
    public ResultVo deleteUserAddress(int aId);

    /**
     * 实现通过地址ID修改是否是默认地址
     * @param aId 用户地址ID
     * @param DefaultStatus 默认状态（1：是 2：否）
     * @return 如果插入成功返回ResultVo对象
     */
    public ResultVo updateUserAddress(int aId,int DefaultStatus);

    /**
     * 实现插入用户地址信息
     * @param userAddress 用户地址信息对象
     * @param  token 用户令牌
     * @return 如果插入成功返回ResultVo对象
     */
    public ResultVo insertUserAddress(UserAddress userAddress,String token);

    /**
     * 实现更改用户地址的功能
     * @param userAddress 用户地址地址
     * @return 如果修改成功返回ResultVo对象
     */
    public ResultVo updateChooseUserAddress(UserAddress userAddress,String token);
}
