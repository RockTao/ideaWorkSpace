package com.example.demo.basic;

import java.io.IOException;

public class Cmd1 {
    public static void main(String[] args){

        String cmd = "gnome-calculator";//gnome-calculator计算器进程名

        try {

            Process ps = Runtime.getRuntime().exec(cmd);//执行命令

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
