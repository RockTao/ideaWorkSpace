package com.imooc.javaWebFlux.lambda.chapter03;

import java.util.stream.IntStream;

public class TestDemo01Stream {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
//        外部迭代
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        System.out.println("结果为 sum1 =  " + sum);

//         s使用stream的内部迭代
        int sum2 = IntStream.of(nums).sum();
        System.out.println("结果为 sum2 =  " + sum2);

        // 中间操作/终止操作 和惰性求值
//        map 是中间操作   返回stream的操作
//         sum是终止操作
//        区别在于是否有返回类型： 中间操作会返回对应的流，  终止操作不会返回对应的流
        int sum3 = IntStream.of(nums).map(i -> i * 2).sum();
        System.out.println("结果为sum3 = " + sum3);

        int sum4 = IntStream.of(nums).map(TestDemo01Stream::doubleNum).sum();
        System.out.println("结果为 sum4 =  " + sum4);

        System.out.println("惰性求值就是终止没有调用的情况下，中间操作不会执行");
        IntStream.of(nums).map(TestDemo01Stream::doubleNum);
    }

    public static int doubleNum(int i) {
        System.out.println("执行了乘以 2 的操作");
        return i * 2;
    }
}
