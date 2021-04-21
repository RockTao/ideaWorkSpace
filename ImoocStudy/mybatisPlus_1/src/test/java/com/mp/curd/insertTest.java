package com.mp.curd;


import com.mp.dao.UserMapper;
import com.mp.entiry.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class insertTest {

    @Resource
    private UserMapper mapper;

    @Test
    public void insert() {
        User user = new User();
        user.setName("千Two图");
        user.setAge(25);
        user.setEmail("xx@163.com");
        user.setManagerId(1088248166370832385L);
        user.setCreateTime(LocalDateTime.now());
        int flag = mapper.insert(user);
        Assert.assertEquals(1, flag);
        System.out.println("主键为：" + user.getId());
    }


}
