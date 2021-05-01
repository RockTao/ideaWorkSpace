package com.example.demo.basic;

public class Example {
    String str=new String("good");
    char[]  ch ={'a','b','c'};
    public static void main(String[] args) {
        Example example = new Example();
        example.change(example.str, example.ch);
        System.out.println(example.str + " and ");
        System.out.println(example.ch);
    }
    public void change(String str,char ch[]){
        str="test ok";
        ch[0]='g';
    }
}
