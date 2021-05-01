package com.imooc.javaWebFlux.lambda.chapter02;

public class TestDemo2 {

    public static void main(String[] args) {
        Object target = new Runnable() {
            @Override
            public void run() {
                System.out.println("ok");
            }
        };
        new Thread((Runnable) target).start();

        //jdk 8
        Object target1 = (Runnable) () -> System.out.println("ok");
        Runnable target2 = () -> System.out.println("ok");
        System.out.println(target1 == target2);
    }


}
