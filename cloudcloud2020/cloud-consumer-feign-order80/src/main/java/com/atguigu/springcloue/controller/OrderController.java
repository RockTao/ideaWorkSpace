package com.atguigu.springcloue.controller;


import com.atguigu.springcloud.entities.CommResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloue.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payement/get/{id}")
    public CommResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);

    }


    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeOut(){

        //openFeign-ribbon 客户端一般默认等待1秒钟
        return paymentFeignService.paymentFeignTimeOut();
    }
}
