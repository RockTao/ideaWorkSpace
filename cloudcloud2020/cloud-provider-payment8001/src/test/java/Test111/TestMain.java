package Test111;

import org.junit.Test;

import java.util.Arrays;

public class TestMain {

    @Test
    public void Test1(){
        System.out.println( Arrays.asList("Hello", "World", "How", "Are", "You")
                .stream()
                .map( s -> "_" + s + "_")
                .reduce( (s1, s2) -> s1 + "," + s2)
                .get());

    }
    @Test
    public void test2(){

        System.out.println(fun(221629));
        System.out.println(fun(203350));
//        181154
//        B. 221629
//        C. 203350
//        D. 因为程序异常，不可判断
    }
    public  String fun(int value) {
        char[] m = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        int len = m.length;
        int d = value / len;
        int r = value % len;
        return (d == 0) ? String.valueOf(m[r]) : fun(d) + m[r];
    }
}
