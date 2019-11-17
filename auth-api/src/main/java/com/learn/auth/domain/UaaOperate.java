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
 * 操作信息
 * </p>
 *
 * @author generate
 * @since 2019-11-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaOperate对象", description="操作信息")
@Entity
@Table(name = "uaa_operate", catalog = "操作信息")
public class UaaOperate extends BaseDomain {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "parent_id", value = "父操作id")
    @Column(name = "parent_id")
    private String parentId;

    @ApiModelProperty(name = "seq", value = "序号")
    @Column(name = "seq")
    private Integer seq;

    @ApiModelProperty(name = "menu_code", value = "操作代码")
    @Column(name = "menu_code")
    private String menuCode;

    @ApiModelProperty(name = "menu_name", value = "操作名称")
    @Column(name = "menu_name")
    private String menuName;

    @ApiModelProperty(name = "intercept_url_prefix", value = "拦截前缀")
    @Column(name = "intercept_url_prefix")
    private String interceptUrlPrefix;

    @ApiModelProperty(name = "description", value = "描述")
    @Column(name = "description")
    private String description;


}
