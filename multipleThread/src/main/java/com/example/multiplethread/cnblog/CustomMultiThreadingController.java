package com.example.multiplethread.cnblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Description:自定义多线程Controller
 * @ClassName: CustomMultiThreadingController
 * @Author: OnlyMate
 * @Date: 2018年9月21日 下午3:02:49
 */
@Controller
@RequestMapping(value="/multithreading")
public class CustomMultiThreadingController {
    @Autowired
    private CustomMultiThreadingService customMultiThreadingService;

    @Autowired
    private com.example.multiplethread.cnblog2.CustomMultiThreadingServiceDoube customMultiThreadingService2;

    @ResponseBody
    @RequestMapping(value="/dotask")
    public String doTask() {
        for (int i=0;i<10;i++){
            customMultiThreadingService.executeAysncTask1(i);
            customMultiThreadingService.executeAsyncTask2(i);
        }

        return "success";
    }

    @ResponseBody
    @RequestMapping(value="/dojob")
    public String doJob() {
        for (int i=0;i<10;i++){
            customMultiThreadingService2.executeAysncTask1(i);
            customMultiThreadingService2.executeAsyncTask2(i);
//            customMultiThreadingService2.executeAsyncTask3(i);
        }
        return "success";
    }
}