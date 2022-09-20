package com.imooc.repository.es;

import com.imooc.entity.es.EsBlog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsBlogRepository  extends ElasticsearchRepository<EsBlog,Integer> {
}
