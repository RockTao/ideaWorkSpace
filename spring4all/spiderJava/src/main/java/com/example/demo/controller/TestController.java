package com.example.demo.controller;

import com.example.demo.aspectAnnotation.one.OperationLogDetail;
import com.example.demo.aspectAnnotation.one.OperationType;
import com.example.demo.aspectAnnotation.one.OperationUnit;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class TestController {
    @OperationLogDetail(operationUnit = OperationUnit.UNKNOWN,operationType = OperationType.UNKNOWN)
    @RequestMapping("/test")
    public String test(String id){
        return "TestController11" + id;
    }

    @Test
    public void test1(){
        System.out.println("原  国内外匿名邮箱及手机短信验证码接收平台".replaceAll("\\s*", ""));
    }

}


