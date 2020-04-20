package com.learn.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaOperatePermission;
import com.learn.auth.service.UaaOperatePermissionService;
import com.learn.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 操作-权限表 前端控制器
 * </p>
 *
 * @author generate
 * @since 2020-04-20
 */
@Slf4j
@Api(value = "操作-权限表 接口")
@RestController
@RequestMapping("/api/v1/uaa-operate-permissions")
public class UaaOperatePermissionController {

    @Autowired
    private UaaOperatePermissionService uaaOperatePermissionService;

    @GetMapping
    @ApiOperation(value = "操作-权限表 分页查询")
    @Validated
    public ResponseResult list(UaaOperatePermission uaaOperatePermission, Page<UaaOperatePermission> page) {
        QueryWrapper<UaaOperatePermission> queryWrapper = new QueryWrapper<>();

        IPage<UaaOperatePermission> pageResult = uaaOperatePermissionService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "操作-权限表 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaOperatePermissionService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "操作-权限表 创建")
    public ResponseResult create(@RequestBody UaaOperatePermission uaaOperatePermission) {
        uaaOperatePermissionService.saveOrUpdate(uaaOperatePermission);
        return ResponseResult.success(uaaOperatePermission);
    }

    @PutMapping
    @ApiOperation(value = "操作-权限表 更新")
    public ResponseResult update(@RequestBody UaaOperatePermission uaaOperatePermission) {
        uaaOperatePermissionService.saveOrUpdate(uaaOperatePermission);
        return ResponseResult.success(uaaOperatePermission);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "操作-权限表 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaOperatePermissionService.removeById(id));
    }

}
