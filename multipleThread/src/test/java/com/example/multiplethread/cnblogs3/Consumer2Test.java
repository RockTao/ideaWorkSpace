package com.example.multiplethread.cnblogs3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Consumer2Test {

    @Resource
    Consumer2 con2;
    @Test
    public void test(){
    con2.test("测试数据");
    }

}
