package com.learn.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 用户登录日志
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UaaUserLoginLogDto对象", description="用户登录日志")
public class UaaUserLoginLogDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "user_code", value = "用户代码")
    private String userCode;

    @ApiModelProperty(name = "user_name", value = "姓名")
    private String userName;

    @ApiModelProperty(name = "jp", value = "简拼")
    private String jp;

    @ApiModelProperty(name = "login_name", value = "登录名")
    private String loginName;

    @ApiModelProperty(name = "country", value = "国家")
    private String country;

    @ApiModelProperty(name = "city", value = "城市")
    private String city;

    @ApiModelProperty(name = "operator", value = "运营商")
    private String operator;

    @ApiModelProperty(name = "login_ip", value = "登录ip")
    private Integer loginIp;

    @ApiModelProperty(name = "computer_name", value = "计算机名称")
    private String computerName;

    @ApiModelProperty(name = "language", value = "语言")
    private String language;

    @ApiModelProperty(name = "platform", value = "平台")
    private String platform;

    @ApiModelProperty(name = "user_agent", value = "浏览器")
    private String userAgent;

    @ApiModelProperty(name = "cookies", value = "登录cookie")
    private String cookies;

    private Integer deleted;
    private Long version;


}
