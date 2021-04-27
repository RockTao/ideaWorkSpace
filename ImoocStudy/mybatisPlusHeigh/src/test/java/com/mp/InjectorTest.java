package com.mp;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mp.config.MybatisPlusConfigure;
import com.mp.dao.UserMapper;
import com.mp.entiry.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class InjectorTest {


    @Resource
    UserMapper userMapper;

    @Test
    public void deleteAll() {
        int i = userMapper.deleteAll();
        System.out.println(" 影响行数  =" + i);
    }

    @Test
    public void insertBatchSomeColumn() {
        User user = new User();
        user.setName("李新华2");
        user.setAge(34);
        user.setManagerId(1088248166370832385L);

        User user1 = new User();
        user1.setName("杨红2");
        user1.setAge(29);
        user1.setManagerId(1088248166370832385L);
        List<User> users = Arrays.asList(user, user1);
        int column = userMapper.insertBatchSomeColumn(users);
        System.out.println("影响行数，" + column);
    }


    @Test
    public void deleteByIdWithFill () {
        User user = new User();
        user.setId(1387059896247181313L);
        user.setAge(35);
        int i = userMapper.deleteByIdWithFill(user);
        System.out.println("---------   "+i);
    }
    @Test
    public void alwaysUpdateSomeColumnById () {
        User user = new User();
        user.setId(1088248166370832385L);
        user.setAge(26);
        user.setName("王第放");
        int i = userMapper.deleteByIdWithFill(user);
        System.out.println("---------   "+i);
    }
}
