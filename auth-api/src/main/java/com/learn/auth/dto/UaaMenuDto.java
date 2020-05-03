package com.learn.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 菜单信息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UaaMenuDto对象", description="菜单信息")
public class UaaMenuDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "parent_id", value = "父菜单id")
    private String parentId;

    @ApiModelProperty(name = "seq", value = "序号")
    private Integer seq;

    @ApiModelProperty(name = "level", value = "菜单层级")
    private Integer level;

    @ApiModelProperty(name = "full_path", value = "菜单全路径")
    private String fullPath;

    @ApiModelProperty(name = "icon", value = "菜单图标")
    private String icon;

    @ApiModelProperty(name = "menu_code", value = "菜单代码")
    private String menuCode;

    @ApiModelProperty(name = "menu_name", value = "菜单名称")
    private String menuName;

    @ApiModelProperty(name = "description", value = "描述")
    private String description;

    private Integer deleted;
    private Long version;


}
