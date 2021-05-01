package com.genericity;

import java.math.BigDecimal;

public class OrderTest {

    public static void main(String[] args) {
        // 3.5元的牛奶来自河北
        Order<String> order = new Order<>("牛奶", BigDecimal.valueOf(3.5),"河北");
        System.out.println(order.getProduct());
        // 10份辣条25元
        Order<Integer> laTiao = new Order<>("辣条",BigDecimal.valueOf(25),10);
        System.out.println(laTiao.getProduct());
    }
}
