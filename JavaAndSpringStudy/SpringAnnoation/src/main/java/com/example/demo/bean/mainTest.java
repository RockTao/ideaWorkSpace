package com.example.demo.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class mainTest {
    public static void main(String[] args) {

        //1.获得Spring容器对象
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);
        System.out.println("Spring 容器启动了。。。");
        Teacher t = (Teacher) context.getBean("teacher");

    }
}

