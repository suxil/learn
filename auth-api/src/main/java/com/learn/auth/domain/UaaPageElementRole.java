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
 * @since 2019-11-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaPageElementRole对象", description="页面元素-角色息")
@Entity
@Table(name = "uaa_page_element_role", catalog = "页面元素-角色息")
public class UaaPageElementRole extends BaseDomain {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "page_element_id", value = "")
    @Column(name = "page_element_id")
    private String pageElementId;

    @ApiModelProperty(name = "role_id", value = "")
    @Column(name = "role_id")
    private String roleId;


}
