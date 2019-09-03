package com.example.demo.service.impl;

import com.example.demo.entity.parseHtml;
import com.example.demo.mapper.SpiderMapper;
import com.example.demo.service.SpiderService;
import com.example.demo.util.JsoupUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpiderServiceImpl implements SpiderService {




    @Resource
    private SpiderMapper spidermapper;

    @Override
    public List<parseHtml> getAllUrl(String url, String regexClass) {
        List<parseHtml> list = JsoupUtil.regexHtml(url, regexClass);
        spidermapper.insertForeach(list);
        return list;
    }

    @Override
    public Integer insertOne(String url, String regexClass) {
        List<parseHtml> list = JsoupUtil.regexHtml(url, regexClass);
        for(int i=0;i<list.size();i++){
            spidermapper.insertOne(list.get(i));
        }
        return 0;
    }

    public parseHtml findById(Integer id) {
        return spidermapper.findById(id);
    }

    @Override
    public Integer updateById(parseHtml parse) {
        return spidermapper.updateById(parse);
    }

    @Override
    public Integer deleteById(parseHtml parse) {
        return spidermapper.deleteById(parse);
    }
}
