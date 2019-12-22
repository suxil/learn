package com.learn.auth.web.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaUserLoginLog;
import com.learn.auth.service.UaaUserLoginLogService;
import com.learn.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户登录日志 前端控制器
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@Api(value = "用户登录日志 接口")
@RestController
@RequestMapping("/api/v1/uaa-user-login-logs")
public class UaaUserLoginLogController {

    @Autowired
    private UaaUserLoginLogService uaaUserLoginLogService;

    @GetMapping
    @ApiOperation(value = "用户登录日志 分页查询")
    @Validated
    public ResponseResult list(UaaUserLoginLog uaaUserLoginLog, Page<UaaUserLoginLog> page) {
        QueryWrapper<UaaUserLoginLog> queryWrapper = new QueryWrapper<>();

        IPage<UaaUserLoginLog> pageResult = uaaUserLoginLogService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "用户登录日志 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaUserLoginLogService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "用户登录日志 创建")
    public ResponseResult create(@RequestBody UaaUserLoginLog uaaUserLoginLog) {
        uaaUserLoginLogService.saveOrUpdate(uaaUserLoginLog);
        return ResponseResult.success(uaaUserLoginLog);
    }

    @PutMapping
    @ApiOperation(value = "用户登录日志 更新")
    public ResponseResult update(@RequestBody UaaUserLoginLog uaaUserLoginLog) {
        uaaUserLoginLogService.saveOrUpdate(uaaUserLoginLog);
        return ResponseResult.success(uaaUserLoginLog);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "用户登录日志 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaUserLoginLogService.removeById(id));
    }

}
