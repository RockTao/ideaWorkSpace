package com.reflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {

    @Test //      通过Class类获取类对象
    public void testClass() {
        Class clazz = null;
        //1.得到Class对象
        clazz = Person.class;
        System.out.println(clazz);  //插入断点
    }
    @Test //这些属性值是可以获取的
    public void testClassFiled() {
        Class clazz = null;

        //1.得到Class对象
        clazz = Person.class;
        //2.返回字段的数组
        Field[] fields = clazz.getDeclaredFields();
        System.out.println(fields);  //插入断点
    }

    /**
     * 获取Class对象的三种方式 https://www.cnblogs.com/tech-bird/p/3525336.html
     *  　1.通过类名获取      类名.class
     * 　　2.通过对象获取      对象名.getClass()
     * 　　3.通过全类名获取    Class.forName(全类名)
     * @throws ClassNotFoundException
     */
    @Test
    public void testAllClass() throws ClassNotFoundException {
        Class clazz = null;
        //1.通过类名
        clazz = Person.class;

        //2.通过对象名
        //这种方式是用在传进来一个对象，却不知道对象类型的时候使用
        Person person = new Person();
        clazz = person.getClass();
        //上面这个例子的意义不大，因为已经知道person类型是Person类，再这样写就没有必要了
        //如果传进来是一个Object类，这种做法就是应该的
        Object obj = new Person();
        clazz = obj.getClass();

        //3.通过全类名(会抛出异常)
        //一般框架开发中这种用的比较多，因为配置文件中一般配的都是全类名，通过这种方式可以得到Class实例
        String className=" com.atguigu.java.fanshe.Person";
        clazz = Class.forName(className);

        //字符串的例子
        clazz = String.class;
        clazz = "javaTest".getClass();
        clazz = Class.forName("java.lang.String");
        System.out.println();
    }

    @Test
    public void testMethod() throws Exception{
        Class clazz = Class.forName("com.atguigu.java.fanshe.Person");
        //1.获取方法
        //  1.1 获取取clazz对应类中的所有方法--方法数组（一）
        //     不能获取private方法,且获取从父类继承来的所有方法
        Method[] methods = clazz.getMethods();
        for(Method method:methods){
            System.out.print(" "+method.getName());
        }
        System.out.println();

        //
        //  1.2.获取所有方法，包括私有方法 --方法数组（二）
        //  所有声明的方法，都可以获取到，且只获取当前类的方法
        methods = clazz.getDeclaredMethods();
        for(Method method:methods){
            System.out.print(" "+method.getName());
        }
        System.out.println();

        //
        //  1.3.获取指定的方法
        //  需要参数名称和参数列表，无参则不需要写
        //  对于方法public void setName(String name) {  }
        Method method = clazz.getDeclaredMethod("setName", String.class);
        System.out.println(method);
        //  而对于方法public void setAge(int age) {  }
        method = clazz.getDeclaredMethod("setAge", Integer.class);
        System.out.println(method);
        //  这样写是获取不到的，如果方法的参数类型是int型
        //  如果方法用于反射，那么要么int类型写成Integer： public void setAge(Integer age) {  }
        //   要么获取方法的参数写成int.class
        //
        //2.执行方法
        //  invoke第一个参数表示执行哪个对象的方法，剩下的参数是执行方法时需要传入的参数
        Object obje = clazz.newInstance();
        method.invoke(obje,2);

        //私有方法的执行，必须在调用invoke之前加上一句method.se//如果一个方法是私有方法，第三步是可以获取到的，但是这一步却不能执行
        // tAccessible（true）;
    }

}
