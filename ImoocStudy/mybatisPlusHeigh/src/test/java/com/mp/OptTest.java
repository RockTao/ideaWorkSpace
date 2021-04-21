package com.mp;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mp.dao.UserMapper;
import com.mp.entiry.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 乐观锁测试
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OptTest {


    @Resource
    UserMapper userMapper;

    @Test
    public void update() {
        int version = 2;
        User user = new User();
        user.setEmail("ly3@babab.com");
        user.setVersion(version);
        QueryWrapper<User> query = Wrappers.<User>query();
        query.eq("name", "李玉");
        int insert = userMapper.update(user, query);
        System.out.println(" 影响行数  =" + insert);


        int version2 = 3;
        User user2 = new User();
        user2.setEmail("ly4@163.com");
        user2.setVersion(version2);
        query.eq("age", 25);

        int rows = userMapper.update(user2, query);
        System.out.println(" 影响行数  =" + rows);
    }


    @Test
    public void updateById() {
        int version = 1;
        User user = new User();
        user.setEmail("ly2@163.com");
        user.setId(1304085448078962690L);
        user.setVersion(version);
        int i = userMapper.updateById(user);
        System.out.println(" i  =" + i);
    }
}
