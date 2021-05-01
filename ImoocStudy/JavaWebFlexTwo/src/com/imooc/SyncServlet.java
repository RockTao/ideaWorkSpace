package com.imooc;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//@javax.servlet.annotation.WebServlet(name = "SyncServlet")
@WebServlet("/SyncServlet")
public class SyncServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        long t1 = System.currentTimeMillis();
//        执行业务代码
        doSomeThing(request, response);
        System.out.println("Sync user  ; " + (System.currentTimeMillis() - t1));
    }

    private void doSomeThing(HttpServletRequest request, HttpServletResponse response) throws IOException {

//        模拟耗时操作
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        response.getWriter().append("done");
    }
}
