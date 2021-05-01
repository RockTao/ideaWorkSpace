package com.util.beanUtil;
/*                       BeanUtils.copyProperties()的用法

 BeanUtils提供对Java反射和自省API的包装。其主要目的是利用反射机制对JavaBean的属性进行处理。
 我们知道，一个JavaBean通常包含了大量的属性，
 很多情况下，对JavaBean的处理导致大量get/set代码堆积，增加了代码长度和阅读代码的难度。
 https://blog.csdn.net/wzc1991520/article/details/80176679
 */

import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class BeanUtilTest {
    @Test
    public  void main() {
        Person per = new Person();
        Student stu = new Student();

        per.setName("zhangsan");
        per.setSex("男");
        per.setAge(20);
        per.setBirthday(new Date());

        stu.setName("wuangwu");
        stu.setAddress("北京市");
        BeanUtils.copyProperties(stu, per);
        System.out.println(stu.getName());
        System.out.println(stu.getAge());
        System.out.println(stu.getAddress());
        System.out.println(stu.getBirthday());

    }
}
