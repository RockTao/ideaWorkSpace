package com.imooc.javaWebFlux.lambda.chapter02;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class TestDemo5Function {

    public static void main(String[] args) {
//断言函数接口
//        Predicate<Integer> predicate = i -> i> 0; //不带类型的函数接口
        IntPredicate predicate = i -> i > 0; //带类型的函数接口  优先使用这种
        System.out.println(predicate.test(-1));

//        IntConsumer
//消费函数接口
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("输入的数据");


    }
}
