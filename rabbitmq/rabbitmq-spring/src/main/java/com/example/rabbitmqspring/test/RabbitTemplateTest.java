package com.example.rabbitmqspring.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Component
@Slf4j
public class RabbitTemplateTest implements InitializingBean {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void afterPropertiesSet() throws Exception {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                IntStream.rangeClosed(1, 10).forEach(num -> rabbitTemplate.convertAndSend("exchange001", "direct_001", String.format("这个是第[%d]条消息.", num)));
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            }
        }).start();
    }
}