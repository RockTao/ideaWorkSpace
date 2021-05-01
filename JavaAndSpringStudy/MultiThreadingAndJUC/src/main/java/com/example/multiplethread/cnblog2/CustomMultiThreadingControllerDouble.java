package com.example.multiplethread.cnblog2;

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
@RequestMapping(value="/multithreading2")
public class CustomMultiThreadingControllerDouble {
    @Autowired
    private CustomMultiThreadingServiceDoube customMultiThreadingService2;


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