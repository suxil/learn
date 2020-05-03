package com.learn.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 权限信息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UaaPermissionDto对象", description="权限信息")
public class UaaPermissionDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "parent_id", value = "父权限id")
    private String parentId;

    @ApiModelProperty(name = "seq", value = "序号")
    private Integer seq;

    @ApiModelProperty(name = "permission_code", value = "权限代码")
    private String permissionCode;

    @ApiModelProperty(name = "permission_name", value = "权限名称")
    private String permissionName;

    @ApiModelProperty(name = "permission_type", value = "权限类型")
    private String permissionType;

    @ApiModelProperty(name = "description", value = "描述")
    private String description;

    private Integer deleted;
    private Long version;


}
