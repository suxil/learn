package com.learn.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.learn.core.constance.BaseDomainConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
public class DefaultGlobalMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.debug("insert fill.");
        String id = UUID.randomUUID().toString().replace("-", "");
        this.setFieldValByName(BaseDomainConstants.ID, id, metaObject);
        this.setFieldValByName(BaseDomainConstants.TENANT_ID, "1", metaObject);
        this.setFieldValByName(BaseDomainConstants.OFFICE_CODE, "1", metaObject);
        this.setFieldValByName(BaseDomainConstants.CREATED_BY, "admin", metaObject);
        this.setFieldValByName(BaseDomainConstants.CREATED_AT, LocalDateTime.now(), metaObject);
        this.setFieldValByName(BaseDomainConstants.DELETED, 0, metaObject);
        this.setFieldValByName(BaseDomainConstants.UPDATED_BY, "admin", metaObject);
        this.setFieldValByName(BaseDomainConstants.UPDATED_AT, LocalDateTime.now(), metaObject);
        this.setFieldValByName(BaseDomainConstants.VERSION, 0L, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.debug("update fill.");
        this.setFieldValByName(BaseDomainConstants.UPDATED_BY, "admin", metaObject);
        this.setFieldValByName(BaseDomainConstants.UPDATED_AT, LocalDateTime.now(), metaObject);
    }

}
