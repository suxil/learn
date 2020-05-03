package com.learn.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 部门-岗位信息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UaaDepartmentPositionDto对象", description="部门-岗位信息")
public class UaaDepartmentPositionDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "department_id", value = "")
    private String departmentId;

    @ApiModelProperty(name = "position_id", value = "")
    private String positionId;

    private Integer deleted;
    private Long version;


}
