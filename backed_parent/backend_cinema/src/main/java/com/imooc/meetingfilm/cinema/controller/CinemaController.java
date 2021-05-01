package com.imooc.meetingfilm.cinema.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.google.common.collect.Maps;
import com.imooc.meetingfilm.cinema.controller.vo.CinemaSavedReqVO;
import com.imooc.meetingfilm.cinema.controller.vo.DescribeCinemaRespVO;
import com.imooc.meetingfilm.cinema.service.CinemaServiceAPI;
import com.imooc.meetingfilm.utils.Exception.CommonServiceException;
import com.imooc.meetingfilm.utils.common.vo.BasePageVO;
import com.imooc.meetingfilm.utils.common.vo.BaseResponseVo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/cinemas")
@RestController
public class CinemaController {

    @Autowired
    CinemaServiceAPI serviceAPI;

    @RequestMapping(value = "/cinema:add", method = RequestMethod.POST)
    public BaseResponseVo saveCinema(@RequestBody CinemaSavedReqVO reqVO) throws CommonServiceException {
        serviceAPI.saveCinema(reqVO);
        return BaseResponseVo.success();
    }

    public BaseResponseVo fallbackMethod(BasePageVO basePageVO) throws CommonServiceException {
        Map<String, Object> result = Maps.newHashMap();
        result.put("code", 500);
        result.put("message", "请求降级处理返回");

        return BaseResponseVo.success(result);
    }

    @HystrixCommand(fallbackMethod = "fallbackMethod",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")
            },
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "1"),
                    @HystrixProperty(name = "maxQueueSize", value = "10"),
                    @HystrixProperty(name = "keepAliveTimeMinutes", value = "1000"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "8"),
                    @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1500")
            },ignoreExceptions=CommonServiceException.class)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public BaseResponseVo describeCinemas(BasePageVO basePageVO) throws CommonServiceException {

        IPage<DescribeCinemaRespVO> describeCinemaRespVOIPage = serviceAPI.describeCinemas(basePageVO.getNowPage(), basePageVO.getPageSize());
        //调用封装的分页返回方法
        if(basePageVO.getNowPage() >10000){
            throw new CommonServiceException(400,"nowPage 太大了，不支持");
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

        return BaseResponseVo.success();
    }
}
