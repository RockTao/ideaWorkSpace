package com.mp.curd;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.mp.dao.UserMapper;
import com.mp.entiry.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RetrieveTest {

    @Resource
    private UserMapper mapper;

    @Test
    public void selectById() {
        User user = mapper.selectById(1094590409767661570L);
        System.out.println(user);
    }

    @Test
    public void selectByIds() {
        List<Long> lists = Arrays.asList(1094590409767661570L, 1094592041087729666L, 1094592041087729671L);
        List<User> users = mapper.selectBatchIds(lists);
        users.forEach(System.out::println);
//        System.out.println(user);
    }

    @Test
    public void selectByMap() {
//           map.put("name","王天风");
//           map.put("age","25");
//        where name ="王天风“ and age = 25
//        key  存的数据库中的列
        Map<String, Object> map = new HashMap<>();
//        map.put("name","王天风");
        map.put("age", "26");
        List<User> users = mapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    /**
     * 1、名字中包含雨并且年龄小于40
     * name like '%雨%' and age<40
     */
    @Test
    public void selectByWrapper() {
//        两种创建方式
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<User> query = Wrappers.<User>query();
        queryWrapper.like("name", "雨").lt("age", 40);
        query.like("name", "雨").lt("age", 40);
        List<User> userList = mapper.selectList(queryWrapper);
        userList.forEach(System.out::println);


    }

    /**
     * 2、名字中包含雨年并且龄大于等于20且小于等于40并且email不为空
     * name like '%雨%' and age between 20 and 40 and email is not null
     */
    @Test
    public void selectByWrapper2() {
        QueryWrapper<User> query = Wrappers.<User>query();
        query.like("name", "雨").between("age", 20, 40).isNotNull("email");
        List<User> userList = mapper.selectList(query);
        userList.forEach(System.out::println);

    }

    /**
     * 3、名字为王姓或者年龄大于等于25，按照年龄降序排列，年龄相同按照id升序排列
     * name like '王%' or age>=25 order by age desc,id asc
     */
    @Test
    public void selectByWrapper3() {
        QueryWrapper<User> query = Wrappers.<User>query();
        query.like("name", "王").or().ge("age", 25).orderByDesc("age").orderByAsc("id");
        List<User> userList = mapper.selectList(query);
        userList.forEach(System.out::println);
    }

    /**
     * 4、创建日期为2019年2月14日并且直属上级为名字为王姓
     * date_format(create_time,'%Y-%m-%d')='2019-02-14' and manager_id in (select id from user where name like '王%')
     */
    @Test
    public void selectByWrapper4() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.apply("date_format(create_time,'%Y-%m-%d')= {0}", "2019-02-14")
                .inSql("manager_id", "select id from user where name like '王%'");


        List<User> userList = mapper.selectList(queryWrapper);
        userList.forEach(System.out::println);

    }

    /**
     * 5、名字为王姓并且（年龄小于40或邮箱不为空）
     * name like '王%' and (age<40 or email is not null)
     */
    @Test
    public void selectByWrapper5() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("name", "王").and(wq -> wq.lt("age", 40).or().isNotNull("email"));

        List<User> userList = mapper.selectList(queryWrapper);
        userList.forEach(System.out::println);

    }

    /**
     * 6、名字为王姓或者（年龄小于40并且年龄大于20并且邮箱不为空）
     * name like '王%' or (age<40 and age>20 and email is not null)
     */
    @Test
    public void selectByWrapper6() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("name", "王").or(wq -> wq.lt("age", 40)
                .gt("age", 20).isNotNull("email"));

        List<User> userList = mapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }


    /**
     * 7、（年龄小于40或邮箱不为空）并且名字为王姓
     * (age<40 or email is not null) and name like '王%'
     */
    @Test
    public void selectByWrapper7() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.nested(wq -> wq.lt("age", 40).or().isNotNull("email")).likeRight("name", "王");
        List<User> userList = mapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /**
     * 8、年龄为30、31、34、35
     * age in (30、31、34、35)
     */
    @Test
    public void selectByWrapper8() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("age", Arrays.asList(31, 34, 35, 32));
        List<User> userList = mapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /**
     * 9、只返回满足条件的其中一条语句即可
     * limit 1
     */
    @Test
    public void selectByWrapper9() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("age", Arrays.asList(31, 34, 35, 32)).last("limit 1");
        List<User> userList = mapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /**
     * 10、名字中包含雨并且年龄小于40(需求1加强版)
     * 第一种情况：select id,name
     * from user
     * where name like '%雨%' and age<40
     * 第二种情况：select id,name,age,email
     * from user
     * where name like '%雨%' and age<40
     */

    @Test
    public void selectByWrapperSuper() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name").like("name", "雨").lt("age", 40);
        List<User> userList = mapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /**
     * 第二种情况：select id,name,age,email
     * from user  where name like '%雨%' and age<40
     */
    @Test
    public void selectByWrapperSuper2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name").like("name", "雨").lt("age", 40)
                .select(User.class, info -> !info.getColumn().equals("create_time") && !info.getColumn().equals("manager_id"));
        List<User> userList = mapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }


    @Test
    public void selectByWrapperSuper3() {
        selectByWrapperSuperContrion("王", "");
    }

    public void selectByWrapperSuperContrion(String name, String email) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(name), "name", name).like(StringUtils.isNotEmpty(email), "email", email);
        List<User> userList = mapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }


    @Test
    public void selectByWrapperEntity() {
//        两种创建方式
        User whereUser = new User();
        whereUser.setName("刘红雨");
        whereUser.setAge(32);
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>(whereUser);
        List<User> userList = mapper.selectList(queryWrapper);
        userList.forEach(System.out::println);


    }

    @Test
    public void selectByWrapperAllEq() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "王天风");
