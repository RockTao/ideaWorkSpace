package com.mp.curd;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mp.dao.UserMapper;
import com.mp.entiry.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class deleteTest {


    @Resource
    private UserMapper mapper;

    @Test
    public void deleteById() {
        int rows = mapper.deleteById(1094592041087729674L);
        System.out.println("  rows=" + rows);

    }

    @Test
    public void deleteByMaps() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "向后");
        map.put("name", 25);
        int rows = mapper.deleteByMap(map);
        System.out.println(" rows " + rows);
    }

    @Test
    public void deleteByBatchids() {
        int ids = mapper.deleteBatchIds(Arrays.asList(1094592041087729673L, 1094592041087729672L, 1094592041087729671L));
        System.out.println(" ids = " + ids);
    }

    @Test
    public void deleteByWrappers() {
        LambdaQueryWrapper<User> queryWrapper = Wrappers.<User>lambdaQuery();
        queryWrapper.eq(User::getAge, 27).or().gt(User::getAge, 41);
        int rows = mapper.delete(queryWrapper);
        System.out.println("删除条目" + rows);

    }


}
