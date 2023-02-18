package com.scorpion.mapper;

import com.scorpion.entity.IuSearchHistory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author scorpion
 * @date 2022/6/24
 */
@SpringBootTest
public class IuSearchHistoryTest {
    @Resource
    private IuSearchHistoryMapper iuSearchHistoryMapper;

    @Test
    public void testSelectSearchHistoryByUserId() throws Exception {
        List<IuSearchHistory> strings = iuSearchHistoryMapper.selectSearchHistoryByUserId(8);
        System.out.println(strings);
    }
}
