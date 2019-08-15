package com.example.rabbitmqspring;

import com.example.rabbitmqspring.produce.RabbitProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqSpringApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqSpringApplication.class, args);
    }


    @Autowired
    private RabbitProducer rabbitProducer;


    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        rabbitProducer.sendMessage();
    }


}
