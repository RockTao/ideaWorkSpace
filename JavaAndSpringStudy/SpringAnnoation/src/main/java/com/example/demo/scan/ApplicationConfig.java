package com.example.demo.scan;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@ComponentScan(value = "com.example.demo.bean", useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION,
                        value = {Controller.class, Service.class}),

//                @ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE,
//                        value={DeptDao.class})
        })
@Configuration
public class ApplicationConfig {
}
