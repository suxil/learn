package com.learn.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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
@Data
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

}
