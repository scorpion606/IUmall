package com.scorpion.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scorpion.entity.IuFootPrint;
import com.scorpion.entity.IuFootPrintVo;
import com.scorpion.entity.Users;
import com.scorpion.mapper.IuFootPrintMapper;
import com.scorpion.service.IuFootPrintService;
import com.scorpion.vo.ResponseStatus;
import com.scorpion.vo.ResultVo;
import com.scorpion.vo.RedisKey;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author scorpion
 * @date 2022/7/1
 */
@Service
public class IuFootPrintServiceImpl implements IuFootPrintService {
    @Resource
    private IuFootPrintMapper iuFootPrintMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private ObjectMapper objectMapper;

    /**
     *
     * @param token 用户令牌
     * @param productId 商品ID
     * @return 返回ResultVO对象
     */
    @Override
    public ResultVo addFootprint(String token, int productId) {
        ResultVo resultVo=null;
        int i=0;
        try {
            String userJson = stringRedisTemplate.opsForValue().get(RedisKey.token + token);
            Users user = objectMapper.readValue(userJson, Users.class);
            int userId = user.getUserId();
            Date d = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            IuFootPrint footPrint = iuFootPrintMapper.selectOneDayFootPrintByPid(userId, productId,0, simpleDateFormat.format(d));
            if(footPrint!=null) {
                IuFootPrint f = IuFootPrint.builder()
                        .id(footPrint.getId())
                        .updateTime(new Date())
                        .build();
                i = iuFootPrintMapper.updateByPrimaryKeySelective(f);
            }else {
                        IuFootPrint build = IuFootPrint.builder()
                                .userId(userId)
                                .goodsId(productId)
                                .addTime(new Date())
                                .updateTime(new Date())
                                .deleted(Boolean.FALSE)
                                .build();
                        i = iuFootPrintMapper.insert(build);
                 }
            if(i>0){
                resultVo=new ResultVo(ResponseStatus.success,"add success",null);
            }else{
                resultVo=new ResultVo(ResponseStatus.fail,"add fail",null);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return resultVo;
    }

    @Override
    public ResultVo listFootPrint(String token) {
        ResultVo resultVo=null;
        try {
            String userJson = stringRedisTemplate.opsForValue().get(RedisKey.token + token);
            Users user = objectMapper.readValue(userJson, Users.class);
            Integer userId = user.getUserId();

            List<IuFootPrintVo> iuFootPrints = iuFootPrintMapper.selectFootPrintByUserId(userId,0);
            if(iuFootPrints!=null&&iuFootPrints.size()>0){
                resultVo=new ResultVo(ResponseStatus.success,"list success",iuFootPrints);
            }else{
                resultVo=new ResultVo(ResponseStatus.fail,"list fail",null);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return resultVo;
    }

    @Override
    public ResultVo listLessOneDayFootPrint(String token, String date) {
        /**
         * 1、通过token获得redis中的userId
         * 2、调用mapper层的selectLessOneDayFootPrint
         */
        ResultVo resultVo=null;
        try {
            String userJson = stringRedisTemplate.opsForValue().get(RedisKey.token + token);
            Users user = objectMapper.readValue(userJson, Users.class);
            List<IuFootPrintVo> iuFootPrintVoList = iuFootPrintMapper.selectLessOneDayFootPrint(user.getUserId(), 0, date);
            if(iuFootPrintVoList!=null&&iuFootPrintVoList.size()>0){
                resultVo=new ResultVo(ResponseStatus.success,"list success",iuFootPrintVoList);
            }else{
                resultVo=new ResultVo(ResponseStatus.fail,"list fail",null);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return resultVo;
    }
}
