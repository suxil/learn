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
 * 组表
 * </p>
 *
 * @author generate
 * @since 2020-04-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaGroup对象", description="组表")
@Entity
@Table(name = "uaa_group", catalog = "组表")
public class UaaGroup extends BaseDomain {

    private static final long serialVersionUID = 1L;

    public static final String PARENT_ID = "parent_id";
    public static final String SEQ = "seq";
    public static final String LEVEL = "level";
    public static final String FULL_PATH = "full_path";
    public static final String GROUP_CODE = "group_code";
    public static final String GROUP_NAME = "group_name";
    public static final String DESCRIPTION = "description";

    @ApiModelProperty(name = "parent_id", value = "父组id")
    @Column(name = "parent_id")
    private String parentId;

    @ApiModelProperty(name = "seq", value = "序号")
    @Column(name = "seq")
    private Integer seq;

    @ApiModelProperty(name = "level", value = "组层级")
    @Column(name = "level")
    private Integer level;

    @ApiModelProperty(name = "full_path", value = "组全路径")
    @Column(name = "full_path")
    private String fullPath;

    @ApiModelProperty(name = "group_code", value = "组代码")
    @Column(name = "group_code")
    private String groupCode;

    @ApiModelProperty(name = "group_name", value = "组名称")
    @Column(name = "group_name")
    private String groupName;

    @ApiModelProperty(name = "description", value = "描述")
    @Column(name = "description")
    private String description;


}
