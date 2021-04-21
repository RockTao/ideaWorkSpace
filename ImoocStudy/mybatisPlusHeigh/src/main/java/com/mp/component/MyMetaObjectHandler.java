package com.mp.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class MyMetaObjectHandler implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        boolean hasSetter = metaObject.hasSetter("createTime");
        if(hasSetter){
            System.out.println("  insertFill -----------");
            setInsertFieldValByName("createTime", LocalDateTime.now(), metaObject);
        }
    }
    //    对应的实体类中国的方法  同时需要看对应的注解
    @Override
    public void updateFill(MetaObject metaObject) {
        Object updateTime = getFieldValByName("updateTime", metaObject); //只有updateTime 为null的时候才填充
        if(updateTime == null){
            System.out.println("  updateFill -----------");
            setUpdateFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        }


    }
}
