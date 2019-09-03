package com.example.demo.token.service;

import com.example.demo.token.entity.User;
//import com.example.demo.token.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jinbin
 * @date 2018-07-08 20:52
 */
@Service("UserService")
public class UserService {
//    @Resource
//    UserMapper userMapper;


    public User findByUsername(User user){
        User user1 = new User();
        user1.setUsername("admin");
        user1.setId("10011");
        user1.setPassword("123456");
        return user1;
//        return userMapper.findByUsername(user.getUsername());
    }
    public User findUserById(String userId) {
//        return userMapper.findUserById(userId);
        User user1 = new User();
        user1.setUsername("admin");
        user1.setId("10011");
        user1.setPassword("123456");
        return user1;
    }

}