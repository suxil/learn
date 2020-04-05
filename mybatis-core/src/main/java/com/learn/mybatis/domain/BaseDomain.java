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

    private static final long serialVersionUID = 1L;

    public static final String ID = "id";
    public static final String TENANT_ID = "tenant_id";
    public static final String OFFICE_CODE = "office_code";
    public static final String CREATED_BY = "created_by";
    public static final String CREATED_AT = "created_at";
    public static final String UPDATED_BY = "updated_by";
    public static final String UPDATED_AT = "updated_at";
    public static final String DELETED = "deleted";
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
    private Integer deleted;

    @Version
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long version;

}
