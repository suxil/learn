package io.github.suxil.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 角色-权限信息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UaaRolePermissionDto对象", description="角色-权限信息")
public class UaaRolePermissionDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "role_id", value = "")
    private String roleId;

    @ApiModelProperty(name = "permission_id", value = "")
    private String permissionId;

    private Integer deleted;
    private Long version;


}
