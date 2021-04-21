package com.atguigu;

import org.junit.Test;

import java.time.ZonedDateTime;

public class T2 {
    @Test
    public  void test1(){
        ZonedDateTime zbj=  ZonedDateTime.now();
        System.out.println(zbj);
//2020-05-11T11:56:56.879+08:00[Asia/Shanghai]
    }
}
