package com.example.mybatisx.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println("start insert fill......");
        this.setFieldValByName("create_time", new Date(), metaObject);
        this.setFieldValByName("update_time", new Date(), metaObject);
        this.setFieldValByName("is_deleted", 0, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        System.out.println("start update fill.......");
        this.setFieldValByName("update_time", new Date(), metaObject);
    }
}
