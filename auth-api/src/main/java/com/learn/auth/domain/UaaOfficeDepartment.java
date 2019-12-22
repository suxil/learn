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
 * 组织-部门信息
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaOfficeDepartment对象", description="组织-部门信息")
@Entity
@Table(name = "uaa_office_department", catalog = "组织-部门信息")
public class UaaOfficeDepartment extends BaseDomain {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "office_id", value = "")
    @Column(name = "office_id")
    private String officeId;

    @ApiModelProperty(name = "department_id", value = "")
    @Column(name = "department_id")
    private String departmentId;


}
