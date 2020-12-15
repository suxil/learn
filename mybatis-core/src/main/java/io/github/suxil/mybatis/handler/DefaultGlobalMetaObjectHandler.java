package io.github.suxil.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import io.github.suxil.core.constance.BaseDomainConstants;
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


        String userName = "admin";
        String officeCode = "1";
        String tenantId = "1";

        this.setFieldValByName(BaseDomainConstants.ID, id, metaObject);
        this.setFieldValByName(BaseDomainConstants.TENANT_ID, tenantId, metaObject);
        this.setFieldValByName(BaseDomainConstants.OFFICE_CODE, officeCode, metaObject);
        this.setFieldValByName(BaseDomainConstants.CREATED_BY, userName, metaObject);
        this.setFieldValByName(BaseDomainConstants.CREATED_AT, LocalDateTime.now(), metaObject);
        this.setFieldValByName(BaseDomainConstants.DELETED, 0, metaObject);
        this.setFieldValByName(BaseDomainConstants.UPDATED_BY, userName, metaObject);
        this.setFieldValByName(BaseDomainConstants.UPDATED_AT, LocalDateTime.now(), metaObject);
        this.setFieldValByName(BaseDomainConstants.VERSION, 0L, metaObject);

        log.debug("insert fill success.");
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.debug("update fill.");

        String userName = "admin";

        this.setFieldValByName(BaseDomainConstants.UPDATED_BY, userName, metaObject);
        this.setFieldValByName(BaseDomainConstants.UPDATED_AT, LocalDateTime.now(), metaObject);

        log.debug("update fill success.");
    }

}
