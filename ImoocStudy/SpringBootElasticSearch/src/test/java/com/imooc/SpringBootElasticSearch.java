package com.imooc;


import com.imooc.entity.es.EsBlog;
import com.imooc.repository.es.EsBlogRepository;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootElasticSearch {

    @Autowired
    EsBlogRepository esBlogRepository;
    @Test
    public void test(){

        Iterable<EsBlog> all = esBlogRepository.findAll();
        Iterator<EsBlog> iterator = all.iterator();
        EsBlog next = iterator.next();
        System.out.println("--------" + next.getTitle());
    }
}
