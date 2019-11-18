package com.learn.auth.domain;

import com.learn.core.common.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>
 * 角色-权限信息
 * </p>
 *
 * @author generate
 * @since 2019-11-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaRolePermission对象", description="角色-权限信息")
@Entity
@Table(name = "uaa_role_permission", catalog = "角色-权限信息")
public class UaaRolePermission extends BaseDomain {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "role_id", value = "")
    @Column(name = "role_id")
    private String roleId;

    @ApiModelProperty(name = "permission_id", value = "")
    @Column(name = "permission_id")
    private String permissionId;


}