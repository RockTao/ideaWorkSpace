package com.example.demo.myArray;

public class MyArray {
    //定义一个数组
    private int[] intArrays;
    //定义数组的实际有效长度
    private int elems;
    private int length;//定义数组的最大长度

    //默认构造一个长度为50的数组
    public MyArray() {
        elems = 0;
        length = 50;
        intArrays = new int[length];
    }

    //构造函数，初始化一个长度为length 的数组
    public MyArray(int length) {
        elems = 0;
        this.length = length;
        intArrays = new int[length];
    }

    //获取数组的有效长度
    public int getSize() {
        return elems;
    }

    //遍历显示元素
    public void display() {
        for (int i = 0; i < elems; i++) {
            System.out.print(intArrays[i] + " ");
        }
        System.out.println();
    }

    /**
     * 添加元素
     *
     * @param value 假设操作人是不会添加重复元素的，如果有重复元素对于后面的操作都会有影响。
     * @return添加成功返回true,添加的元素超过范围了返回false
     */
    public boolean add(int value) {
        if (elems == length) {
            return false;
        } else {
            intArrays[elems] = value;
            elems++;
        }
        return true;
    }

    /**
     * @param i
     * @return 查找下标值在数组下标有效范围内，返回下标所表示的元素
     * 查找下标超出数组下标有效值，提示访问下标越界
     */
    public int get(int i) {
        if (i < 0 || i > elems) {
            System.out.println("访问下标越界");
        }
        return intArrays[i];
    }

    /**
     * 查找元素
     *
     * @param searchValue
     * @return 查找的元素如果存在则返回下标值，如果不存在，返回 -1
     */
    public int find(int searchValue) {
        int i;
        for (i = 0; i < elems; i++) {
            if (intArrays[i] == searchValue) {
                break;
            }
        }
        if (i == elems) {
            return -1;
        }
        return i;
    }

    public boolean delete(int value) {
        int k = find(value);
        if (k == -1) {
            return false;
        } else {
            if (k == elems - 1) {
                elems--;
            } else {
                for (int i = k; i < elems - 1; i++) {
                    intArrays[i] = intArrays[i + 1];
                }
                elems--;
            }
            return true;
        }
    }

    public boolean modify(int oldvalue, int newValue) {
        int i = find(oldvalue);
        if (i == -1) {
            System.out.println("需要修改的数据不存在");
            return false;
        } else {
            intArrays[i] = newValue;
            return true;
        }
    }
}
