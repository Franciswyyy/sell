package com.imooc.service;

<<<<<<< HEAD
=======

>>>>>>> 2a9074740b0e391e6da452498abcf549cb8aa7e2
import com.imooc.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

<<<<<<< HEAD
public interface PayService {

    PayResponse create(OrderDTO orderDTO);

=======
// 支付
public interface PayService {

    PayResponse create(OrderDTO orderDTO);
    //异步通知
>>>>>>> 2a9074740b0e391e6da452498abcf549cb8aa7e2
    PayResponse notify(String notifyData);

    RefundResponse refund(OrderDTO orderDTO);
}
