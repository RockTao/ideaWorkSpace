package com.mp;


import com.mp.dao.UserMapper;
import com.mp.entiry.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleTest {

    @Resource
    private UserMapper mapper;

    @Test
    public void select() {
        List<User> list = mapper.selectList(null);
        Assert.assertEquals(5, list.size());
        list.forEach(System.out::println);
    }


}
