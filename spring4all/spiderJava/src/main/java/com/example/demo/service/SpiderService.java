package com.example.demo.service;

import com.example.demo.entity.parseHtml;

import java.util.List;

public interface SpiderService {
    /**
     *
     * @param url
     * @param regexClass 匹配规则
     * @return
     */
    public List<parseHtml>  getAllUrl(String url,String regexClass);
    public Integer insertOne(String url,String regexClass);
    public parseHtml findById(Integer id);

    public Integer updateById(parseHtml parse);
    public Integer deleteById(parseHtml parse);
}
