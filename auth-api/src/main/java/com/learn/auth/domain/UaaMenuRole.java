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
 * 菜单-角色表
 * </p>
 *
 * @author generate
 * @since 2020-04-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaMenuRole对象", description="菜单-角色表")
@Entity
@Table(name = "uaa_menu_role", catalog = "菜单-角色表")
public class UaaMenuRole extends BaseDomain {

    private static final long serialVersionUID = 1L;

    public static final String MENU_ID = "menu_id";
    public static final String ROLE_ID = "role_id";

    @ApiModelProperty(name = "menu_id", value = "")
    @Column(name = "menu_id")
    private String menuId;

    @ApiModelProperty(name = "role_id", value = "")
    @Column(name = "role_id")
    private String roleId;


}
