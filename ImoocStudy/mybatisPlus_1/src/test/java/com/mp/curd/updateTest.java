package com.mp.curd;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.LambdaUpdateChainWrapper;
import com.mp.dao.UserMapper;
import com.mp.entiry.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class updateTest {

    @Resource
    private UserMapper mapper;

    @Test
    public void UpdateById() {
        User user = new User();
//        user.setId(1088248166370832385L);
        user.setAge(36);
        user.setEmail("update@163.com");
        int flag = mapper.updateById(user);
        System.out.println("---- " + flag);
    }


    /**
     * DEBUG==>  Preparing: UPDATE user SET age=?, email=? WHERE name = ? AND age = ?
     * DEBUG==> Parameters: 29(Integer), lyw2020@163.com(String), 李艺伟(String), 28(Integer)
     * DEBUG<==    Updates: 1
     */

    @Test
    public void UpdateByWrapper() {
        UpdateWrapper<User> wrapper = new UpdateWrapper<User>();
        wrapper.eq("name", "李艺伟").eq("age", 28);
        User user = new User();
        user.setEmail("lyw2020@163.com");
        user.setAge(29);
        int update = mapper.update(user, wrapper);
        System.out.println("--- " + update);
    }

    @Test
    public void UpdateByWrapper1() {
        User whereuser = new User();
        whereuser.setName("李艺伟");
        UpdateWrapper<User> wrapper = new UpdateWrapper<User>();
        wrapper.eq("name", "李艺伟").eq("age", 28);
        User user = new User();
        user.setEmail("lyw2020@163.com");
        user.setAge(29);
        int update = mapper.update(user, wrapper);
        System.out.println("--- " + update);
    }

    @Test
    public void UpdateByWrapper2() {
        UpdateWrapper<User> wrapper = new UpdateWrapper<User>();
        wrapper.eq("name", "李艺伟").eq("age", 29).set("age", 33);
        int update = mapper.update(null, wrapper);
        System.out.println("--- " + update);
    }

    @Test
    public void UpdateByWrapperLambda() {
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = Wrappers.<User>lambdaUpdate();
        lambdaUpdateWrapper.eq(User::getName, "李艺伟").eq(User::getAge, 33).set(User::getAge, 31);

        int update = mapper.update(null, lambdaUpdateWrapper);
        System.out.println("--- " + update);
    }

    @Test
    public void UpdateByWrapperLambdaChain() {
        boolean update1 = new LambdaUpdateChainWrapper<User>(mapper).eq(User::getName, "李艺伟")
                .eq(User::getAge, 31).set(User::getAge, 32).update();
        System.out.println("--- " + update1);
    }
}
