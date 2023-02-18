package com.scorpion.mapper;

import com.scorpion.entity.UserVO;
import com.scorpion.entity.Users;
import com.scorpion.generator.BaseMapper;

import java.util.List;


public interface UsersMapper extends BaseMapper<Users> {
    /**
     * 查找用户列表
     * @param list 我的关注ID
     * @return 以List集合返回ResultVO对象
     */
    List<UserVO> selectList(List<Integer> list);

    List<UserVO> selectListBykeyWord(List<Integer> list,String keyWord);
}