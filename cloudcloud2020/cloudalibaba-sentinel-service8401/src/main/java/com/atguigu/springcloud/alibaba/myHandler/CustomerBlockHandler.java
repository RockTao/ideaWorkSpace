package com.atguigu.springcloud.alibaba.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommResult;

public class CustomerBlockHandler {
    public static CommResult handlerException(BlockException exception) {
        return new CommResult(444, "客户自定义，global handlerException---1");
    }

    public static CommResult handlerException2(BlockException exception) {
        return new CommResult(444, "客户自定义，global handlerException---2");
    }
}
