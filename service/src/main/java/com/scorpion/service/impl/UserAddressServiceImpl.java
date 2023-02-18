package com.scorpion.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scorpion.entity.UserAddress;
import com.scorpion.entity.Users;
import com.scorpion.mapper.UserAddressMapper;
import com.scorpion.service.UserAddressService;
import com.scorpion.vo.ResponseStatus;
import com.scorpion.vo.ResultVo;
import com.scorpion.vo.RedisKey;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author scorpion
 * @date 2021/12/3
 */
@Service
public class UserAddressServiceImpl implements UserAddressService {
    @Resource
    private UserAddressMapper userAddressMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private ObjectMapper objectMapper;
    @Override
    public ResultVo selectUserAddress(String token) {
        ResultVo resultVo=null;
        String userJson = stringRedisTemplate.opsForValue().get(RedisKey.token + token);
        try {
            Users user = objectMapper.readValue(userJson, Users.class);
            Example example = new Example(UserAddress.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("userId",user.getUserId());
            criteria.andEqualTo("status",1);
            example.setOrderByClause("seq_number asc");
            List<UserAddress> userAddresses = userAddressMapper.selectByExample(example);
            resultVo=new ResultVo(ResponseStatus.success,"list success",userAddresses);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return resultVo;
    }



    @Override
    public ResultVo deleteUserAddress(int aId) {
        UserAddress userAddress = new UserAddress();
        userAddress.setAddressId(aId);
        UserAddress address = userAddressMapper.selectOne(userAddress);
        if(address.getDefaultAddress().equals(1)){
            this.updateUserAddress(aId,0);
        }
        int i = userAddressMapper.updateStatusByAId(aId,0);
        if(i>0){
            return new ResultVo(ResponseStatus.success,"delete success",null);
        }else{
            return new ResultVo(ResponseStatus.fail,"delete fail",null);
        }

    }

    @Override
    public ResultVo updateUserAddress(int aId, int DefaultStatus) {
        UserAddress userAddress = new UserAddress();
        userAddress.setAddressId(aId);
        userAddress.setDefaultAddress(DefaultStatus);
        int i = userAddressMapper.updateByPrimaryKeySelective(userAddress);
        if(i>0){
            return new ResultVo(ResponseStatus.success,"update success",null);
        }else{
            return new ResultVo(ResponseStatus.fail,"update fail",null);
        }
    }

    @Override
    public ResultVo insertUserAddress(UserAddress userAddress,String token) {
        String userJson = stringRedisTemplate.opsForValue().get(RedisKey.token + token);
        try {
            Users user = objectMapper.readValue(userJson, Users.class);
            userAddress.setUserId(user.getUserId());
            userAddress.setCreatedBy(user.getNickName());
            userAddress.setCreatedTime(new Date());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        int insert = userAddressMapper.insertSelective(userAddress);
        if(insert>0){
            return new ResultVo(ResponseStatus.success,"insert success",null);
        }else{
            return new ResultVo(ResponseStatus.fail,"insert fail",null);
        }
    }

    @Override
    public ResultVo updateChooseUserAddress(UserAddress userAddress,String token) {
        int i=0;
        if(userAddress!=null){
            String userJson = stringRedisTemplate.opsForValue().get(RedisKey.token + token);
            try {
                Users user = objectMapper.readValue(userJson, Users.class);
                Example example = new Example(UserAddress.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("userId",user.getUserId())
                        .andEqualTo("status",1);
                List<UserAddress> userAddresses = userAddressMapper.selectByExample(example);
                if(userAddress.getDefaultAddress().equals(1)) {
                    userAddresses.forEach(item -> {
                        if(item.getDefaultAddress().equals(1)){
                            this.updateUserAddress(item.getAddressId(),0);
                        }
                    });
                }
                userAddress.setUpdatedBy(user.getNickName());
                userAddress.setUpdatedTime(new Date());
                i = userAddressMapper.updateByPrimaryKeySelective(userAddress);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        }
        if(i>0){
            return new ResultVo(ResponseStatus.success,"update success",null);
        }else{
            return new ResultVo(ResponseStatus.fail,"update fail",null);
        }
    }
}
