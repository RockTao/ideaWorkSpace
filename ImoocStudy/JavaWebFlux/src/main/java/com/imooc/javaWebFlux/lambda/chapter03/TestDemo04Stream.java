package com.imooc.javaWebFlux.lambda.chapter03;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestDemo04Stream {
    public static void main(String[] args) {
        String str = "my name is 007";
//使用并行流
        str.chars().parallel().forEach(i -> System.out.print((char) i));
        System.out.println();
//        使用forEachOrdered保证顺序
        str.chars().parallel().forEachOrdered(i -> System.out.print((char) i));

//    收集
        System.out.println();
        List<String> list = Stream.of(str.split(" ")).collect(Collectors.toList());
        System.out.println(list);

//使用reduce拼接字符串
        Optional<String> letters = Stream.of(str.split(" ")).reduce((s1, s2) -> s1 + " | " + s2);
        System.out.println(letters.orElse(""));
//带有初始化值的reduce
        String reduce = Stream.of(str.split(" ")).reduce("", (s1, s2) -> s1 + " | " + s2);
        System.out.println("reduce = " + reduce);

//        计算所有单词的总长度
        Integer length = Stream.of(str.split(" ")).map(s -> s.length()).reduce(0, (s1, s2) -> s1 + s2);
        System.out.println("length= " + length);

//        max的使用
        Optional<String> max = Stream.of(str.split(" ")).max((s1, s2) -> s1.length() - s2.length());
        System.out.println("max = " + max.get());

//短路操作
        OptionalInt optionalInt = new Random().ints().findFirst();
        System.out.println(optionalInt.getAsInt());
    }
}
