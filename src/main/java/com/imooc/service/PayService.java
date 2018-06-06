package com.imooc.service;


import com.imooc.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;

// 支付
public interface PayService {

    PayResponse create(OrderDTO orderDTO);
    //异步通知
    PayResponse notify(String notifyData);
}
