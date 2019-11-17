package com.learn.auth.domain;

import com.learn.core.common.BaseDomain;
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
 * @since 2019-11-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaPageElement对象", description="页面元素信息")
@Entity
@Table(name = "uaa_page_element", catalog = "页面元素信息")
public class UaaPageElement extends BaseDomain {

    private static final long serialVersionUID = 1L;

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
