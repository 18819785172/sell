package com.imooc.dao;

import com.imooc.dataobject.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {

    @Autowired
    private OrderMasterDao dao;

    @Test
    public void findByBuyerOpenid() {
        PageRequest request = PageRequest.of(0, 2);
        Page<OrderMaster> orderMasters = dao.findByBuyerOpenid("zhd", request);
        System.out.println(orderMasters);
    }
}