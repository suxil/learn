package com.learn.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 菜单菜单页面元素-角色息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UaaMenuElementRoleDto对象", description="菜单菜单页面元素-角色息")
public class UaaMenuElementRoleDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "menu_element_id", value = "")
    private String menuElementId;

    @ApiModelProperty(name = "role_id", value = "")
    private String roleId;

    private Integer deleted;
    private Long version;


}
