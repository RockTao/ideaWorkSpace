package com.atguigu.springcloud.service;


import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    //  服务降级

    public String PaymentInfo_OK( Integer id){
        return  "线程池"+ Thread.currentThread().getName() + " \t  paymentInfo_ok ,id =" +id +" 哈哈";
    }
    //HystrixCommand 报异常后如何处理，一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中指定的方法
@HystrixCommand(fallbackMethod = "PaymentInfo_TimeOutHandler",commandProperties = {
        //设置这个线程的超时时间是3秒，3秒内是正常的业务逻辑，超过3s调用fallbackMethod指定的方法进行处理
        @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds" ,value = "5000")
})
    public String PaymentInfo_TimeOut( Integer id){
        try {
            TimeUnit.MICROSECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  "线程池"+ Thread.currentThread().getName() + " \t  paymentInfo_ok ,id =" +id +" 耗时3秒钟  哈哈  ( U _ U )";
    }
    public String PaymentInfo_TimeOutHandler( Integer id){
        return  "线程池"+ Thread.currentThread().getName() + " \t  PaymentInfo_TimeOutHandler 服务异常啦   （ O_O ）";
    }

//    ------- 服务熔断----------
//开启后，在10分针的时间窗口期内，10此请求60%的请求无法正常使用，就出发操作
    @HystrixCommand(
            fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties ={
                    @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),     // 是否开启断路器
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),      // 请求次数
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),        // 时间窗口期
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")            // 失败率达到多少后跳闸
            }
    )
    public String  paymentCircuitBraker(@PathVariable("id") Integer id){
        if(id <0 ){
            throw  new RuntimeException(" *********  --id  不能为负的 ------");
        }
        String serialNumber = IdUtil.simpleUUID();
        return  Thread.currentThread().getName()+"\t" + "调用成功，流水号" + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id")Integer id){

        return  "id 不能为负的，请稍后再试、/(T o T) /~ ~~~ id " + id ;
    }



    }
