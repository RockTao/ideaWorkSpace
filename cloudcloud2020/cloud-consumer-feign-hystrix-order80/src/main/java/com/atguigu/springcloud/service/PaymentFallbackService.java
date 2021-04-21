package com.atguigu.springcloud.service;


import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService  implements  PaymentHystrixService{
    @Override
    public String paymentInfo_ok(Integer id) {

        return "---PaymentFallbackService   fall back -    Method   paymentInfo_ok   o(TT__tt) ";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {

        return "---PaymentFallbackService   fall back -    Method   paymentInfo_TimeOut   o( HJKJKLNMLKJ) ";
    }
}
