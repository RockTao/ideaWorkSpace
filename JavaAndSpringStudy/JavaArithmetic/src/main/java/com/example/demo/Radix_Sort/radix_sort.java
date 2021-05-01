package com.example.demo.Radix_Sort;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 基数排序
 *
 */
public class radix_sort {
    public int digit(int data,int m,int r){/***获取data的第m为数字，该数字为r进制*/
        int i,d;
        if(m==0) return data%r;
        d=r;
        for(i=1;i<m;i++){
            d=d*r;
        }
        return (data/d)%r;
    }
    public void radixSort(int[] array,int n,int m,int r){
        /**数组array中存放关键字为m位的r进制数，数组大小为n*/
        int i,k,j;
        Queue[] que=new Queue[r];//定义一个队列数组
        for(i=0;i<r;i++){//初始化队列数组
            que[i]=new LinkedList<Integer>();
        }
        for(i=0;i<m;i++){//进行m趟排序
            for(j=0;j<n;j++){
                k=digit(array[j],i,r);//去除数组中第j个数的第i位的值
                que[k].add(array[j]);//把数组中第j个数放入k对应的队列中
            }
            j=0;
            for(k=0;k<r;k++){//将所有队列中的值取出，重新存入数组array中
                while(!que[k].isEmpty()){
                    array[j++]=(int)que[k].remove();
                }
            }
            for(j=0;j<n;j++){//输出每趟排序的结果
                System.out.print(array[j]+",");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        /**使用基数排序法进行排序*/
        int arr[]={983,259,23,173,285,274,11,546,744,372};  //把待排序的数存放在数组中
        int n=arr.length;
        radix_sort rs=new radix_sort();
        rs.radixSort(arr,n,3,10);
    }
}


