package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
//    OrderServiceImpl orderService;
//    @Test
//    public void test(){
//        OrderDTO orderDTO = new OrderDTO();
//        BigDecimal big = new BigDecimal(100);
//        orderDTO.setPrice(big);
//        orderDTO.setType("2");
//        orderDTO.setCode("1");
//        orderService.handle(orderDTO);
//
//    }

    @Test
    public  void test(){

        String Html = "<p>  Test 数据啊</p>";
        System.out.println();
    }

}
