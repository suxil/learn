package io.github.suxil.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 部门信息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UaaDepartmentDto对象", description="部门信息")
public class UaaDepartmentDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "parent_id", value = "父部门id")
    private String parentId;

    @ApiModelProperty(name = "seq", value = "序号")
    private Integer seq;

    @ApiModelProperty(name = "level", value = "部门层级")
    private Integer level;

    @ApiModelProperty(name = "full_path", value = "部门全路径")
    private String fullPath;

    @ApiModelProperty(name = "department_code", value = "部门代码")
    private String departmentCode;

    @ApiModelProperty(name = "department_name", value = "部门名称")
    private String departmentName;

    @ApiModelProperty(name = "description", value = "描述")
    private String description;

    private Integer deleted;
    private Long version;


}
