package com.learn.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Title:
 * Description:
 * date: 2020/1/1 19:44
 *
 * @author suxi
 * @version V1.0
 */
@ApiModel(value="权限树对象")
public class UaaPermissionTreeDto implements Serializable {

    private String id;

    @ApiModelProperty(name = "parent_id", value = "父权限id")
    private String parentId;

    @ApiModelProperty(name = "seq", value = "序号")
    private Integer seq;

    @ApiModelProperty(name = "permission_code", value = "权限代码")
    private String permissionCode;

    @ApiModelProperty(name = "permission_name", value = "权限名称")
    private String permissionName;

    @ApiModelProperty(name = "children", value = "子节点")
    private List<UaaPermissionTreeDto> children;

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

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public List<UaaPermissionTreeDto> getChildren() {
        return children;
    }

    public void setChildren(List<UaaPermissionTreeDto> children) {
        this.children = children;
    }
}
