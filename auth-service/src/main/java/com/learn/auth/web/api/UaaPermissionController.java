package com.learn.auth.web.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaPermission;
import com.learn.auth.service.IUaaPermissionService;
import com.learn.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 权限信息 前端控制器
 * </p>
 *
 * @author generate
 * @since 2019-11-21
 */
@Api(value = "权限信息 接口")
@RestController
@RequestMapping("/api/v1/uaa-permissions")
public class UaaPermissionController {

    @Autowired
    private IUaaPermissionService uaaPermissionService;

    @GetMapping
    @ApiOperation(value = "权限信息 分页查询")
    @Validated
    public ResponseResult list(UaaPermission uaaPermission, Page<UaaPermission> page) {
        QueryWrapper<UaaPermission> queryWrapper = new QueryWrapper<>();

        IPage<UaaPermission> pageResult = uaaPermissionService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "权限信息 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaPermissionService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "权限信息 创建")
    public ResponseResult create(@RequestBody UaaPermission uaaPermission) {
        uaaPermissionService.saveOrUpdate(uaaPermission);
        return ResponseResult.success(uaaPermission);
    }

    @PutMapping
    @ApiOperation(value = "权限信息 更新")
    public ResponseResult update(@RequestBody UaaPermission uaaPermission) {
        uaaPermissionService.saveOrUpdate(uaaPermission);
        return ResponseResult.success(uaaPermission);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "权限信息 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaPermissionService.removeById(id));
    }

}
