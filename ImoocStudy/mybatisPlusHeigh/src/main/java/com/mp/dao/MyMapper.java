package com.mp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 将这个方法抽出来，做成公共的方法啦
 * @param <T>
 */
public interface MyMapper<T>  extends BaseMapper<T> {
    /**
     * 自定义sql注入器
     * @return
     */
    int deleteAll();



    int insertBatchSomeColumn(List<T> list);

    int deleteByIdWithFill(T entity);

    int alwaysUpdateSomeColumnById(@Param(Constants.ENTITY) T entity);
}
