package com.imooc.javaWebFlux.lambda.chapter03;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class TestDemo05Stream {
    public static void main(String[] args) {

//        IntStream.range(1,100).peek(TestDemo05Stream::debug).count();
//调用parallel产生一个并行流
//        IntStream.range(1, 100).parallel().peek(TestDemo05Stream::debug).count();

        //要实现这样一个效果：先并行，在串行

//        多次调用parallel/sequential 以最后一次调用为基准
//        IntStream.range(1, 100)
////                调用parallel产生一个并行流
//                .parallel().peek(TestDemo05Stream::debug)
////                调用sequential产生串行流
//                .sequential().peek(TestDemo05Stream::debug)
//                .count();
//        并行流使用的线程池ForkJoinPool.commonPool
//        默认的线程数是当前机器cpu的个数
//        使用这个属性可以修改默认的线程数
//        System.setProperty("java.until.concunrrent.ForkJoinPool.common.parallelism","20");
//        IntStream.range(1, 100).parallel().peek(TestDemo05Stream::debug).count();

        ForkJoinPool pool = new ForkJoinPool(20);
        pool.submit(() -> IntStream.range(1, 100).parallel().peek(TestDemo05Stream::debug).count());
        pool.shutdown();
        synchronized (pool) {
            try {
                pool.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void debug(int i) {
        System.out.println(Thread.currentThread().getName() + " debug " + i);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
