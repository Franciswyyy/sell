package com.imooc.controller;

<<<<<<< HEAD

=======
>>>>>>> 2a9074740b0e391e6da452498abcf549cb8aa7e2
import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.OrderService;
import com.imooc.service.PayService;
import com.lly835.bestpay.model.PayResponse;
<<<<<<< HEAD
=======
import com.lly835.bestpay.rest.type.Post;
import com.sun.org.apache.bcel.internal.generic.RETURN;
>>>>>>> 2a9074740b0e391e6da452498abcf549cb8aa7e2
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
<<<<<<< HEAD
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String, Object> map){
=======
                               @RequestParam("resturnUrl") String returnUrl,
                               Map<String, Object> map){

>>>>>>> 2a9074740b0e391e6da452498abcf549cb8aa7e2
        //1. 查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

<<<<<<< HEAD
        //发起支付
        PayResponse payResponse = payService.create(orderDTO);

        map.put("payResponse", payResponse);
        map.put("returnUrl", returnUrl);   // 支付成功失败，都跳转到这里~

        //参数注入到model中
        return new ModelAndView("pay/create", map);

    }


    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData){
        payService.notify(notifyData);
        // 异步通知后，支付完通知微信支付了，这样就不会再异步通知商户付款了
        //返回给微信处理结果
        return new ModelAndView("/pay/success");
=======
        //2.发起支付
        PayResponse payResponse = payService.create(orderDTO);

        map.put("payResponse", payResponse);
        map.put("returnUrl", returnUrl);

        return new ModelAndView("/pay/create");
        //TODO 添加了freemarker之后
    }

    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyDate){
        payService.notify(notifyDate);

        //返回给微信处理结果
        return new ModelAndView("pay/success");
>>>>>>> 2a9074740b0e391e6da452498abcf549cb8aa7e2
    }
}
