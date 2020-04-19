package com.learn.auth.domain;

import com.learn.mybatis.domain.BaseDomain;
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
 * 角色-权限表
 * </p>
 *
 * @author generate
 * @since 2020-04-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaRolePermission对象", description="角色-权限表")
@Entity
@Table(name = "uaa_role_permission", catalog = "角色-权限表")
public class UaaRolePermission extends BaseDomain {

    private static final long serialVersionUID = 1L;

    public static final String ROLE_ID = "role_id";
    public static final String PERMISSION_ID = "permission_id";

    @ApiModelProperty(name = "role_id", value = "")
    @Column(name = "role_id")
    private String roleId;

    @ApiModelProperty(name = "permission_id", value = "")
    @Column(name = "permission_id")
    private String permissionId;


}
