package com.example.demo.Merger_Sort;


import java.util.Arrays;

public class merger_sort {
    public static void merge(int[] a,int low,int mid,int hight){
        int[] temp=new int[hight-low+1];
        int i=low;//左指针
        int j=mid+1;//右指针
        int k=0;
        while(i<=mid&&j<=hight){//把较小的数先移到新数组中
            if(a[i]<a[j]){
                temp[k++]=a[i++];
            }else{
                temp[k++]=a[j++];
            }
        }
        while(i<=mid){//把左边剩余的数移入到数组
            temp[k++]=a[i++];
        }
        while(j<=hight){//把右边的剩余的数移入数组
            temp[k++]=a[j++];
        }
        //把新数组中的数覆盖nums数组
        for(int k2=0;k2<temp.length;k2++){
            a[k2+low]=temp[k2];
        }
    }
    public static void mergeSort(int[] arr,int low,int height){
        int mid=(low+height)/2;
        if(low<height){
            mergeSort(arr,low,mid);//左边
            mergeSort(arr,mid+1,height);//右边
            merge(arr,low,mid,height);//左右合并
            System.out.println(Arrays.toString(arr));
        }
    };
    public static void main(String[] args) {
        int arr[]={51,34,20,12,65,97,87,30,77,50};
        mergeSort(arr,0,arr.length-1);
        System.out.println("排序后的结果为:"+Arrays.toString(arr));
    }
}

