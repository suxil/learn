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
 * 菜单表
 * </p>
 *
 * @author generate
 * @since 2020-04-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaMenu对象", description="菜单表")
@Entity
@Table(name = "uaa_menu", catalog = "菜单表")
public class UaaMenu extends BaseDomain {

    private static final long serialVersionUID = 1L;

    public static final String PARENT_ID = "parent_id";
    public static final String SEQ = "seq";
    public static final String LEVEL = "level";
    public static final String FULL_PATH = "full_path";
    public static final String ICON = "icon";
    public static final String MENU_CODE = "menu_code";
    public static final String MENU_NAME = "menu_name";
    public static final String DESCRIPTION = "description";

    @ApiModelProperty(name = "parent_id", value = "父菜单id")
    @Column(name = "parent_id")
    private String parentId;

    @ApiModelProperty(name = "seq", value = "序号")
    @Column(name = "seq")
    private Integer seq;

    @ApiModelProperty(name = "level", value = "菜单层级")
    @Column(name = "level")
    private Integer level;

    @ApiModelProperty(name = "full_path", value = "菜单全路径")
    @Column(name = "full_path")
    private String fullPath;

    @ApiModelProperty(name = "icon", value = "菜单图标")
    @Column(name = "icon")
    private String icon;

    @ApiModelProperty(name = "menu_code", value = "菜单代码")
    @Column(name = "menu_code")
    private String menuCode;

    @ApiModelProperty(name = "menu_name", value = "菜单名称")
    @Column(name = "menu_name")
    private String menuName;

    @ApiModelProperty(name = "description", value = "描述")
    @Column(name = "description")
    private String description;


}
