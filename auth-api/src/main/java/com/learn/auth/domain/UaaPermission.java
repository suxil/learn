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
 * 权限信息
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaPermission对象", description="权限信息")
@Entity
@Table(name = "uaa_permission", catalog = "权限信息")
public class UaaPermission extends BaseDomain {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "parent_id", value = "父权限id")
    @Column(name = "parent_id")
    private String parentId;

    @ApiModelProperty(name = "seq", value = "序号")
    @Column(name = "seq")
    private Integer seq;

    @ApiModelProperty(name = "permission_name", value = "权限名称")
    @Column(name = "permission_name")
    private String permissionName;

    @ApiModelProperty(name = "permission_type", value = "权限类型")
    @Column(name = "permission_type")
    private String permissionType;

    @ApiModelProperty(name = "description", value = "描述")
    @Column(name = "description")
    private String description;


}
