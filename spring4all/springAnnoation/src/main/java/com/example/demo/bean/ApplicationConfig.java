package com.example.demo.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

//@Configuration
//它的作用是：将一个java类修饰为==配置文件==，在这个java类进行组件注册
@Configuration//相当于配置文件
public class ApplicationConfig {


    @Bean(name={"stu1"})
    public Student student2(){
        return new Student();
    }
    @Lazy//这个注解专用于单例模式bean对象，此时bean对象不会在
//spring容器启动时被创建的，只有在一个用户来访时才会被创建
    @Bean
    public Teacher teacher(){
        return new Teacher();
    }
}
