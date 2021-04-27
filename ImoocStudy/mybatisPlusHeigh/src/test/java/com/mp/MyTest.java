package com.mp;


import com.baomidou.mybatisplus.core.MybatisConfiguration;
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
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class MyTest {


    @Resource
    UserMapper userMapper;

    @Test
    public void deleteById() {
        int i = userMapper.deleteById(1094592041087729666L);
        System.out.println(" 影响行数  =" + i);
    }

    /**
     * 注意User表中delte字段加 @TableField(select = false)  注解和没加注解的区别
     */
    @Test
    public void select() {
        MybatisPlusConfigure.myTableName.set("user_heigh_2019");
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void updateById() {
        User user = new User();
        user.setAge(39);
        user.setId(1088248166370832385L);
        int i = userMapper.updateById(user);
        System.out.println(" i  =" + i);
    }

    //自定义时，delete 忽略不生效
    @Test
    public void mySelect() {
        List<User> userList = userMapper.mySelectList(Wrappers.<User>lambdaQuery().gt(User::getAge, 25));
        userList.forEach(System.out::println);
/**想 加限定条件
 *  1、在wrappers中加限定条件
 *  2、在sql中加限定条件
 */

    }

    @Test
    public void selectById() {
        User user = userMapper.selectById(1087982257332887553L);
        System.out.println(" 影响行数  =" + user);
    }
}
