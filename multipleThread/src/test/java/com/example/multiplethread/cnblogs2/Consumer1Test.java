package com.example.multiplethread.cnblogs2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Consumer1Test {

    @Resource
    com.example.multiplethread.cnblogs2.Consumer1 con;
    @Test
    public void test(){
        con.test("abc");
    }

}
