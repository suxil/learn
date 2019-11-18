package com.learn.auth.web.api;

import com.learn.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.learn.core.common.BaseController;

/**
 * <p>
 * 用户信息 前端控制器
 * </p>
 *
 * @author generate
 * @since 2019-11-17
 */
@Api(value = "用户信息 接口")
@RestController
@RequestMapping("/api/v1/uaa-user")
public class UaaUserController extends BaseController {

    @GetMapping
    @ApiOperation(value = "用户信息 分页查询")
    @Validated
    public ResponseResult list() {

        return ResponseResult.success();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "用户信息 加载")
    public ResponseResult load(@PathVariable String id) {

        return ResponseResult.success();
    }

    @GetMapping
    @ApiOperation(value = "用户信息 创建")
    public ResponseResult create() {

        return ResponseResult.success();
    }

    @GetMapping
    @ApiOperation(value = "用户信息 更新")
    public ResponseResult update() {

        return ResponseResult.success();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "用户信息 删除")
    public ResponseResult delete(@PathVariable String id) {

        return ResponseResult.success();
    }

}
