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
 * 组织信息
 * </p>
 *
 * @author generate
 * @since 2019-12-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaOffice对象", description="组织信息")
@Entity
@Table(name = "uaa_office", catalog = "组织信息")
public class UaaOffice extends BaseDomain {

    private static final long serialVersionUID = 1L;

    public static final String PARENT_ID = "parent_id";
    public static final String SEQ = "seq";
    public static final String LEVEL = "level";
    public static final String FULL_PATH = "full_path";
    public static final String OFFICE_NAME = "office_name";
    public static final String DESCRIPTION = "description";

    @ApiModelProperty(name = "parent_id", value = "父组织id")
    @Column(name = "parent_id")
    private String parentId;

    @ApiModelProperty(name = "seq", value = "序号")
    @Column(name = "seq")
    private Integer seq;

    @ApiModelProperty(name = "level", value = "组织层级")
    @Column(name = "level")
    private Integer level;

    @ApiModelProperty(name = "full_path", value = "组织全路径")
    @Column(name = "full_path")
    private String fullPath;

    @ApiModelProperty(name = "office_name", value = "组织名称")
    @Column(name = "office_name")
    private String officeName;

    @ApiModelProperty(name = "description", value = "描述")
    @Column(name = "description")
    private String description;


}
