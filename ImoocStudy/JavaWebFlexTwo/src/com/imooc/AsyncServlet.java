package com.imooc;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@WebServlet(asyncSupported = true, urlPatterns = {"/AsyncServlet"})
public class AsyncServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long t1 = System.currentTimeMillis();
//         开启异步
        AsyncContext asyncContext = request.startAsync();
        CompletableFuture.runAsync(() ->
        {
            try {
                doSomeThing(asyncContext, asyncContext.getRequest(), asyncContext.getResponse());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
//        执行业务代码
        doSomeThing(asyncContext, asyncContext.getRequest(), asyncContext.getResponse());
        System.out.println("ASync user  ; " + (System.currentTimeMillis() - t1));

    }

    private void doSomeThing(AsyncContext asyncContext, ServletRequest request, ServletResponse response) throws IOException {
//        模拟耗时操作
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        response.getWriter().append("done");

        asyncContext.complete();
    }
}
