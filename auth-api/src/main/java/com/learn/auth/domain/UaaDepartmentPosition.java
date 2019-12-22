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
 * 部门-岗位信息
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaDepartmentPosition对象", description="部门-岗位信息")
@Entity
@Table(name = "uaa_department_position", catalog = "部门-岗位信息")
public class UaaDepartmentPosition extends BaseDomain {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "user_id", value = "")
    @Column(name = "user_id")
    private String userId;

    @ApiModelProperty(name = "position_id", value = "")
    @Column(name = "position_id")
    private String positionId;


}
