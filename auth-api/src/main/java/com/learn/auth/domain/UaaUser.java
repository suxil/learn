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
import java.time.LocalDateTime;

/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author generate
 * @since 2019-12-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaUser对象", description="用户信息")
@Entity
@Table(name = "uaa_user", catalog = "用户信息")
public class UaaUser extends BaseDomain {

    private static final long serialVersionUID = 1L;

    public static final String USER_CODE = "user_code";
    public static final String USER_NAME = "user_name";
    public static final String JP = "jp";
    public static final String LOGIN_NAME = "login_name";
    public static final String PASSWORD = "password";
    public static final String MOBILE = "mobile";
    public static final String EMAIL = "email";
    public static final String IS_ADMIN = "is_admin";
    public static final String LAST_LOGIN_DATE = "last_login_date";
    public static final String LOGIN_COUNT = "login_count";
    public static final String DESCRIPTION = "description";

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

    @ApiModelProperty(name = "password", value = "密码")
    @Column(name = "password")
    private String password;

    @ApiModelProperty(name = "mobile", value = "手机号")
    @Column(name = "mobile")
    private String mobile;

    @ApiModelProperty(name = "email", value = "邮箱")
    @Column(name = "email")
    private String email;

    @ApiModelProperty(name = "is_admin", value = "是否超级管理员 1：是 0：否")
    @Column(name = "is_admin")
    private Boolean isAdmin;

    @ApiModelProperty(name = "last_login_date", value = "上次登录日期")
    @Column(name = "last_login_date")
    private LocalDateTime lastLoginDate;

    @ApiModelProperty(name = "login_count", value = "登录次数")
    @Column(name = "login_count")
    private Integer loginCount;

    @ApiModelProperty(name = "description", value = "描述")
    @Column(name = "description")
    private String description;


}
