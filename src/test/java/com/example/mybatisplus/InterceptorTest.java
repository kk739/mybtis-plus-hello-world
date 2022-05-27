package com.example.mybatisplus;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: InterceptorTest
 * @Decription: TODO
 * @Author: 陈云博
 * @Date: 2022/5/15
 * @Version:1.0
 **/
@SpringBootTest
public class InterceptorTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelectPage() {
        Page<User> userPage = new Page<>(1, 5);
        Page<User> userPage1 = userMapper.selectPage(userPage, null);
        List<User> records = userPage1.getRecords();
        records.forEach(System.out::println);

        boolean b = userPage1.hasNext();
        System.out.println("总页数：" + userPage1.getPages());
        System.out.println("getSize():"+userPage1.getSize());
        System.out.println("getTotal():"+userPage1.getTotal());
        System.out.println("是否有下一页：" + b);
    }

    @Test
    public void testSelectPageByAge(){
        Page<User> userPage = new Page<>(1, 5);
        IPage<User> userIPage = userMapper.selectPageByAge(userPage, 12);
        List<User> records = userIPage.getRecords();
        records.forEach(System.out::println);
    }
}
