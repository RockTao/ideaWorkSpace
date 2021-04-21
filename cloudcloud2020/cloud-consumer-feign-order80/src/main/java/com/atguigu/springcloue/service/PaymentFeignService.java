package com.atguigu.springcloue.service;


import com.atguigu.springcloud.entities.CommResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payement/get/{id}")
    public CommResult getPaymentById(@PathVariable("id") Long  id)     ;

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeOut();
}
