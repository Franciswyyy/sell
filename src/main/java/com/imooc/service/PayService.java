package com.imooc.service;


import com.imooc.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

// 支付
public interface PayService {

    PayResponse create(OrderDTO orderDTO);
    //异步通知
    PayResponse notify(String notifyData);

    RefundResponse refund(OrderDTO orderDTO);
}
