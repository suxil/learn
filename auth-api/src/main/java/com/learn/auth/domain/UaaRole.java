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
 * 角色信息
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaRole对象", description="角色信息")
@Entity
@Table(name = "uaa_role", catalog = "角色信息")
public class UaaRole extends BaseDomain {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "parent_id", value = "父角色id")
    @Column(name = "parent_id")
    private String parentId;

    @ApiModelProperty(name = "seq", value = "序号")
    @Column(name = "seq")
    private Integer seq;

    @ApiModelProperty(name = "level", value = "角色层级")
    @Column(name = "level")
    private Integer level;

    @ApiModelProperty(name = "full_path", value = "角色全路径")
    @Column(name = "full_path")
    private String fullPath;

    @ApiModelProperty(name = "role_code", value = "角色代码")
    @Column(name = "role_code")
    private String roleCode;

    @ApiModelProperty(name = "role_name", value = "角色名称")
    @Column(name = "role_name")
    private String roleName;

    @ApiModelProperty(name = "description", value = "描述")
    @Column(name = "description")
    private String description;


}
