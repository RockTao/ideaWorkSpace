package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderZKController {


    public static final String INVOK_URL="http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consuer/payment/zk")
    public  String paymentInfo(){
        String result = restTemplate.getForObject(INVOK_URL+"/payment/zk",String.class);
        return  result;
    }

}
