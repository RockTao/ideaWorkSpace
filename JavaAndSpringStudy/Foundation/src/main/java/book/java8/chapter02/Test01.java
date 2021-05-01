package book.java8.chapter02;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class Test01 {

    public static void main(String[] args) {

        Predicate<Integer> atLeast5 =x -> x > 5;
        System.out.println(atLeast5);
        BinaryOperator<Long> addLons = (x, y) -> x + y;
    }


}
