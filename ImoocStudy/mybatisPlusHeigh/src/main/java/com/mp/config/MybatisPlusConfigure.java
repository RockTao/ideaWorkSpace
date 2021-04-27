package com.mp.config;


import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.core.parser.ISqlParserFilter;
import com.baomidou.mybatisplus.core.parser.SqlParserHelper;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.parsers.DynamicTableNameParser;
import com.baomidou.mybatisplus.extension.parsers.ITableNameHandler;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.HashMap;

@Configuration
public class MybatisPlusConfigure {
    public static  ThreadLocal<String> myTableName = new ThreadLocal<>();

    /**
     * 3.1.1以下版本需要配置,3.1.1版本以上默认的配置
     * @return
     */
//    @Bean
//   public ISqlInjector sqlInjector() {
//        return new LogicSqlInjector();
//    }

//    乐观锁插件
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    /**
     * x性能分析插件   生产环境不开启
     */
    @Profile({"dev", "test"})
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor interceptor = new PerformanceInterceptor();
        interceptor.setFormat(true);
        interceptor.setMaxTime(5L);
        return interceptor;
    }

    /**
     * 多租户解析器
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        ArrayList<ISqlParser> sqlParserList = new ArrayList<ISqlParser>();
//        TenantSqlParser tenantSchemaSqlParser = new TenantSqlParser();
//        tenantSchemaSqlParser.setTenantHandler(new TenantHandler(){
////            租户信息
//            @Override
//            public Expression getTenantId() {
////                租户信息，租户实际的值
//                return new LongValue(1088248166370832385L);
//            }
////            表中字段名
//            @Override
//            public String getTenantIdColumn() {
//                return  "manager_id"; //表中的字段名
//            }
//
//            @Override
//            public boolean doTableFilter(String tableName) {
////                if("user_heigh".equals(tableName)){
////                    return  true;
////                }
//                return false;
//            }
//        });
//        sqlParserList.add(tenantSchemaSqlParser);

        /**
         * 动态表变sql解析器
         */
        DynamicTableNameParser dynamicTableNameParser = new DynamicTableNameParser();
        HashMap<String , ITableNameHandler> tableNameHandlerHashMap = new HashMap<>();
        tableNameHandlerHashMap.put("user_heigh", new ITableNameHandler() {
            @Override
            public String dynamicTableName(MetaObject metaObject, String sql, String tableName) {
                return myTableName.get();
            }
        });
        dynamicTableNameParser.setTableNameHandlerMap(tableNameHandlerHashMap);

        sqlParserList.add(dynamicTableNameParser);
        paginationInterceptor.setSqlParserList(sqlParserList);
//        匿名内部类  过滤特定sql
        paginationInterceptor.setSqlParserFilter(new ISqlParserFilter() {
            @Override
            public boolean doFilter(MetaObject metaObject) {
                MappedStatement ms = SqlParserHelper.getMappedStatement(metaObject);
                if("com.mp.dao.UserMapper.selectById".equals(ms.getId())){
                    return  true;
                }
                return false; //标识不过滤，都增加租户信息
            }

        });
        return paginationInterceptor;
    }


}

