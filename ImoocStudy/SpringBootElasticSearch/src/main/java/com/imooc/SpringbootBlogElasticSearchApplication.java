package com.imooc;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringbootBlogElasticSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBlogElasticSearchApplication.class, args);
        log.info("项目启动成功，访问地址：http://localhost:8081/");
    }

}
