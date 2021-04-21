package com.mp.curd;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mp.entiry.User;
import com.mp.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class serviceTest {

    @Resource
    UserService userService;

    @Test
    public void getOne() {
        User one = userService.getOne(Wrappers.<User>lambdaQuery().gt(User::getAge, 25), false);
        System.out.println(one);
    }

    @Test
    public void Batch() {
        User user = new User();
        user.setName("徐丽3");
        user.setAge(30);
        User user1 = new User();
        user1.setId("1303000058727337986");
        user1.setName("徐丽4");
        user1.setAge(29);
        List<User> userList = Arrays.asList(user, user1);
        boolean b = userService.saveOrUpdateBatch(userList);
        System.out.println(b);
    }

    @Test
    public void chain() {

        List<User> users = userService.lambdaQuery().gt(User::getAge, 25).like(User::getName, "雨").list();
        users.forEach(System.out::println);
    }

    @Test
    public void chain1() {

        boolean update = userService.lambdaUpdate().eq(User::getAge, 25).set(User::getAge, 26).update();
        System.out.println(update);
    }

    @Test
    public void chain2() {

        boolean remove = userService.lambdaUpdate().eq(User::getAge, 24).remove();
        System.out.println(remove);
    }

}