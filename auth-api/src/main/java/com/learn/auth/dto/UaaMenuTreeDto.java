package com.learn.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Title:
 * Description:
 * date: 2020/1/1 19:33
 *
 * @author suxi
 * @version V1.0
 */
@Data
@ApiModel(value="菜单树对象")
public class UaaMenuTreeDto implements Serializable {

    private String id;

    @ApiModelProperty(name = "parent_id", value = "父菜单id")
    private String parentId;

    @ApiModelProperty(name = "seq", value = "序号")
    private Integer seq;

    @ApiModelProperty(name = "level", value = "菜单层级")
    private Integer level;

    @ApiModelProperty(name = "menu_code", value = "菜单代码")
    private String menuCode;

    @ApiModelProperty(name = "menu_name", value = "菜单名称")
    private String menuName;

    @ApiModelProperty(name = "children", value = "子节点")
    private List<UaaMenuTreeDto> children;

}
