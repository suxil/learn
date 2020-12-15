package io.github.suxil.auth.domain;

import io.github.suxil.mybatis.domain.BaseDomain;
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
 * 权限表
 * </p>
 *
 * @author generate
 * @since 2020-04-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaPermission对象", description="权限表")
@Entity
@Table(name = "uaa_permission", catalog = "权限表")
public class UaaPermission extends BaseDomain {

    private static final long serialVersionUID = 1L;

    public static final String PARENT_ID = "parent_id";
    public static final String SEQ = "seq";
    public static final String PERMISSION_CODE = "permission_code";
    public static final String PERMISSION_NAME = "permission_name";
    public static final String PERMISSION_TYPE = "permission_type";
    public static final String DESCRIPTION = "description";

    @ApiModelProperty(name = "parent_id", value = "父权限id")
    @Column(name = "parent_id")
    private String parentId;

    @ApiModelProperty(name = "seq", value = "序号")
    @Column(name = "seq")
    private Integer seq;

    @ApiModelProperty(name = "permission_code", value = "权限代码")
    @Column(name = "permission_code")
    private String permissionCode;

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
