package com.learn.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.learn.mybatis.domain.BaseDomain;
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
        this.setFieldValByName(BaseDomain.ID, id, metaObject);
        this.setFieldValByName(BaseDomain.TENANT_ID, "1", metaObject);
        this.setFieldValByName(BaseDomain.OFFICE_CODE, "1", metaObject);
        this.setFieldValByName(BaseDomain.CREATED_BY, "admin", metaObject);
        this.setFieldValByName(BaseDomain.CREATED_AT, LocalDateTime.now(), metaObject);
        this.setFieldValByName(BaseDomain.IS_DELETED, 0, metaObject);
        this.setFieldValByName(BaseDomain.UPDATED_BY, "admin", metaObject);
        this.setFieldValByName(BaseDomain.UPDATED_AT, LocalDateTime.now(), metaObject);
        this.setFieldValByName(BaseDomain.VERSION, 0L, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        LOGGER.debug("update fill.");
        this.setFieldValByName(BaseDomain.UPDATED_BY, "admin", metaObject);
        this.setFieldValByName(BaseDomain.UPDATED_AT, LocalDateTime.now(), metaObject);
    }

}
