package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: UserServiceImpl
 * @Decription: TODO
 * @Author: 陈云博
 * @Date: 2022/5/1
 * @Version:1.0
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
//    @Resource
//    private UserMapper userMapper;

    @Override
    public List<User> selectAllByName(String name) {
//        return userMapper.selectAllByName(name);
        return baseMapper.selectAllByName(name);
    }
}
