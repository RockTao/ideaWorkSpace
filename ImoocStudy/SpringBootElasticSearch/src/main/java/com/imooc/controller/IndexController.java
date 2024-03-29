package com.imooc.controller;


import com.imooc.entity.mysql.MysqlBlog;
import com.imooc.repository.mysql.MysqlBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {


    @Autowired
    MysqlBlogRepository mysqlBlogRepository;
    @RequestMapping("/")
    public  String index(){
        List<MysqlBlog> all = mysqlBlogRepository.findAll();
        System.out.println(all.size());
        return "index.html";
    }
}
