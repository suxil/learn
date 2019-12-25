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
 * 用户登录日志
 * </p>
 *
 * @author generate
 * @since 2019-12-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaUserLoginLog对象", description="用户登录日志")
@Entity
@Table(name = "uaa_user_login_log", catalog = "用户登录日志")
public class UaaUserLoginLog extends BaseDomain {

    private static final long serialVersionUID = 1L;

    public static final String USER_CODE = "user_code";
    public static final String USER_NAME = "user_name";
    public static final String JP = "jp";
    public static final String LOGIN_NAME = "login_name";
    public static final String COUNTRY = "country";
    public static final String CITY = "city";
    public static final String OPERATOR = "operator";
    public static final String LOGIN_IP = "login_ip";
    public static final String COMPUTER_NAME = "computer_name";
    public static final String LANGUAGE = "language";
    public static final String PLATFORM = "platform";
    public static final String USER_AGENT = "user_agent";
    public static final String COOKIES = "cookies";

    @ApiModelProperty(name = "user_code", value = "用户代码")
    @Column(name = "user_code")
    private String userCode;

    @ApiModelProperty(name = "user_name", value = "姓名")
    @Column(name = "user_name")
    private String userName;

    @ApiModelProperty(name = "jp", value = "简拼")
    @Column(name = "jp")
    private String jp;

    @ApiModelProperty(name = "login_name", value = "登录名")
    @Column(name = "login_name")
    private String loginName;

    @ApiModelProperty(name = "country", value = "国家")
    @Column(name = "country")
    private String country;

    @ApiModelProperty(name = "city", value = "城市")
    @Column(name = "city")
    private String city;

    @ApiModelProperty(name = "operator", value = "运营商")
    @Column(name = "operator")
    private String operator;

    @ApiModelProperty(name = "login_ip", value = "登录ip")
    @Column(name = "login_ip")
    private Integer loginIp;

    @ApiModelProperty(name = "computer_name", value = "计算机名称")
    @Column(name = "computer_name")
    private String computerName;

    @ApiModelProperty(name = "language", value = "语言")
    @Column(name = "language")
    private String language;

    @ApiModelProperty(name = "platform", value = "平台")
    @Column(name = "platform")
    private String platform;

    @ApiModelProperty(name = "user_agent", value = "浏览器")
    @Column(name = "user_agent")
    private String userAgent;

    @ApiModelProperty(name = "cookies", value = "登录cookie")
    @Column(name = "cookies")
    private String cookies;


}
