package com.example.demo.Shell_Sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class shell_sort {
    public static int[] sort(int[] array) {
        int j;
        //从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];//记录要插入的数据
            j = i;
            while (j > 0 && tmp < array[j - 1]) {//从已经排序的序列最右边的开始比较，找到比其小的数
                array[j] = array[j - 1];//向后挪动
                j--;
            }
            array[j] = tmp;//存在比其小的数，插入
        }
        return array;
    }

    @Test
    public void test() {
        int[] arr = {1, 11, 9, 8, 7, 2, 3, 6};
        System.out.println(Arrays.toString(sort(arr)));
    }

    public static void shellKnuthSort(int[] array) {
        System.out.println("原数组为" + Arrays.toString(array));
        int step = 1;
        int len = array.length;
        while (step <= len / 3) {
            step = step * 3 + 1;//1,4,13,40......
        }
        while (step > 0) {
            //分别对每个增量间隔进行排序
            for (int i = step; i < len; i++) {
                int temp = array[i];
                int j = i;
                while (j > step - 1 && temp <= array[j - step]) {
                    array[j] = array[j - step];
                    j -= step;
                }
                array[j] = temp;
            }//end for
            System.out.println("间隔为" + step + "的排序结果为" + Arrays.toString(array));
            step = (step - 1) / 3;
        }//end while(step>0)

        System.out.println("最终排序：" + Arrays.toString(array));
    }

    @Test
    public void testShellKnutSort() {
        int[] array = {4, 2, 8, 9, 5, 7, 6, 1, 3, 10};
        shellKnuthSort(array);
    }
}
