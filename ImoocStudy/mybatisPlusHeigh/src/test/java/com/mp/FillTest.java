package com.mp;


import com.mp.dao.UserMapper;
import com.mp.entiry.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FillTest {


    @Resource
    UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setName("李玉");
        user.setAge(25);
        user.setEmail("ly@babab.com");
        user.setManagerId(1088248166370832385L);
        int insert = userMapper.insert(user);
        System.out.println(" 影响行数  =" + insert);

    }


    @Test
    public void updateById() {
        User user = new User();
        user.setAge(29);
        user.setId(1088248166370832385L);
//        user.setUpdateTime(LocalDateTime.now());
        int i = userMapper.updateById(user);
        System.out.println(" i  =" + i);
    }
}
