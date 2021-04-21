package com.example.demo.basic;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

public class Cmd2 {
    public static void main(String[] args) {
        String cmd = "ifconfig";

        try {
            Process run = Runtime.getRuntime().exec(cmd);//执行
            InputStream is = run.getInputStream();//取得执行结果输出流
            InputStreamReader isr = new InputStreamReader(is);//读输出流读取
            BufferedReader br = new BufferedReader(isr);//缓冲器读取
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
