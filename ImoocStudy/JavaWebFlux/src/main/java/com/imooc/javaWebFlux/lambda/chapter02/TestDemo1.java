package com.imooc.javaWebFlux.lambda.chapter02;

import java.util.stream.IntStream;

public class TestDemo1 {

    public static void main(String[] args) {
        int[] nums = {33, 55, -45, 90, -999, 90};
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i < min) {
                min = i;
            }
        }
        System.out.println(min);

//        jdk8
        int min2 = IntStream.of(nums).min().getAsInt();
        System.out.println(min2);
        int min3 = IntStream.of(nums).parallel().min().getAsInt();


    }
}
