package com.mp.dao;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.mp.entiry.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface UserMapper extends BaseMapper<User> {

//    @SqlParser(filter = true)//不增加租户信息   mp版本3.1之前的需要在全局配置中设置
    @Select("select * from user_heigh ${ew.customSqlSegment}")
    List<User> mySelectList(@Param(Constants.WRAPPER) Wrapper<User> wrapper);

    /**
     * 自定义sql注入器
     * @return
     */
//    int deleteAll();
}
