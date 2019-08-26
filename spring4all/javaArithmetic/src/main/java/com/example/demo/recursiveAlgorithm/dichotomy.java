package com.example.demo.recursiveAlgorithm;

import org.junit.jupiter.api.Test;

/**
 *      递归的二分查找
 * 　　  注意：二分查找的数组一定是有序的！！！
 */
public class dichotomy {
    /**
     * 找到目标值返回数组下标，找不到返回-1
     * @param array
     * @param key
     * @return
     */
    public static int findTwoPoint(int[] array,int key){
        int start = 0;
        int last = array.length-1;
        while(start <= last){
            int mid = (last-start)/2+start;//防止直接相加造成int范围溢出
            if(key == array[mid]){//查找值等于当前值，返回数组下标
                return mid;
            }
            if(key > array[mid]){//查找值比当前值大
                start = mid+1;
            }
            if(key < array[mid]){//查找值比当前值小
                last = mid-1;
            }
        }
        return -1;
    }
    @Test
    public void testFindTwoPoint(){
    //　　注意：二分查找的数组一定是有序的！！！
        int []arr={1,3,4,5,6,7,8,9};
        System.out.println(findTwoPoint(arr,5));
    }

    /**
     * 　　二分查找用递归来改写，相信也很简单。边界条件是找到当前值，或者查找范围为空。否则每一次查找都将范围缩小一半。
     * @param array
     * @param key
     * @param low
     * @param high
     * @return
     */
    public static int search(int[] array,int key,int low,int high){
        int mid = (high-low)/2+low;
        if(key == array[mid]){//查找值等于当前值，返回数组下标
            return mid;
        }else if(low > high){//找不到查找值，返回-1
            return -1;
        }else{
            if(key < array[mid]){//查找值比当前值小
                return search(array,key,low,mid-1);
            }
            if(key > array[mid]){//查找值比当前值大
                return search(array,key,mid+1,high);
            }
        }
        return -1;
    }

}
