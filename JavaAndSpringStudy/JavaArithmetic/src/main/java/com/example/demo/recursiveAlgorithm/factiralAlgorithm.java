package com.example.demo.recursiveAlgorithm;

public class factiralAlgorithm {
    //用for循环改写
    public static int getFactorialFor(int n) {
        int temp = 1;
        if (n >= 0) {
            for (int i = 1; i <= n; i++) {
                temp = temp * i;
            }
        } else {
            return -1;
        }
        return temp;
    }

    //递归来改写
    public static int getFactorial(int n) {
        if (n >= 0) {
            if (n == 0) {
                System.out.println(n + "!=1");
                return 1;
            } else {
                System.out.println(n);
                int temp = n * getFactorial(n - 1);
                System.out.println(n + "!=" + temp);
                return temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(getFactorialFor(4));
        System.out.println(getFactorial(4));
    }

}
