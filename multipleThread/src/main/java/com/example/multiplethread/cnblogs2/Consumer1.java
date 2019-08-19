package com.example.multiplethread.cnblogs2;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;


@Component
public class Consumer1 {


    @Resource
    private ExecutorService executorService;


    public void test(String msg){
        System.out.println(Thread.currentThread().getName()+":"+msg);


        /**
         * 分类1：可以返回值的 Callable
         */
        Future fal  = executorService.submit(new Callable<String>() {
            @Override
            public String call() {
                System.out.println(Thread.currentThread().getName()+":"+msg);
                return "处理成功！";
            }
        });

        try {
            System.out.println(fal.get());
        }catch (Exception e){
            System.out.println(e);
        }

        /**
         * 分类2：不会返回值的 Runnable
         */
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+":"+msg);
            }
        });

        /**
         * 分类3：也可以这样
         */
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+":"+msg);
            }
        });

    }




}