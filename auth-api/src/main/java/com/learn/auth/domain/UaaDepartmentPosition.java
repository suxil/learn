package com.learn.auth.domain;

import com.learn.mybatis.domain.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>
 * 部门-岗位表
 * </p>
 *
 * @author generate
 * @since 2020-04-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaDepartmentPosition对象", description="部门-岗位表")
@Entity
@Table(name = "uaa_department_position", catalog = "部门-岗位表")
public class UaaDepartmentPosition extends BaseDomain {

    private static final long serialVersionUID = 1L;

    public static final String DEPARTMENT_ID = "department_id";
    public static final String POSITION_ID = "position_id";

    @ApiModelProperty(name = "department_id", value = "")
    @Column(name = "department_id")
    private String departmentId;

    @ApiModelProperty(name = "position_id", value = "")
    @Column(name = "position_id")
    private String positionId;


}
