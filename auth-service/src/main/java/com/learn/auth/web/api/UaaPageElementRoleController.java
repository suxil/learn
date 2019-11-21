package com.learn.auth.web.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaPageElementRole;
import com.learn.auth.service.IUaaPageElementRoleService;
import com.learn.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 页面元素-角色息 前端控制器
 * </p>
 *
 * @author generate
 * @since 2019-11-21
 */
@Api(value = "页面元素-角色息 接口")
@RestController
@RequestMapping("/api/v1/uaa-page-element-roles")
public class UaaPageElementRoleController {

    @Autowired
    private IUaaPageElementRoleService uaaPageElementRoleService;

    @GetMapping
    @ApiOperation(value = "页面元素-角色息 分页查询")
    @Validated
    public ResponseResult list(UaaPageElementRole uaaPageElementRole, Page<UaaPageElementRole> page) {
        QueryWrapper<UaaPageElementRole> queryWrapper = new QueryWrapper<>();

        IPage<UaaPageElementRole> pageResult = uaaPageElementRoleService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "页面元素-角色息 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaPageElementRoleService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "页面元素-角色息 创建")
    public ResponseResult create(@RequestBody UaaPageElementRole uaaPageElementRole) {
        uaaPageElementRoleService.saveOrUpdate(uaaPageElementRole);
        return ResponseResult.success(uaaPageElementRole);
    }

    @PutMapping
    @ApiOperation(value = "页面元素-角色息 更新")
    public ResponseResult update(@RequestBody UaaPageElementRole uaaPageElementRole) {
        uaaPageElementRoleService.saveOrUpdate(uaaPageElementRole);
        return ResponseResult.success(uaaPageElementRole);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "页面元素-角色息 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaPageElementRoleService.removeById(id));
    }

}
