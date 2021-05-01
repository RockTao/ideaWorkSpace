package com.imooc.javaWebFlux.lambda.chapter02;


import java.text.DecimalFormat;
import java.util.function.Function;

interface IMomeyFormat {
    String format(int i);
}

class MyMomey {
    private final int momey;

    public MyMomey(int momey) {
        this.momey = momey;
    }

    public void printMomey(Function<Integer, String> momeyFormat) {
        System.out.println("我的存款 ； " + momeyFormat.apply(this.momey));
    }
}

public class TestIMomeyFormat {
    public static void main(String[] args) {
        MyMomey me = new MyMomey(999999999);
        Function<Integer, String> moneyFormat = i -> new DecimalFormat("#,##").format(i);
        //函数接口 链式操作
        me.printMomey(moneyFormat.andThen(s -> "人民币：" + s));

    }

}
