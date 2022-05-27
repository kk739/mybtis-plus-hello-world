package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.entity.User;

import java.util.List;

//@Repository
public interface UserMapper extends BaseMapper<User> {
    List<User> selectAllByName(String name);
    /**
     * @Description:根据年龄查询用户列表，分页展示
     * @Author: 陈云博
     * @Date:   2022/5/15 10:19
     * @Param:  [page, age]
     * @Return: com.baomidou.mybatisplus.core.metadata.IPage<com.example.mybatisplus.entity.User>
     */
    IPage<User> selectPageByAge(Page<?> page, Integer age);
}
