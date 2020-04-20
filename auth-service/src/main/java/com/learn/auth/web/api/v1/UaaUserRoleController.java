package com.learn.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaUserRole;
import com.learn.auth.service.UaaUserRoleService;
import com.learn.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户-角色表 前端控制器
 * </p>
 *
 * @author generate
 * @since 2020-04-20
 */
@Slf4j
@Api(value = "用户-角色表 接口")
@RestController
@RequestMapping("/api/v1/uaa-user-roles")
public class UaaUserRoleController {

    @Autowired
    private UaaUserRoleService uaaUserRoleService;

    @GetMapping
    @ApiOperation(value = "用户-角色表 分页查询")
    @Validated
    public ResponseResult list(UaaUserRole uaaUserRole, Page<UaaUserRole> page) {
        QueryWrapper<UaaUserRole> queryWrapper = new QueryWrapper<>();

        IPage<UaaUserRole> pageResult = uaaUserRoleService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "用户-角色表 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaUserRoleService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "用户-角色表 创建")
    public ResponseResult create(@RequestBody UaaUserRole uaaUserRole) {
        uaaUserRoleService.saveOrUpdate(uaaUserRole);
        return ResponseResult.success(uaaUserRole);
    }

    @PutMapping
    @ApiOperation(value = "用户-角色表 更新")
    public ResponseResult update(@RequestBody UaaUserRole uaaUserRole) {
        uaaUserRoleService.saveOrUpdate(uaaUserRole);
        return ResponseResult.success(uaaUserRole);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "用户-角色表 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaUserRoleService.removeById(id));
    }

}
