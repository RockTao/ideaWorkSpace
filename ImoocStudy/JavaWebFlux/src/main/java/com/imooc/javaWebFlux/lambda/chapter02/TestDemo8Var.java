package com.imooc.javaWebFlux.lambda.chapter02;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 变量引用
 * lambda是实现了指定接口的内部类，匿名类
 * 它引用变量和内部类的引用规则是一样的
 * 匿名类引用外面的变量必须是final类型的
 * <p>
 * <p>
 * 参数是传值
 */
public class TestDemo8Var {
    public static void main(String[] args) {
// java参数传值还是传引用
//        String str = "我们的时间";
        List<String> list = new ArrayList<>();
        Consumer<String> consumer = s -> System.out.println(s + list);
        consumer.accept("11111222");

    }


}
