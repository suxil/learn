package com.learn.auth.web.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.learn.core.common.BaseController;

/**
 * <p>
 * 菜单信息 前端控制器
 * </p>
 *
 * @author generate
 * @since 2019-11-17
 */
@Api(value = "菜单信息 接口")
@RestController
@RequestMapping("/api/v1/uaa-menu")
public class UaaMenuController extends BaseController {

}
