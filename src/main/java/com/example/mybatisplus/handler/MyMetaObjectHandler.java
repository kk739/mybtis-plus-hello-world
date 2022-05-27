package com.example.mybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @ClassName: MyMetaObjectHandler
 * @Decription: TODO
 * @Author: 陈云博
 * @Date: 2022/5/14
 * @Version:1.0
 **/
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("insert 自动填充。。。。");
        //实现填充业务逻辑
        MetaObjectHandler createTime = this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        MetaObjectHandler updateTime = this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());

        //判断当前对象的属性是否已经进行了赋值
        Object age1 = this.getFieldValByName("age", metaObject);
        if (age1 == null) {
            log.info("insert age 自动填充....");
            MetaObjectHandler age = this.strictInsertFill(metaObject, "age", Integer.class, 3);
        }

        //判断当前对象的自动填充属性是否包含当前属性
        boolean hasAuthor = metaObject.hasSetter("author");
        if (hasAuthor) {
            log.info("insert author 自动填充");
            MetaObjectHandler metaObjectHandler = this.strictInsertFill(metaObject, "author", String.class, "AengusChen");
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("update 自动填充。。。。");
        MetaObjectHandler updateTime = this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }
}
