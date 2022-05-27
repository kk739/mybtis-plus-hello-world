package com.example.mybatisplus;

import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ServiceTest
 * @Decription: TODO
 * @Author: 陈云博
 * @Date: 2022/5/12
 * @Version:1.0
 **/
@SpringBootTest
public class ServiceTest {
    @Resource
    private UserService userService;

    @Test
    public void testCount() {
        long count = userService.count();
        System.out.println("总记录数：" + count);
    }

    @Test
    public void testSaveBatch() {
        ArrayList<User> userList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setAge(15 + i);
            user.setName("marry" + i);
            user.setEmail("marry" + i + "@163.com");
            userList.add(user);
        }
        boolean b = userService.saveBatch(userList);
        System.out.println("result:" + b);

    }

    @Test
    public void testSelectAllByName(){
        List<User> marry1 = userService.selectAllByName("marry1");
        marry1.forEach(System.out::println);
    }
}
