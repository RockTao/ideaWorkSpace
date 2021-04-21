package com.example.demo.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class mainTest {
    public static void main(String[] args) {
//1.获得Spring容器对象
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

//2.获得在Spring容器已经注册bean对象
        String beanNames[] = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

    }
}

