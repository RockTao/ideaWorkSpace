package com.example.demo.mapper;

import com.example.demo.entity.parseHtml;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SpiderMapper {

    public parseHtml findById(Integer id);

    Integer insertForeach(List<parseHtml> list);

    Integer insertOne(parseHtml parse);

    public Integer updateById(parseHtml parse);

    public Integer deleteById(parseHtml parse);

}
