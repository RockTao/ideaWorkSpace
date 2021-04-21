package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.paymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;


@RestController
@Slf4j
public class paymentController {
    @Resource
    private DiscoveryClient discoveryClient;//获取对应的服务信息

    @Value("${server.port}")
    private String serverPort;
    @Resource
    private paymentService paymentService;

    @GetMapping(value = "/payement/{id}")
    public CommResult test(@PathVariable("id") Long  id){
        return  new  CommResult(200,"test11111111111",id);
    }

    @PostMapping(value = "/payement/create")
    public CommResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果***********" + result);
        if(result >0){
            return  new CommResult(200,"插入数据库成功,serverPort=" +serverPort,result);
        }else{
            return  new CommResult(444,"插入失败",null);
        }

    }

    @GetMapping(value = "/payement/get/{id}")
    public CommResult getPaymentById(@PathVariable("id") Long  id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*********查询结果***********" + payment +" id = " +id);
        if(payment !=null){
            return  new CommResult(200,"查询成功serverPort=" +serverPort,payment);
        }else{
            return  new CommResult(444,"查询失败,查询id"+id,null);
        }

    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> servies = discoveryClient.getServices();
        for (String element:servies){
            log.info("*************** element:" + element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance: instances){
            log.info(instance.getServiceId()+" \t "+ instance.getPort()+ " \t " + instance.getUri());
        }
        return  this.discoveryClient;
    }



    @GetMapping(value = "/payement/lb")
    public String getPaymentLB(){
        return "端口号 = "+ serverPort;
    }


    //Feign 超时设置
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeOut(){

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  serverPort;
    }


    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return  "hi i'am paymentzipkin server fall back  ";
    }


}
