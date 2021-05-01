package com.example.multiplethread.cnblogs3;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Consumer2 {


    @Resource
    private AsyncTaskService asyncTaskService;



    public void test(String msg){
        System.out.println(Thread.currentThread().getName()+":"+msg);

        asyncTaskService.executeAsyncTask(msg);

    }

}