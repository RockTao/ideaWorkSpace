package com.example.multiplethread.config;//package com.example.multiplethread.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.*;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//import java.util.concurrent.Executor;
//
//@Configuration
//@EnableAsync
//public class AsyncConfig implements AsyncConfigurer {
//
//    @Override
//    public Executor getAsyncExecutor() {
//        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
//        //核心线程数
//        taskExecutor.setCorePoolSize(8);
//        //最大线程数
//        taskExecutor.setMaxPoolSize(16);
//        //队列大小
//        taskExecutor.setQueueCapacity(100);
//        taskExecutor.initialize();
//        return taskExecutor;
//    }
//}