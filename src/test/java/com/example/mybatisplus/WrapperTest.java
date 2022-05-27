package com.example.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: WrapperTest
 * @Decription: TODO
 * @Author: 陈云博
 * @Date: 2022/5/23
 * @Version:1.0
 **/
@SpringBootTest
public class WrapperTest {
    @Resource
    private UserMapper userMapper;

    /**
     * @Description:查询名字中包含 m，且年龄大于 10 小于 20 ，email 不为空的用户
     * @Author: 陈云博
     * @Date:   2022/5/24 9:55
     * @Param:  []
     * @Return: void
     */
    @Test
    public void test1(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //column:对应数据库中的列名，而不是属性名
        queryWrapper.like("name","m")
                .between("age",10,20)
                .isNotNull("email");


        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }
    /**
     * @Description:按年龄降序查询用户，如果年龄相同则按 id 升序排列
     * @Author: 陈云博
     * @Date:   2022/5/24 10:09
     * @Param:  []
     * @Return: void
     */
    @Test
    public void test2(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //组装排序条件
        queryWrapper.orderByDesc("age").orderByAsc("id");

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    /**
     * @Description:查询名字中包含 n，且（年龄小于 18 或 email 为空的用户），并将这些用户的年龄设置为 18，邮箱设置为 user@atguigu.com
     * @Author: 陈云博
     * @Date:   2022/5/25 9:22
     * @Param:  []
     * @Return: void
     */
    @Test
    public void test3(){
        //组装查询条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","n")
                .and(i-> i.lt("age",18).or().isNull("email")); //lambda 表达
//                .lt("age",18)
//                .or()
//                .isNull("email");
        //组装更新条件
        User user = new User();
        user.setEmail("user@atguigu.com");
        user.setAge(18);
        //执行更新
        int update = userMapper.update(user, queryWrapper);
        System.out.println("更新结果为："+update);
    }
    /**
     * @Description:查询名字中包含 n，且（年龄小于 18 或 email 为空的用户），并将这些用户的年龄设置为 18，邮箱设置为 user@atguigu.com
     * @Author: 陈云博
     * @Date:   2022/5/25 9:22
     * @Param:  []
     * @Return: void
     */
    @Test
    public void test5(){
        //组装查询条件
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper
                .set("age",18)
                .set("email","user@atguigu.com")
                .like("name","n")
                .and(i-> i.lt("age",18).or().isNull("email")); //lambda 表达
//                .lt("age",18)
//                .or()
//                .isNull("email");
        //执行更新
        int update = userMapper.update(new User(), updateWrapper);
        System.out.println("更新结果为："+update);
    }
    /**
     * @Description:select 语句
     * @Author: 陈云博
     * @Date:   2022/5/25 9:49
     * @Param:  []
     * @Return: void
     */
    @Test
    public void test4(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //组装 select 语句
        queryWrapper.select("name","age");
        //select 语句通常会与
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }


    @Test
    public void test6(){
        String username = "n";
        Integer ageBegin = 10;
        Integer ageEnd = 20;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //方式一：
//
//        if (StringUtils.isNotBlank(username)){
//            queryWrapper.like("name",username);
//        }
//        if (ageBegin != null){
//            queryWrapper.ge("age",ageBegin);
//        }
//        if (ageEnd != null){
//            queryWrapper.le("age",ageEnd);
//        }
//        queryWrapper.select("name","email");
//        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
//        maps.forEach(System.out::println);

        //方式二：
        queryWrapper
                .like(StringUtils.isNotBlank(username),"name",username)
                .ge(ageBegin != null,"age",ageBegin)
                .le(ageEnd != null,"age",ageEnd);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }
}
