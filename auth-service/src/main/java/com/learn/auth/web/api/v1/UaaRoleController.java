package com.learn.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaRole;
import com.learn.auth.dto.UaaRoleDto;
import com.learn.auth.service.UaaRoleService;
import com.learn.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 角色信息 前端控制器
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Slf4j
@Api(value = "角色信息 接口")
@RestController
@RequestMapping("/api/v1/uaa-roles")
public class UaaRoleController {

    @Autowired
    private UaaRoleService uaaRoleService;

    @GetMapping
    @ApiOperation(value = "角色信息 分页查询")
    @Validated
    public ResponseResult list(UaaRoleDto uaaRoleDto, Page<UaaRole> page) {
        QueryWrapper<UaaRole> queryWrapper = new QueryWrapper<>();

        IPage<UaaRole> pageResult = uaaRoleService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "角色信息 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaRoleService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "角色信息 创建")
    public ResponseResult create(@RequestBody UaaRoleDto uaaRoleDto) {
        return ResponseResult.success(uaaRoleService.save(uaaRoleDto));
    }

    @PutMapping
    @ApiOperation(value = "角色信息 更新")
    public ResponseResult update(@RequestBody UaaRoleDto uaaRoleDto) {
        return ResponseResult.success(uaaRoleService.update(uaaRoleDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "角色信息 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaRoleService.removeById(id));
    }

}
