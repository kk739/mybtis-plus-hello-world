package com.example.mybatisplus;

import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest //自动创建 spring 上下文环境
class MybatisPlusApplicationTests {
    //    @Autowired //spring
    @Resource //J2EE
    private UserMapper userMapper;

    @Test
    void testSelectList() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
//        for (User u : users) {
//            System.out.println(u);
//        }
    }

}
