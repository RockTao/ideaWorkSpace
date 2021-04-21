//package com.mp.curd;
//
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.core.toolkit.Wrappers;
//import com.mp.dao.UserMapper;
//import com.mp.entiry.User;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//import java.time.LocalDateTime;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ARTest {
//
//
//    @Resource
//    private UserMapper mapper;
//    @Test
//    public void insert(){
//        User user = new User();
//        user.setName("zhang中");
//        user.setAge(25);
//        user.setEmail("xz@123456.com");
//        user.setManagerId(1088248166370832385L);
//        user.setCreateTime(LocalDateTime.now());
//        boolean insert = user.insert();
//        System.out.println("影响的记录数 ="+ insert);
//    }
//    @Test
//    public void selectById(){
//        User user = new User();
//        User user1 = user.selectById(1094592041087729677L);
//        System.out.println("影响的记录数 ="+(user1 == user));
//        System.out.println("影响的记录数 ="+ user1);
//    }
//    @Test
//    public void updateById(){
//        User user = new User();
//        user.setId(1094592041087729677L);
//        user.setName("XXXXX");
//        boolean bbb = user.updateById();
//
//        System.out.println("影响的记录数 ="+ bbb);
//    }
//    @Test
//    public void deleteById(){
//        User user = new User();
//        user.setId(1094592041087729677L);
//        boolean bbb = user.deleteById();
//        System.out.println("影响的记录数 ="+ bbb);
//    }
//    @Test
//    public void insertOrUpdate(){
//        User user = new User();
//        user.setId(1094592041087729678L);
//        user.setName("张强---");
//        user.setAge(25);
//        user.setEmail("zq@123456.com");
//        user.setManagerId(1088248166370832385L);
//        user.setCreateTime(LocalDateTime.now());
//        boolean b = user.insertOrUpdate();
//        System.out.println("b =" +b);
//    }
//
//
//
//
//}
