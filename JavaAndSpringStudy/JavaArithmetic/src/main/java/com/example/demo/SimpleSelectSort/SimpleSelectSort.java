package com.example.demo.SimpleSelectSort;

import java.util.Arrays;

/**
 * 简单选择排序
 *
 */
public class SimpleSelectSort {
    public static void main(String[] args) {
        int[]  arr={3,1,5,7,2,4,9,6,8};
        System.out.println("排序前的数组:"+Arrays.toString(arr));
        int position=0;
        for(int i=0;i<arr.length;i++){
            int j=i+1;
            position=i;
            int temp=arr[i];
            for(;j<arr.length;j++){//找到最小值
                if(arr[j]<temp){
                    temp=arr[j];
                    position=j;
                }
            }
            arr[position]=arr[i];
            arr[i]=temp;
        }
        System.out.println("排序后的数组:"+Arrays.toString(arr));
    }
}
