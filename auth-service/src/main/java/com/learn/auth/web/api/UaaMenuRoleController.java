package com.learn.auth.web.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaMenuRole;
import com.learn.auth.service.UaaMenuRoleService;
import com.learn.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 菜单-角色信息 前端控制器
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@Api(value = "菜单-角色信息 接口")
@RestController
@RequestMapping("/api/v1/uaa-menu-roles")
public class UaaMenuRoleController {

    @Autowired
    private UaaMenuRoleService uaaMenuRoleService;

    @GetMapping
    @ApiOperation(value = "菜单-角色信息 分页查询")
    @Validated
    public ResponseResult list(UaaMenuRole uaaMenuRole, Page<UaaMenuRole> page) {
        QueryWrapper<UaaMenuRole> queryWrapper = new QueryWrapper<>();

        IPage<UaaMenuRole> pageResult = uaaMenuRoleService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "菜单-角色信息 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaMenuRoleService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "菜单-角色信息 创建")
    public ResponseResult create(@RequestBody UaaMenuRole uaaMenuRole) {
        uaaMenuRoleService.saveOrUpdate(uaaMenuRole);
        return ResponseResult.success(uaaMenuRole);
    }

    @PutMapping
    @ApiOperation(value = "菜单-角色信息 更新")
    public ResponseResult update(@RequestBody UaaMenuRole uaaMenuRole) {
        uaaMenuRoleService.saveOrUpdate(uaaMenuRole);
        return ResponseResult.success(uaaMenuRole);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "菜单-角色信息 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaMenuRoleService.removeById(id));
    }

}
