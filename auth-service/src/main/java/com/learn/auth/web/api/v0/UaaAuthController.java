package com.learn.auth.web.api.v0;

import com.learn.auth.domain.UaaUser;
import com.learn.auth.util.UserUtils;
import com.learn.auth.vo.UaaUserLoginVo;
import com.learn.core.common.ResponseResult;
import com.learn.core.util.BeanUtils;
import com.learn.core.util.JwtUtils;
import com.learn.core.util.MessageUtils;
import com.learn.core.util.ValidatorUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2020/4/4 18:38
 * <p>
 * Copyright: © 2012-2020 . All rights reserved.
 * Company:
 *
 * @author lu_it
 * @version V1.0
 * @Package com.learn.auth.web.api.v0
 */
@Slf4j
@Api(value = "认证 接口")
@RestController
@RequestMapping("/api/v0/auth")
public class UaaAuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/profile")
    @ApiOperation(value = "获取用户信息")
    public ResponseResult profile() {
        UaaUser uaaUser = UserUtils.getUser();
        return ResponseResult.success(uaaUser);
    }

    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public ResponseResult login(@RequestBody UaaUserLoginVo uaaUser) {
        ValidatorUtils.validate(uaaUser);

        UserDetails userDetails = userDetailsService.loadUserByUsername(uaaUser.getUsername());

        Assert.notNull(userDetails, MessageUtils.getMessage("error.not.user", uaaUser.getUsername()));

        if (!passwordEncoder.matches(uaaUser.getPassword(), userDetails.getPassword())) {
            log.debug(MessageUtils.getMessage("error.user.auth"));

            return ResponseResult.message(MessageUtils.getMessage("error.user.auth"));
        }

        Map<String, Object> map = BeanUtils.beanToMap(userDetails);
        map.remove("password");

        String token = JwtUtils.create(map);

        return ResponseResult.success(token);
    }

}
