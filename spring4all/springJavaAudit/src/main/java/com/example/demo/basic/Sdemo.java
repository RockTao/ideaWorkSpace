package com.example.demo.basic;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Sdemo {
    public static void main(String[] args) {

        ExpressionParser parser = new SpelExpressionParser();

        String expression = "T(java.lang.Runtime).getRuntime().exec('gnome-calculator')";//构造好的SpEL表达式

        String result = parser.parseExpression(expression).getValue().toString();//解析SpEL


    }
}