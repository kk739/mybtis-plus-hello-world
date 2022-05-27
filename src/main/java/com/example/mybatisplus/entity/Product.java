package com.example.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Product
 * @Decription: TODO
 * @Author: 陈云博
 * @Date: 2022/5/18
 * @Version:1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @TableId
    private Long id;
    private String name;
    private Float price;
    @Version
    private Integer version;
}
