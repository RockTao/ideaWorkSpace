package com.example.demo.myArray;

public class MyArrayTest {
    public static void main(String[] args) {

        MyArray array = new MyArray(4);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);

        array.display();
        int i = array.get(0);
        System.out.println("i=" + i);

        array.delete(4);

        array.modify(3, 33);
        array.display();


    }
}
