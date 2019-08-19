package com.example.multiplethread;

import com.example.multiplethread.service.AsyncService;
import com.example.multiplethread.service.FutureService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiplethreadApplicationTests {

    @Resource
    private AsyncService asyncService;

    @Test
    public void asyncTest() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            asyncService.executeAsync1();
            asyncService.executeAsync2();
        }
        Thread.sleep(1000);
    }

    @Resource
    private FutureService futureService;

    @Test
    public void futureTest() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        System.out.println("开始");
        Future<String> future = futureService.futureTest();
        //另外一个耗时任务
        Thread.sleep(500);
        System.out.println("另外一个耗时任务，需要500ms");

        String s = future.get();
        System.out.println("计算结果输出:" + s);
        System.out.println("共耗时：" + (System.currentTimeMillis() - start));
        Thread.sleep(5000);


    }
}
