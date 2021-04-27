package com.mp.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.extension.injector.methods.additional.AlwaysUpdateSomeColumnById;
import com.baomidou.mybatisplus.extension.injector.methods.additional.InsertBatchSomeColumn;
import com.baomidou.mybatisplus.extension.injector.methods.additional.LogicDeleteByIdWithFill;
import com.mp.method.DeleteAllMethod;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MySqllnjector  extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);


        methodList.add(new InsertBatchSomeColumn(t-> !t.isLogicDelete()&&!t.getColumn().equals("age"))); //选装组件
        methodList.add(new LogicDeleteByIdWithFill());
        methodList.add(new AlwaysUpdateSomeColumnById(t->!t.getColumn().equals("name")));
        methodList.add(new DeleteAllMethod());
        return  methodList;
    }
}
