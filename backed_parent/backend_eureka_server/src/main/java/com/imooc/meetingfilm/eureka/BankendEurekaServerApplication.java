package com.imooc.meetingfilm.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class BankendEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankendEurekaServerApplication.class, args);
    }

}
