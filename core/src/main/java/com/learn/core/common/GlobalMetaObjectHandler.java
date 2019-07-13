package com.learn.core.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
@ConditionalOnMissingBean(value = MetaObjectHandler.class)
@ConditionalOnClass(value = MetaObjectHandler.class)
public class GlobalMetaObjectHandler implements MetaObjectHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalMetaObjectHandler.class);

    @Override
    public void insertFill(MetaObject metaObject) {
        LOGGER.debug("insert fill.");
        String id = UUID.randomUUID().toString().replace("-", "");
        this.setInsertFieldValByName("id", id, metaObject);
        this.setInsertFieldValByName("createBy", "admin", metaObject);
        this.setInsertFieldValByName("createDate", new Date(), metaObject);
        this.setInsertFieldValByName("isDeleted", 0, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        LOGGER.debug("update fill.");
        this.setUpdateFieldValByName("updateBy", "admin", metaObject);
        this.setUpdateFieldValByName("updateDate", new Date(), metaObject);
    }

}
