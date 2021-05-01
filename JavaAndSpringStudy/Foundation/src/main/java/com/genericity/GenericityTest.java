package com.genericity;

import ch.qos.logback.classic.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型.md
 * https://blog.csdn.net/javaee_gao/article/details/99889987
 */
public class GenericityTest
{

    @Test
    public void testGeneric(){
        List<String> list = new ArrayList();
//        list.add(1);
        list.add("abc");
        list.stream().forEach( e ->{
            String unm = (String) e;
            System.out.println(unm);
        });

    }

    /**
     * 泛型只在编译阶段有效
     * 通过上面的例子可以证明，在编译之后程序会采取去泛型化的措施。也就是说Java中的泛型，只在编译阶段有效。在编译过程中，正确检验泛型结果后，会将泛型的相关信息擦出，并且在对象进入和离开方法的边界处添加类型检查和类型转换的方法。也就是说，泛型信息不会进入到运行时阶段。
     *
     * 对此总结成一句话：泛型类型在逻辑上看以看成是多个不同的类型，实际上都是相同的基本类型。
     */
    @Test
    public void testGeneric_2(){
        List<String> stringArrayList = new ArrayList<String>();
        List<Integer> integerArrayList = new ArrayList<Integer>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        if(classStringArrayList.equals(classIntegerArrayList)){
            System.out.println("泛型测试类型相同");
        }
    }

    @Test
    public void testGeneric_Three(){
        //泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
//传入的实参类型需与泛型的类型参数类型相同，即为Integer.
        Generic<Integer> genericInteger = new Generic<Integer>(123456);

//传入的实参类型需与泛型的类型参数类型相同，即为String.
        Generic<String> genericString = new Generic<String>("key_vlaue");
        System.out.println("泛型测试 key is " + genericInteger.getKey());
        System.out.println("泛型测试 key is " + genericString.getKey());

    }


}
