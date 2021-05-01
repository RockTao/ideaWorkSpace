package com.imooc.javaWebFlux.lambda.chapter03;

import java.util.Random;
import java.util.stream.Stream;

public class TestDemo03Stream {
    public static void main(String[] args) {
        String str = "my name is 007";
        Stream.of(str.split(" ")).map(s -> s.length()).forEach(System.out::println);
        System.out.println("__________");
        Stream.of(str.split(" ")).filter(s -> s.length() > 2).map(s -> s.length()).forEach(System.out::println);
        //flatMap A ->B 属性（是个集合），最红得到所有的A元素里面的所有B属性集合
//        intStream/longStream并不是Stream的子类，所以要进行装箱boxed
        Stream.of(str.split(" ")).flatMap(s -> s.chars().boxed())
                .forEach(s -> System.out.println((char) s.intValue()));
        System.out.println("----------------- peek--");
//        peek用于debug  是个中间操作，和foreach是终止操作
        Stream.of(str.split(" ")).peek(System.out::println).forEach(System.out::println);
//        limit使用，主要用于无限流，限流的作用
        new Random().ints().filter(i -> i > 100 & i < 10000).limit(10).forEach(System.out::println);

    }
}
