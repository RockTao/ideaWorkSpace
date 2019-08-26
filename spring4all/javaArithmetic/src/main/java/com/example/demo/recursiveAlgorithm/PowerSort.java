package com.example.demo.recursiveAlgorithm;

import org.junit.jupiter.api.Test;

/**　①、求一个数的乘方
 　　一般稍微复杂一点的计算器上面都能求一个数的乘法，通常计算器上面的标志是 x^y 这样的按键，表示求 x 的 y 次方。一般情况下我们是如何求一个数的乘法的呢？
 　　比如2^8,我们可以会求表达式2*2*2*2*2*2*2*2 的值，但是如果y的值很大，这个会显得表达式很冗长。那么由没有更快一点方法呢？
 　　数学公式如下是成立的：
 　　(Xa)b = Xa*b
 　　如果如果求28次方，我们可以先假定22=a,于是28 = （22）4 ，那么就是a4 ；假定 a2 = b，那么 a4 = b2，而b2可以写成(b2)1。于是现在28就转换成：b*b
 　　也就是说我们将乘方的运算转换为乘法的运算。
 　　求xy的值，当y是偶数的时候，最后能转换成两个数相乘，当时当y是奇数的时候，最后我们必须要在返回值后面额外的乘以一个x。
     x^y= (x^2)^(y/2)，定义a=x^2,b=y/2, 则得到形如： x^y= a^b;
 */
public class PowerSort {

    public static int pow(int x,int y){
        if(x == 0 || x == 1){
            return x;
        }
        if(y > 1){
            int b = y/2;
            int a = x*x;
            if(y%2 == 1){//y为奇数
                return pow(a,b)*x;
            }else{//y为偶数
                return pow(a,b);
            }
        }else if(y == 0){
            return 1;
        }else{//y==1
            return x;
        }
    }
    @Test
    public void testPower(){
        System.out.println(pow(2,8));
    }

}
