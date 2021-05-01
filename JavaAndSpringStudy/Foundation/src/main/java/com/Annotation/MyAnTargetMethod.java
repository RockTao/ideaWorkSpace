package com.Annotation;

import java.lang.annotation.*;

/**
 * 定义一个可以注解在METHOD上的注解
 *
 * @author zhangqh
 * @date 2018年4月22日
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnTargetMethod {
         /**
      * 定义注解的一个元素 并给定默认值
      * @return
      */
    String value() default "我是定义在方法上的注解元素value的默认值";
}