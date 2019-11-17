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
 * 菜单-角色信息
 * </p>
 *
 * @author generate
 * @since 2019-11-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaMenuRole对象", description="菜单-角色信息")
@Entity
@Table(name = "uaa_menu_role", catalog = "菜单-角色信息")
public class UaaMenuRole extends BaseDomain {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "menu_id", value = "")
    @Column(name = "menu_id")
    private String menuId;

    @ApiModelProperty(name = "role_id", value = "")
    @Column(name = "role_id")
    private String roleId;


}
