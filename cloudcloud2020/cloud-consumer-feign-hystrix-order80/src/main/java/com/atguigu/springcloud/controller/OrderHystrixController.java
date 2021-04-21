package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_fallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_ok(id);
        log.info("****************  consumer   result+ " + result);
        return  result;
    }
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "PaymentInfo_TimeOutHandler",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds" ,value = "1500")
//    })
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
//        int age= 10/0;
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        log.info("**************** consumer   result+ " + result);
        return  result;
    }
    public String PaymentInfo_TimeOutHandler( Integer id){
        return  "我是消费者  80   线程池   "+ Thread.currentThread().getName() + " consumer/payment/hystrix/timeout/  出现异常了    （ O_O ）";
    }
//下面是全局fallback方法
    public String   payment_Global_fallbackMethod(){
        return "Global 异常处理信息，请稍后再试，/(T o T)~~~~~~~";
    }

}
