package com.learn.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.UUID;

public class DefaultGlobalMetaObjectHandler implements MetaObjectHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultGlobalMetaObjectHandler.class);

    @Override
    public void insertFill(MetaObject metaObject) {
        LOGGER.debug("insert fill.");
        String id = UUID.randomUUID().toString().replace("-", "");
        this.setFieldValByName("id", id, metaObject);
        this.setFieldValByName("createBy", "admin", metaObject);
        this.setFieldValByName("createDate", LocalDateTime.now(), metaObject);
        this.setFieldValByName("isDeleted", 0, metaObject);
        this.setFieldValByName("updateBy", "admin", metaObject);
        this.setFieldValByName("updateDate", LocalDateTime.now(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        LOGGER.debug("update fill.");
        this.setFieldValByName("updateBy", "admin", metaObject);
        this.setFieldValByName("updateDate", LocalDateTime.now(), metaObject);
    }

}
