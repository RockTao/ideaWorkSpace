package com.atguigu.gmall;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class BootConsumerMain {

	public static void main(String[] args) {
		SpringApplication.run(BootConsumerMain.class, args);
	}
}
