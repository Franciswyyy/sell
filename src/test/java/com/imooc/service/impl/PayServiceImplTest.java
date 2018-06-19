package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import com.imooc.service.OrderService;
import com.imooc.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
<<<<<<< HEAD
=======

>>>>>>> 2a9074740b0e391e6da452498abcf549cb8aa7e2
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    @Test
    @Transactional
    public void create() throws Exception {
<<<<<<< HEAD
        OrderDTO orderDTO = orderService.findOne("1528039566034600448");
        payService.create(orderDTO);
    }


=======
        OrderDTO orderDTO = orderService.findOne("1528200579223325135");
        payService.create(orderDTO);
    }

>>>>>>> 2a9074740b0e391e6da452498abcf549cb8aa7e2
}