package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.loadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

    //    public static final String PAYMENT_URL ="http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payement/create")
    public CommResult<Payment> create(Payment payment) {
        log.info("-----------------consumer    80 ------------");
        return restTemplate.postForObject(PAYMENT_URL + "/payement/create", payment, CommResult.class);
    }
//     getForObject 和getForEntity的区别

    @GetMapping("/consumer/payement/get/{id}")
    public CommResult<Payment> getpayment(@PathVariable("id") Long id) {
        log.info("-----------------consumer  payement/get/  80 ------------" + PAYMENT_URL + "/payement/get/" + id);

        return restTemplate.getForObject(PAYMENT_URL + "/payement/get/" + id, CommResult.class);
    }

    @GetMapping("/consumer/payement/getForEntity/{id}")
    public CommResult<Payment> getpayment2(@PathVariable("id") Long id) {
        ResponseEntity<CommResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payement/get/" + id, CommResult.class);
        log.info(entity.getHeaders() + "\n" + entity.getStatusCodeValue() + "\n" + entity.getStatusCode());
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommResult<>(444, "操作失败");
        }
    }

    //手写轮询算法
    @Resource
    private loadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }


    //     sleuth  + zipkin
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin() {
        String result = restTemplate.getForObject("http://localhost:8001" + "/payment/zipkin", String.class);
        return result;

    }
}
