package com.learn.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 用户-权限信息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UaaUserPermissionDto对象", description="用户-权限信息")
public class UaaUserPermissionDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "user_id", value = "")
    private String userId;

    @ApiModelProperty(name = "permission_id", value = "")
    private String permissionId;

    private Integer deleted;
    private Long version;


}
