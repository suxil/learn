package io.github.suxil.auth.domain;

import io.github.suxil.mybatis.domain.BaseDomain;
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
 * 部门表
 * </p>
 *
 * @author generate
 * @since 2020-04-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaDepartment对象", description="部门表")
@Entity
@Table(name = "uaa_department", catalog = "部门表")
public class UaaDepartment extends BaseDomain {

    private static final long serialVersionUID = 1L;

    public static final String PARENT_ID = "parent_id";
    public static final String SEQ = "seq";
    public static final String LEVEL = "level";
    public static final String FULL_PATH = "full_path";
    public static final String DEPARTMENT_CODE = "department_code";
    public static final String DEPARTMENT_NAME = "department_name";
    public static final String DESCRIPTION = "description";

    @ApiModelProperty(name = "parent_id", value = "父部门id")
    @Column(name = "parent_id")
    private String parentId;

    @ApiModelProperty(name = "seq", value = "序号")
    @Column(name = "seq")
    private Integer seq;

    @ApiModelProperty(name = "level", value = "部门层级")
    @Column(name = "level")
    private Integer level;

    @ApiModelProperty(name = "full_path", value = "部门全路径")
    @Column(name = "full_path")
    private String fullPath;

    @ApiModelProperty(name = "department_code", value = "部门代码")
    @Column(name = "department_code")
    private String departmentCode;

    @ApiModelProperty(name = "department_name", value = "部门名称")
    @Column(name = "department_name")
    private String departmentName;

    @ApiModelProperty(name = "description", value = "描述")
    @Column(name = "description")
    private String description;


}
