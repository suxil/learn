package io.github.suxil.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UaaUserDto对象", description="用户信息")
public class UaaUserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "user_code", value = "用户代码")
    private String userCode;

    @ApiModelProperty(name = "user_name", value = "姓名")
    private String userName;

    @ApiModelProperty(name = "jp", value = "简拼")
    private String jp;

    @ApiModelProperty(name = "login_name", value = "登录名")
    private String loginName;

    @ApiModelProperty(name = "password", value = "密码")
    private String password;

    @ApiModelProperty(name = "mobile", value = "手机号")
    private String mobile;

    @ApiModelProperty(name = "email", value = "邮箱")
    private String email;

    @ApiModelProperty(name = "admin", value = "是否超级管理员 1：是 0：否")
    private Boolean admin;

    @ApiModelProperty(name = "last_login_date", value = "上次登录日期")
    private LocalDateTime lastLoginDate;

    @ApiModelProperty(name = "login_count", value = "登录次数")
    private Integer loginCount;

    @ApiModelProperty(name = "description", value = "描述")
    private String description;

    private Integer deleted;
    private Long version;


}
