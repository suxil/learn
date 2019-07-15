package com.learn.core.common;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Administrator on 2016/12/23 0023.
 */
@Data
public class BaseDomain implements Serializable {

    @TableId(type = IdType.INPUT)
    @TableField(fill = FieldFill.INSERT)
    private String id;

    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateDate;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer isDeleted;

    @Version
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long version;

}
