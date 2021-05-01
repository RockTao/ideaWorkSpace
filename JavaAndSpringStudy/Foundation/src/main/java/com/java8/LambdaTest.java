package com.java8;

import org.junit.Test;

import java.util.*;

/*
使用lambda表达式遍历集合
https://blog.csdn.net/javaee_gao/article/details/96372530

 */
public class LambdaTest {


    @Test
    public void testForeach() {
        Collection<String> collection = new ArrayList<>();
        collection.add("i");
        collection.add("love");
        collection.add("china");
        // foreach遍历
        collection.forEach(e -> System.out.println(e));
        // 可以使用方法引用简写
        collection.forEach(System.out::println);
        // 或者迭代器的forEachRemaining方法
        collection.iterator().forEachRemaining(System.out::println);
    }

    @Test
    public void LambdaMethodOne() {
        // java 8之前的写法
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " >---Lambda");
            }
        };
// 使用lambda的写法
        Runnable r = () -> System.out.println(Thread.currentThread().getName() + " >---Lambda");
    }


}
