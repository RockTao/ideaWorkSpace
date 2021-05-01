package com.imooc.javaWebFlux.lambda.chapter02;


import java.util.function.*;

class Dog {
    private String name = "哮天犬";
    private int food = 10;

    public Dog() {
    }

    //    带参数的构造函数
    public Dog(String name) {
        this.name = name;
    }

    //静态方法
    public static void bark(Dog dog) {
        System.out.println(dog + "  叫了");
    }

    //   非静态方法

    /**
     * JDK 默认会把当前实例传入到非静态方法，参数为this 位置是第一个
     *
     * @param num
     * @return
     */
//    public int eat(Dog this,int num) { //这两个方法是等价的，jdk默认的方法
    public int eat(int num) {
        System.out.println("吃了 " + num + " 斤狗粮");
        return this.food -= num;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

//方法引用
public class TestDemo6MethondRefrence {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat(1);

///lambda表达式
        Consumer<String> consumer1 = s -> System.out.println(s);
        //方法引用
        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("接受的数据");

//        静态方法的方法引用
        Consumer<Dog> consumer3 = Dog::bark;
        consumer3.accept(dog);


//    非静态方法 使用对象实例的方法引用
//        Function<Integer,Integer> function = dog::eat;
//        UnaryOperator<Integer> function = dog::eat;
//        System.out.println(function.apply(2));
        IntUnaryOperator function = dog::eat;
        System.out.println(function.applyAsInt(2));


//        Dog::eat;
        /**
         * 使用类名来方法引用
         */
        BiFunction<Dog, Integer, Integer> eatFunction = Dog::eat;
        System.out.println("还剩下" + eatFunction.apply(dog, 2) + " -- ");

//        构造函数的方法引用
        Supplier<Dog> supplier = Dog::new;
        System.out.println("创建了新对象 ：" + supplier.get());

//        带参数的构造函数的方法引用
        Function<String, Dog> function2 = Dog::new;
        System.out.println("创建了新对象;" + function2.apply("旺财"));


    }
}
