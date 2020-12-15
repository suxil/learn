package io.github.suxil.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 菜单-角色信息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UaaMenuRoleDto对象", description="菜单-角色信息")
public class UaaMenuRoleDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "menu_id", value = "")
    private String menuId;

    @ApiModelProperty(name = "role_id", value = "")
    private String roleId;

    private Integer deleted;
    private Long version;


}
