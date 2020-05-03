package com.learn.auth.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2020/4/5 9:13
 * <p>
 * Copyright: © 2012-2020 . All rights reserved.
 * Company:
 *
 * @author lu_it
 * @version V1.0
 * @Package com.learn.auth.dto
 */
@Data
@Accessors(chain = true)
@ApiModel(value="用户对象")
public class UaaUserLoginVo {

    @ApiModelProperty(name = "user_code", value = "用户代码")
    @NotBlank(message="用户名不能为空")
    private String username;

    @ApiModelProperty(name = "password", value = "密码")
    @NotBlank(message="密码不能为空")
    private String password;

}
