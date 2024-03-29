package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private  String serverPort;
    @GetMapping(value = "/payment/nacos/{id}")
    public String echo(@PathVariable("id") Integer string) {
        return "Hello Nacos register     serverPort=" + serverPort +"\t id = "+ string;
    }

}

