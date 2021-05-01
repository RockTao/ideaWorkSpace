package com.imooc.javaWebFlux.lambda.chapter03;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;


/**
 * Stream y运行机制
 * 1、所有操作是链式调用，一个元素之迭代一次
 * 2、每一个中间操作返回一个新的流，流里面有一个属性sourceStage执行同一个地方，就是好、Head
 * 3、Head ->nextStage -> .......->null‘
 * 4、有状态操作会把无状态操作截断，单独处理
 * 5、并行环境下，有状态的中间操作不一定能进行并行操作
 * 6、parallel/sequetial这两个操作也是中间操作，(也是返回stream)
 * 但他妈不创建流，他们只修改Head并行标志
 */
public class TestDemo7Stream {

    public static void main(String[] args) {
        Random random = new Random();
//    随机产生数据
        Stream<Integer> stream = Stream.generate(() -> random.nextInt())
//                产生500个  无限流需要短路操作
                .limit(500)
//                第一个无状态操作
                .peek(s -> print("peek" + s))
//                  第二个无状态操作
                .filter(s -> {
                    print("filter:" + s);
                    return s > 10000000;
                })
//                有状态操作
                .sorted((i1, i2) -> {
                    print("排序：" + i1 + "," + i2);
                    return i1.compareTo(i2);
                })
//                又一个无状态操作
                .peek(s -> {
                    print("peek2:" + s);
                })

                .parallel();

//                终止操作
        stream.count();
    }

    public static void print(String s) {
        System.out.println(Thread.currentThread().getName() + " > " + s);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
