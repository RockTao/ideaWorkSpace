package com.example.demo.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack {
    //存储元素的数组,声明为Object类型能存储任意类型的数据
    private Object[] elementData;
    //指向栈顶的指针
    private int top;
    //栈的总容量
    private int size;

    //默认构造一个容量为10的栈
    public ArrayStack() {
        this.elementData = new Object[10];
        this.top = -1;
        this.size = 10;
    }

    public ArrayStack(int initalCapacity) {
        if (initalCapacity < 0) {
            throw new IllegalArgumentException("栈初始化容量不能小于0:" + initalCapacity);
        }
        this.elementData = new Object[initalCapacity];
        this.top = -1;
        this.size = initalCapacity;
    }

    //压入元素
    public Object push(Object item) {
        //是否需扩容
        isGrow(top + 1);
        elementData[++top] = item;
        return item;
    }

    //弹出栈顶元素
    public Object pop() {
        Object obj = peek();
        remove(top);
        return obj;
    }

    //获取栈顶元素
    public Object peek() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        return elementData[top];
    }

    //判断栈是否为空
    public boolean isEmpty() {
        return (top == -1);
    }

    //删除栈顶元素
    public void remove(int top) {
        //栈顶元素置为null
        elementData[top] = null;
        this.top--;
    }


    public boolean isGrow(int minCapacity) {

        int oldCapacity = size;
        if (minCapacity >= oldCapacity) {
            int newCapacity = 0;
            if ((oldCapacity << 1) - Integer.MAX_VALUE > 0) {
                newCapacity = Integer.MAX_VALUE;
            } else {
                newCapacity = (oldCapacity << 1);
            }
            this.size = newCapacity;
            int[] newArray = new int[size];
            elementData = Arrays.copyOf(elementData, size);
            return true;
        } else {
            return false;
        }
    }

}
