package com.scorpion.service.impl;



import com.scorpion.entity.IuSearchHistory;
import com.scorpion.mapper.IuSearchHistoryMapper;
import com.scorpion.service.IuSearchHistoryService;
import com.scorpion.vo.ResponseStatus;
import com.scorpion.vo.ResultVo;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;


/**
 * @author scorpion
 * @date 2022/4/21
 */
@Service
public class IuSearchHistoryServiceImpl implements IuSearchHistoryService {
    @Resource
    private IuSearchHistoryMapper iuSearchHistoryMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public ResultVo listSearchHistory(int userId, int start, int end) {
        ResultVo resultVo = null;
        try {
            List<String> list = new ArrayList<>();
            Set<ZSetOperations.TypedTuple<String>> searchHistory = stringRedisTemplate.opsForZSet().reverseRangeWithScores(String.valueOf(userId), start, end);
            if (!searchHistory.isEmpty()) {
                Iterator<ZSetOperations.TypedTuple<String>> iterator = searchHistory.iterator();
                while (iterator.hasNext()) {
                    ZSetOperations.TypedTuple<String> next = iterator.next();
                    list.add(next.getValue().toString());
                }
                resultVo = new ResultVo(ResponseStatus.success, "list success", list);
            } else {
                List<IuSearchHistory> iuSearchHistories = iuSearchHistoryMapper.selectSearchHistoryByUserId(userId);
                if (iuSearchHistories.size() > 0) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    for (IuSearchHistory item : iuSearchHistories) {
                        list.add(item.getKeyword());
                        Date parse = simpleDateFormat.parse(simpleDateFormat.format(item.getUpdateTime()));
                        stringRedisTemplate.opsForZSet().add(String.valueOf(userId), item.getKeyword(), parse.getTime());
                    }
                }
                resultVo=new ResultVo(ResponseStatus.success, "list success", list);
            }
        }catch (ParseException e){
            e.printStackTrace();
        }
        return resultVo;
    }

    @Override
    @Transactional
    public ResultVo saveSearchHistory(int userId, int top, String keyWord) {
        if(keyWord!=null&&!"".equals(keyWord)) {
            String uId = String.valueOf(userId);
            Double score = stringRedisTemplate.opsForZSet().score(uId, keyWord);
            if (score != null) {
                stringRedisTemplate.opsForZSet().remove(uId, keyWord);
            }
            stringRedisTemplate.opsForZSet().add(uId, keyWord, System.currentTimeMillis());
            stringRedisTemplate.boundZSetOps(uId).expire(1, TimeUnit.DAYS);
            Long aLong = stringRedisTemplate.opsForZSet().zCard(uId);
            //  查询数据库是否有该关键词
            Example example = new Example(IuSearchHistory.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("userId", userId)
                    .andEqualTo("keyword", keyWord);
            List<IuSearchHistory> iuSearchHistories = iuSearchHistoryMapper.selectByExample(example);
            if (iuSearchHistories.size() > 0) {
                int number = iuSearchHistories.get(0).getNumber() + 1;
                IuSearchHistory iuSearchHistory = IuSearchHistory.builder()
                        .id(iuSearchHistories.get(0).getId())
                        .userId(userId)
                        .keyword(keyWord)
                        .number(number)
                        .updateTime(new Date())
                        .deleted(Boolean.FALSE)
                        .build();
                iuSearchHistoryMapper.updateByPrimaryKeySelective(iuSearchHistory);
            } else {
                IuSearchHistory history = IuSearchHistory.builder()
                        .userId(userId)
                        .keyword(keyWord)
                        .fromName("wx")
                        .number(1)
                        .addTime(new Date())
                        .updateTime(new Date())
                        .deleted(Boolean.FALSE)
                        .build();
                int i = iuSearchHistoryMapper.insertSelective(history);
            }
            if (aLong > top) {
                stringRedisTemplate.opsForZSet().removeRange(uId, 0, aLong - top - 1);
            }
        }
        return new ResultVo(ResponseStatus.success,"save success",null);
    }

    @Override
    @Transactional
    public ResultVo deleteSearchHistoryBuKeyword(int userId,String keyword) {
        ResultVo resultVo=null;
        stringRedisTemplate.opsForZSet().remove(String.valueOf(userId),keyword);
        int i = iuSearchHistoryMapper.updateDeletedStatus(userId, keyword, 1);
        if(i>0){
            resultVo=new ResultVo(ResponseStatus.success,"delete success",null);
        }
        return resultVo;
    }

    @Override
    @Transactional
    public ResultVo deleteAll(int userId) {
        ResultVo resultVo=null;
        String uId=String.valueOf(userId);
        Long aLong = stringRedisTemplate.opsForZSet().zCard(uId);
        stringRedisTemplate.opsForZSet().removeRange(uId,0,aLong);
        int i = iuSearchHistoryMapper.updateDeletedAllStatus(userId, 1);
        if(i>0){
            resultVo=new ResultVo(ResponseStatus.success,"remove all success",null);
        }
        return resultVo;
    }
}
