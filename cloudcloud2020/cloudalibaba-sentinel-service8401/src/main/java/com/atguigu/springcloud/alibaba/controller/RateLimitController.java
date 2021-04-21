package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.alibaba.myHandler.CustomerBlockHandler;
import com.atguigu.springcloud.entities.CommResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class RateLimitController {
    // 按资源名称限流
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommResult byResource() {
        return new CommResult(200, "按资源名称限流测试ok", new Payment(200L, "serial001"));
    }

    public CommResult handleException(BlockException extension) {
        return new CommResult(444, extension.getClass().getCanonicalName() + "\t 服务不可用");
    }


    //按url地址限流
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommResult byUrl() {
        return new CommResult(200, "按url、限流规则", new Payment(2020L, "seriald02002"));
    }
//   CustomerBlockHandler
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public CommResult customerBlockHandler() {
        return new CommResult(200, "客户自定义", new Payment(2020L, "seriald02003"));
    }
}
