package com.scorpion.service.impl;

import com.scorpion.entity.DtsRegionVO;
import com.scorpion.mapper.DtsRegionMapper;
import com.scorpion.service.DtsRegionService;
import com.scorpion.vo.ResponseStatus;
import com.scorpion.vo.ResultVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author scorpion
 * @date 2022/3/27
 */
@Service
public class DtsRegionServiceImpl implements DtsRegionService {
    @Resource
    private DtsRegionMapper dtsRegionMapper;
    @Override
    public ResultVo listDtsRegion() {
        List<DtsRegionVO> dtsRegionVOS = dtsRegionMapper.selectDtsRegion();
        return new ResultVo(ResponseStatus.success,"select success",dtsRegionVOS);
    }
}
