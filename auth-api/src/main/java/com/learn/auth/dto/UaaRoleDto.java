package com.learn.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 角色信息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UaaRoleDto对象", description="角色信息")
public class UaaRoleDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "parent_id", value = "父角色id")
    private String parentId;

    @ApiModelProperty(name = "seq", value = "序号")
    private Integer seq;

    @ApiModelProperty(name = "level", value = "角色层级")
    private Integer level;

    @ApiModelProperty(name = "full_path", value = "角色全路径")
    private String fullPath;

    @ApiModelProperty(name = "role_code", value = "角色代码")
    private String roleCode;

    @ApiModelProperty(name = "role_name", value = "角色名称")
    private String roleName;

    @ApiModelProperty(name = "description", value = "描述")
    private String description;

    private Integer deleted;
    private Long version;


}
