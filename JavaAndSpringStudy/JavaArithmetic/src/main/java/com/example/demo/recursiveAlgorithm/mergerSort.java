package com.example.demo.recursiveAlgorithm;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class mergerSort {
    /**
     * 传入两个有序数组a和b，返回一个排好序的合并数组
     *
     * @param a
     * @param b
     * @return
     */
    public static int[] sort(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int aNum = 0, bNum = 0, cNum = 0;
        while (aNum < a.length && bNum < b.length) {
            if (a[aNum] >= b[bNum]) {//比较a数组和b数组的元素，谁更小将谁赋值到c数组
                c[cNum++] = b[bNum++];
            } else {
                c[cNum++] = a[aNum++];
            }
        }
        //如果a数组全部赋值到c数组了，但是b数组还有元素，则将b数组剩余元素按顺序全部复制到c数组
        while (aNum == a.length && bNum < b.length) {
            c[cNum++] = b[bNum++];
        }
        //如果b数组全部赋值到c数组了，但是a数组还有元素，则将a数组剩余元素按顺序全部复制到c数组
        while (bNum == b.length && aNum < a.length) {
            c[cNum++] = a[aNum++];
        }
        return c;
    }

    @Test
    public void test() {
        int[] a = {1, 3, 5, 7, 9};
        int[] b = {2, 6, 8, 10};
        System.out.println(Arrays.toString(sort(a, b)));
    }

}
