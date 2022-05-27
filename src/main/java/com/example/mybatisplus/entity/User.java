package com.example.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @ClassName: User
 * @Decription: TODO
 * @Author: 陈云博
 * @Date: 2022/5/1
 * @Version:1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user")
public class User {
    //    @TableId(type = IdType.ASSIGN_ID)
//    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    //    @TableField(value = "username")
    private String name;
    @TableField(fill = FieldFill.INSERT)
    private Integer age;
    private String email;
//    @TableField(value = "author", fill = FieldFill.INSERT)
//    private String author;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic(delval = "-1",value = "0")
    @TableField(value = "is_deleted")
    private Boolean deleted; //0：未删除，1：已删除
}
