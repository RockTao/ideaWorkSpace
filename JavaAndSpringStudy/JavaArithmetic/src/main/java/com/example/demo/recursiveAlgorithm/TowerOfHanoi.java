package com.example.demo.recursiveAlgorithm;

import org.junit.jupiter.api.Test;

/**
 * 汉诺塔问题是由很多放置在三个塔座上的盘子组成的一个古老的难题。如下图所示，所有盘子的直径是不同的，并且盘子中央都有一个洞使得它们刚好可以放在塔座上。所有的盘子刚开始都放置在A 塔座上。这个难题的目标是将所有的盘子都从塔座A移动到塔座C上，每次只可以移动一个盘子，并且任何一个盘子都不可以放置在比自己小的盘子之上。
 * <p>
 * 试想一下，如果只有两个盘子，盘子从小到大我们以数字命名（也可以想象为直径），两个盘子上面就是盘子1，下面是盘子2，那么我们只需要将盘子1先移动到B塔座上，然后将盘子2移动到C塔座，最后将盘子1移动到C塔座上。即完成2个盘子从A到C的移动。
 * <p>
 * 　　如果有三个盘子，那么我们将盘子1放到C塔座，盘子2放到B塔座，在将C塔座的盘子1放到B塔座上，然后将A塔座的盘子3放到C塔座上，然后将B塔座的盘子1放到A塔座，将B塔座的盘子2放到C塔座，最后将A塔座的盘子1放到C塔座上。
 * <p>
 * 　　如果有四个，五个，N个盘子，那么我们应该怎么去做？这时候递归的思想就很好解决这样的问题了，当只有两个盘子的时候，我们只需要将B塔座作为中介，将盘子1先放到中介塔座B上，然后将盘子2放到目标塔座C上，最后将中介塔座B上的盘子放到目标塔座C上即可。
 * <p>
 * 　　所以无论有多少个盘子，我们都将其看做只有两个盘子。假设有 N 个盘子在塔座A上，我们将其看为两个盘子，其中(N-1)~1个盘子看成是一个盘子，最下面第N个盘子看成是一个盘子，那么解决办法为：
 * <p>
 * 　　①、先将A塔座的第(N-1)~1个盘子看成是一个盘子，放到中介塔座B上，然后将第N个盘子放到目标塔座C上。
 * <p>
 * 　　②、然后A塔座为空，看成是中介塔座，B塔座这时候有N-1个盘子，将第(N-2)~1个盘子看成是一个盘子，放到中介塔座A上，然后将B塔座的第(N-1)号盘子放到目标塔座C上。
 * <p>
 * 　　③、这时候A塔座上有(N-2)个盘子，B塔座为空，又将B塔座视为中介塔座，重复①，②步骤，直到所有盘子都放到目标塔座C上结束。
 */
public class TowerOfHanoi {

    public static void move(int dish, String from, String temp, String to) {
        if (dish == 1) {
            System.out.println("将盘子" + dish + "从塔座" + from + "移动到目标塔座" + to);
        } else {
            move(dish - 1, from, to, temp);//A为初始塔座，B为目标塔座，C为中介塔座
            System.out.println("将盘子" + dish + "从塔座" + from + "移动到目标塔座" + to);
            move(dish - 1, temp, from, to);//B为初始塔座，C为目标塔座，A为中介塔座
        }
    }

    @Test
    public void testTOwerOfHaoi() {
        move(5, "A", "B", "C");

    }
}