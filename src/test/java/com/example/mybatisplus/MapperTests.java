package com.example.mybatisplus;

import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: MapperTests
 * @Decription: TODO
 * @Author: 陈云博
 * @Date: 2022/5/1
 * @Version:1.0
 **/
@SpringBootTest
public class MapperTests {
    @Resource
    private UserMapper userMapper;

    @Test
    public void userInsert() {
        User user = new User();
        user.setName("建国007");
//        user.setName("10086");
        user.setEmail("jianguo@163.com");
//        user.setAge(23);
//        user.setCreateTime(LocalDateTime.now());
//        user.setUpdateTime(LocalDateTime.now());
        int insert = userMapper.insert(user);
        System.out.println("结果：" + insert);
    }

    @Test
    public void testSelect() {
        User user = userMapper.selectById(1);
        System.out.println(user);
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 3));
        users.forEach(System.out::println);
        Map<String, Object> map = new HashMap<>();
        map.put("name", "robort");
        map.put("age", 20);
        List<User> users1 = userMapper.selectByMap(map);
        users1.forEach(System.out::println);
    }

    @Test
    public void selectAllByName() {
        List<User> users = userMapper.selectAllByName("marry2");
        users.forEach(System.out::println);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(1524600171963027464l);
        user.setName("9999");
        user.setEmail("9999@qq.com");
        int i = userMapper.updateById(user);
        System.out.println("结果为：" + i);
    }

    @Test
    public void testDelete() {
        int result = userMapper.deleteById(1524600171963027470l);
        System.out.println("结果是：" + result);
    }
}
