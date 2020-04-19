package com.learn.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<UaaMenuTreeDto> getChildren() {
        return children;
    }

    public void setChildren(List<UaaMenuTreeDto> children) {
        this.children = children;
    }
}
