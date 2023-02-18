package com.scorpion.service;

import com.scorpion.entity.Orders;
import com.scorpion.mapper.OrdersMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Scheduled;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author scorpion
 * @date 2022/2/14
 */
@SpringBootTest
public class OrderCheckTimeJobTest {
    @Resource
    private OrdersMapper ordersMapper;

    /**
     * 每隔5秒查询一次订单状态是否为未支付且创建订单时间大于30分钟
     */
    @Scheduled(cron = "0/5 * * * * ?")
    @Test
    public void orderCheckTime(){
        Example example=new Example(Orders.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status","1");
        Date time=new Date(System.currentTimeMillis()-30*60*1000);
        criteria.andLessThan("createdTime",time);
        List<Orders> orders = ordersMapper.selectByExample(example);
        for (Orders o: orders) {
            System.out.println(o.getOrderId());
        }
    }

}
