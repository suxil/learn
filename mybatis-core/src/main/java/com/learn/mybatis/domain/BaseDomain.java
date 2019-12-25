package com.learn.mybatis.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Administrator on 2016/12/23 0023.
 */
@Data
public class BaseDomain implements Serializable {

    public static final String ID = "id";
    public static final String TENANT_ID = "tenantId";
    public static final String OFFICE_CODE = "officeCode";
    public static final String CREATED_BY = "createdBy";
    public static final String CREATED_AT = "createdAt";
    public static final String UPDATED_BY = "updatedBy";
    public static final String UPDATED_AT = "updatedAt";
    public static final String IS_DELETED = "isDeleted";
    public static final String VERSION = "version";

    @TableId(type = IdType.INPUT)
    @TableField(fill = FieldFill.INSERT)
    private String id;

    @TableField(fill = FieldFill.INSERT)
    private String tenantId;

    @TableField(fill = FieldFill.INSERT)
    private String officeCode;

    @TableField(fill = FieldFill.INSERT)
    private String createdBy;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updatedBy;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer isDeleted;

    @Version
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long version;

}
