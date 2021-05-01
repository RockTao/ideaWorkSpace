package com.example.demo.Quick_Sort;
/**
 *
 * 快速
 */
import java.util.Arrays;

public class quick_sort {
    public static void main(String[] args) {
        int[] arr={33,12,23,45,76,56,50};
        System.out.println("排序前："+Arrays.toString(arr));
        int h=arr.length-1;
        quickSort(arr,0,h);
        System.out.println("排序后："+Arrays.toString(arr));
    }
    public static void quickSort(int[] a,int low,int high){
        if(low<high){
            int middle=getMiddle(a,low,high);
            quickSort(a,0,middle-1);//递归对低子表递归排序
            quickSort(a,middle+1,high);//递归对高子表递归排序
        }

    }
    public static int getMiddle(int[] a,int low,int high){
        int key=a[low];//基准元素，排序中会空出来一个位置
        while(low<high){
            while(low<high&&a[high]>=key){//从high开始找比基准小的，与low换位置
                high--;
            }
            a[low]=a[high];
            while(low<high && a[low]<=key){//从low开始找比基准大,放到之前high空出来的位置
                low++;
            }
            a[high]=a[low];
        }
        a[high]=key;//此时low=high 是基准元素的位置，也是空出来的那个位置
        return low;

    }
}

