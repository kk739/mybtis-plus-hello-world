package com.example.mybatisplus;

import com.example.mybatisplus.entity.Product;
import com.example.mybatisplus.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @ClassName: MapperProductTest
 * @Decription: TODO
 * @Author: 陈云博
 * @Date: 2022/5/18
 * @Version:1.0
 **/
@SpringBootTest
public class MapperProductTest {
    @Resource
    ProductMapper productMapper;

    @Test
    public void testSelect() {
        //小李获取商品信息
        Product p1 = productMapper.selectById(1l);
        System.out.println("p1 价格为：" + p1.getPrice());

        //小王获取商品信息
        Product p2 = productMapper.selectById(1l);
        System.out.println("p2 价格为："+ p2.getPrice());

        //小李修改商品信息
        p1.setPrice(p1.getPrice()+50);
        int i = productMapper.updateById(p1);
        System.out.println("p1 修改结果为："+i);

        //小王修改商品信息
        p2.setPrice(p2.getPrice()-30);
        int i1 = productMapper.updateById(p2);
        System.out.println("p2 修改结果为："+i1);
        if(i1 == 0){
            p2 = productMapper.selectById(1l);
            p2.setPrice(p2.getPrice()-30);
            int i2 = productMapper.updateById(p2);
            System.out.println("p2 重试结果："+i2);
        }
        //老板查看数据
        Product p3 = productMapper.selectById(1l);
        System.out.println("老板获取的结果："+p3.getPrice());
    }
}
