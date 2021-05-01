package com.java8;

import java.util.*;
/*
Java集合中removeIf的使用
https://blog.csdn.net/qq_33829547/article/details/80277956
 */
public class newCollection {
    public static void main(String[] args) {

        Collection<Person> collection = new ArrayList();
        collection.add(new Person("张三", 22, "男"));
        collection.add(new Person("李四", 19, "女"));
        collection.add(new Person("王五", 34, "男"));
        collection.add(new Person("赵六", 30, "男"));
        collection.add(new Person("田七", 25, "女"));

//过滤30岁以上的求职者
        Iterator<Person> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getAge() >= 30)
                iterator.remove();
        }
        System.out.println(collection.toString());//查看结果


        collection.removeIf(
                person -> person.getAge() >= 30
        );//过滤30岁以上的求职者

        System.out.println("2222="+collection.toString());//查看结果
    }
}
