package com.imooc.javaWebFlux.lambda.chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestDemo02Stream {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//从集合创建
        list.stream();
        list.parallelStream();

//        c从数组创建
        Arrays.stream(new int[]{1, 2, 3});

//        创建数字刘
        IntStream.of(1, 2, 3, 4);
        IntStream.rangeClosed(1, 10);
//        使用random创建一个无限流
        new Random().ints().limit(10);

        Random random = new Random();
        Stream.generate(() -> random.nextInt()).limit(20);
    }
}
