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
 * 页面元素信息
 * </p>
 *
 * @author generate
 * @since 2019-12-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaMenuElement对象", description="页面元素信息")
@Entity
@Table(name = "uaa_menu_element", catalog = "页面元素信息")
public class UaaMenuElement extends BaseDomain {

    private static final long serialVersionUID = 1L;

    public static final String PARENT_ID = "parent_id";
    public static final String SEQ = "seq";
    public static final String LEVEL = "level";
    public static final String ICON = "icon";
    public static final String MENU_ELEMENT_CODE = "menu_element_code";
    public static final String MENU_ELEMENT_NAME = "menu_element_name";
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

    @ApiModelProperty(name = "icon", value = "菜单图标")
    @Column(name = "icon")
    private String icon;

    @ApiModelProperty(name = "menu_element_code", value = "菜单元素代码")
    @Column(name = "menu_element_code")
    private String menuElementCode;

    @ApiModelProperty(name = "menu_element_name", value = "菜单元素名称")
    @Column(name = "menu_element_name")
    private String menuElementName;

    @ApiModelProperty(name = "description", value = "描述")
    @Column(name = "description")
    private String description;


}
