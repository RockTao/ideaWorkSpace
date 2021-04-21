package com.atguigu.springcloud.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationCtontextConfig {
    @Bean
//    @LoadBalanced //开启负载均衡  //手写负载均衡
    public RestTemplate getRestTemplate()
    {
        return  new RestTemplate();
    }
}
//applicationContext.xml <bean id="" class="">
