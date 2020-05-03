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
@ApiModel(value="UaaUserRoleDto对象", description="角色信息")
public class UaaUserRoleDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "user_id", value = "")
    private String userId;

    @ApiModelProperty(name = "role_id", value = "")
    private String roleId;

    private Integer deleted;
    private Long version;


}
