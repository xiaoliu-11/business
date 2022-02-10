package com.example.business.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.example.business.utils.OrderUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class MyMetaObjectHandler implements MetaObjectHandler {


    //实现自动填充字段：创建时间
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("gmtCreate",new Date(),metaObject);
        this.setFieldValByName("gmtUpdate",new Date(),metaObject);
        this.setFieldValByName("orderId", OrderUtils.getRandomOrderNumber(),metaObject);
        this.setFieldValByName("isDeleted",0,metaObject);
    }
    //实现自动填充字段：修改时间
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("gmtUpdate",new Date(),metaObject);
    }
}
