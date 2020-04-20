package com.learn.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaPermission;
import com.learn.auth.service.UaaPermissionService;
import com.learn.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author generate
 * @since 2020-04-20
 */
@Slf4j
@Api(value = "权限表 接口")
@RestController
@RequestMapping("/api/v1/uaa-permissions")
public class UaaPermissionController {

    @Autowired
    private UaaPermissionService uaaPermissionService;

    @GetMapping
    @ApiOperation(value = "权限表 分页查询")
    @Validated
    public ResponseResult list(UaaPermission uaaPermission, Page<UaaPermission> page) {
        QueryWrapper<UaaPermission> queryWrapper = new QueryWrapper<>();

        IPage<UaaPermission> pageResult = uaaPermissionService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "权限表 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaPermissionService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "权限表 创建")
    public ResponseResult create(@RequestBody UaaPermission uaaPermission) {
        uaaPermissionService.saveOrUpdate(uaaPermission);
        return ResponseResult.success(uaaPermission);
    }

    @PutMapping
    @ApiOperation(value = "权限表 更新")
    public ResponseResult update(@RequestBody UaaPermission uaaPermission) {
        uaaPermissionService.saveOrUpdate(uaaPermission);
        return ResponseResult.success(uaaPermission);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "权限表 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaPermissionService.removeById(id));
    }

}
