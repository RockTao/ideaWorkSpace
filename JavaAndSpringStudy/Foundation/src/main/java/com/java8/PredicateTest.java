package com.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/*

 */
public class PredicateTest {

    //使用java8的predicate操作集合
    @Test
    public void testPredicate() {
        Collection<Integer> collection = new ArrayList<>();
        // 添加0-49
        for (int i = 0; i < 50; i++) {
            collection.add(i);
        }

        // 移除10-49的数字
        collection.removeIf(e -> (e > 9 && e < 50));
        System.out.println(collection);// 输出[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    }

}
