package com.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义一个可以注解在Class,interface,enum上的注解
 *
 * @author zhangqh
 * @date 2018年4月22日
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnTargetType {
         /**
      * 定义注解的一个元素 并给定默认值
      * @return
      */
    String value() default "我是定义在类接口枚举类上的注解元素value的默认值";
}