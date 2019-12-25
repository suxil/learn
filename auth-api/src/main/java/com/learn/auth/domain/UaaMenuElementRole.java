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
 * 页面元素-角色息
 * </p>
 *
 * @author generate
 * @since 2019-12-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaMenuElementRole对象", description="页面元素-角色息")
@Entity
@Table(name = "uaa_menu_element_role", catalog = "页面元素-角色息")
public class UaaMenuElementRole extends BaseDomain {

    private static final long serialVersionUID = 1L;

    public static final String MENU_ELEMENT_ID = "menu_element_id";
    public static final String ROLE_ID = "role_id";

    @ApiModelProperty(name = "menu_element_id", value = "")
    @Column(name = "menu_element_id")
    private String menuElementId;

    @ApiModelProperty(name = "role_id", value = "")
    @Column(name = "role_id")
    private String roleId;


}
