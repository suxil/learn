package com.learn.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Title:
 * Description:
 * date: 2020/1/1 19:24
 *
 * @author suxi
 * @version V1.0
 */
@Data
@ApiModel(value="部门树对象")
public class UaaDepartmentTreeDto implements Serializable {

    private String id;

    @ApiModelProperty(name = "parent_id", value = "父部门id")
    private String parentId;

    @ApiModelProperty(name = "seq", value = "序号")
    private Integer seq;

    @ApiModelProperty(name = "level", value = "部门层级")
    private Integer level;

    @ApiModelProperty(name = "department_code", value = "部门代码")
    private String departmentCode;

    @ApiModelProperty(name = "department_name", value = "部门名称")
    private String departmentName;

    @ApiModelProperty(name = "children", value = "子节点")
    private List<UaaDepartmentTreeDto> children;

}