//        map.put("age",25);
//        queryWrapper.allEq(map);


        map.put("age", null);
        queryWrapper.allEq(map, false);
        List<User> userList = mapper.selectList(queryWrapper);
        userList.forEach(System.out::println);


    }


    @Test
    public void selectByWrapperMaps() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.like("name", "雨").lt("age", 40).select("id", "name");
        List<Map<String, Object>> userList = mapper.selectMaps(queryWrapper);
        userList.forEach(System.out::println);


    }


    /**
     * 11、按照直属上级分组，查询每组的平均年龄、最大年龄、最小年龄。
     * 并且只取年龄总和小于500的组。
     * select avg(age) avg_age,min(age) min_age,max(age) max_age
     * from user
     * group by manager_id
     * having sum(age) <500
     */

    @Test
    public void selectByWrapperMaps2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.select("avg(age) avg_age", "min(age) min_age", "max(age) max_age").groupBy("manager_id")
                .having("sum(age) <{0}", 500);

        List<Map<String, Object>> userList = mapper.selectMaps(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void selectByWrapperObjs() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.like("name", "雨").lt("age", 40).select("id", "name");
        List<Object> userList = mapper.selectObjs(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void selectByWrapperCount() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.like("name", "雨").lt("age", 40);
        Integer userList = mapper.selectCount(queryWrapper);
        System.out.println(" 长度= " + userList);
    }

    @Test
    public void selectByWrapperOne() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.like("name", "雨").lt("age", 40);
        User userList = mapper.selectOne(queryWrapper);
        System.out.println(userList);
    }

    @Test
    public void selectlambda() {
        LambdaQueryWrapper<User> lambda = new QueryWrapper<User>().lambda();
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>();
        LambdaQueryWrapper<User> LambdaQuery = Wrappers.<User>lambdaQuery();
        LambdaQuery.like(User::getName, "雨").lt(User::getAge, 40);

        List<User> userList = mapper.selectList(LambdaQuery);
        userList.forEach(System.out::println);
    }

    /**
     * 5、名字为王姓并且（年龄小于40或邮箱不为空）
     * name like '王%' and (age<40 or email is not null)
     */
    @Test
    public void selectlambda2() {
        LambdaQueryWrapper<User> LambdaQuery = Wrappers.<User>lambdaQuery();
        LambdaQuery.likeRight(User::getName, "").and(lqs -> lqs.lt(User::getAge, 40).or().isNotNull(User::getEmail));

        List<User> userList = mapper.selectList(LambdaQuery);
        userList.forEach(System.out::println);
    }

    @Test
    public void selectlambda3() {
        List<User> list = new LambdaQueryChainWrapper<User>(mapper).like(User::getName, "雨").ge(User::getAge, 20).list();
        list.forEach(System.out::println);

    }

    @Test
    public void selectMy() {
        LambdaQueryWrapper<User> LambdaQuery = Wrappers.<User>lambdaQuery();
        LambdaQuery.likeRight(User::getName, "王")
                .and(lqs -> lqs.lt(User::getAge, 40).or().isNotNull(User::getEmail));

        List<User> userList = mapper.selectALL(LambdaQuery);
        userList.forEach(System.out::println);
    }

    // 分页查询  两种方法
    @Test
    public void selectPage() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age", 26);
        Page<User> userPage = new Page<>(1, 2);

        /** IPage<User> selectPage = mapper.selectPage(userPage, queryWrapper);
         System.out.println(" 总页数"+ selectPage.getPages());
         System.out.println(" 总分页记录数"+selectPage.getTotal());
         List<User> userList = selectPage.getRecords();
         userList.forEach(System.out::println);
         **/

        IPage<Map<String, Object>> iPage = mapper.selectMapsPage(userPage, queryWrapper);
        System.out.println(" 总页数" + iPage.getPages());
        System.out.println(" 总分页记录数" + iPage.getTotal());
        List<Map<String, Object>> userList = iPage.getRecords();
        userList.forEach(System.out::println);
    }

    @Test
    public void selectMyPage() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age", 25);
        Page<User> userPage = new Page<>(1, 2);

        IPage<User> selectPage = mapper.selectUserPage(userPage, queryWrapper);
        System.out.println(" 总页数" + selectPage.getPages());
        System.out.println(" 总分页记录数" + selectPage.getTotal());
        List<User> userList = selectPage.getRecords();
        userList.forEach(System.out::println);

    }

}
