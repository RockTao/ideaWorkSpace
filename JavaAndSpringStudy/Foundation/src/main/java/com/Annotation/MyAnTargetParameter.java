package com.Annotation;

import java.lang.annotation.*;
import java.lang.annotation.RetentionPolicy;

/**
 * 定义一个可以注解在PARAMETER上的注解
 *
 * @author zhangqh
 * @date 2018年4月22日
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnTargetParameter {
    /**
     *     * 定义注解的一个元素 并给定默认值
     *     * @return
     *    
     */
    String value() default "我是定义在参数上的注解元素value的默认值";
}