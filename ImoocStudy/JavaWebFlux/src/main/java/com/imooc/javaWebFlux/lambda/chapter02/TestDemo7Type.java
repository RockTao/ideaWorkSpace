package com.imooc.javaWebFlux.lambda.chapter02;


//类型推断
interface IMath {
    int add(int x, int y);
}

public class TestDemo7Type {

    public static void main(String[] args) {
        /*变量类型定义*/
        IMath lambda = (x, y) -> x + y;
//        数组里
        IMath[] lambdas = {(x, y) -> x + y};
//        强转
        Object lambdas2 = (IMath) (x, y) -> x + y;

//        通过类型返回
        IMath createLambda = createLambda();
        TestDemo7Type demo = new TestDemo7Type();
        demo.test((x, y) -> x + y);

    }

    public void test(IMath math) {

    }

    public static IMath createLambda() {
        return ((x, y) -> x + y);
    }
}
