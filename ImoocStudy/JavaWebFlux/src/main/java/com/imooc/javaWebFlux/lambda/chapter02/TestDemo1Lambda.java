package com.imooc.javaWebFlux.lambda.chapter02;

//函数接口   单一责任制  只能一个方法
// 默认方法 default
@FunctionalInterface
interface interface1 {
    int doubleNum(int i);

    default int add(int x, int y) {
        x = this.doubleNum(x);
        return x + y;
    }
}

@FunctionalInterface
interface interface2 {
    int doubleNum(int i);

    default int add(int x, int y) {
        return x + y;
    }
}

@FunctionalInterface
interface interface3 extends interface1, interface2 {
    @Override
    default int add(int x, int y) {
        return 0;
    }
}

public class TestDemo1Lambda {
    public static void main(String[] args) {
        interface1 i1 = (i) -> i * 2;
        System.out.println(i1.add(1, 10));
        System.out.println(i1.doubleNum(10));
        //这种是最常见的
        interface1 i2 = i -> i * 2;
        interface1 i3 = (int i) -> i * 2;
        interface1 i4 = (int i) -> {
            System.out.println(" -----");
            return i * 2;
        };


    }
}
