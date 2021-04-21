package com.example.demo.stack;

import org.junit.jupiter.api.Test;

public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        stack.push(1);
        //System.out.println(stack.peek());
        stack.push(2);
        stack.push(3);
        stack.push("abc");
        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.peek());
    }

    @Test
    public void testStringReversal() {
        ArrayStack stack = new ArrayStack();
        String str = "how are you";
        char[] cha = str.toCharArray();
        for (char c : cha) {
            stack.push(c);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }

    @Test
    public void testMatch() {
        ArrayStack stack = new ArrayStack(3);
        String str = "12<a[b{c}]>";
        char[] cha = str.toCharArray();
        for (char c : cha) {
            switch (c) {
                case '{':
                case '[':
                case '<':
                    stack.push(c);
                    break;
                case '}':
                case ']':
                case '>':
                    if (!stack.isEmpty()) {
                        char ch = stack.pop().toString().toCharArray()[0];
                        if (c == '}' && ch != '{'
                                || c == ']' && ch != '['
                                || c == ')' && ch != '(') {
                            System.out.println("Error:" + ch + "-" + c);
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
