package com.scorpion.service;

import com.scorpion.vo.ResultVo;

/**
 * @author scorpion
 * @date 2021/11/6
 */
public interface IndexImgService {
    /**
     * 获取轮播图信息，调用mapper层的ListIndexImg方法
     * @return 如果查询成功以ResultVo对象形式返回，否则返回null
     */
    public ResultVo ListIndexImg();
}
