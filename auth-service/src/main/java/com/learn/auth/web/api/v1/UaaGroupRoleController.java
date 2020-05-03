package com.learn.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaGroupRole;
import com.learn.auth.dto.UaaGroupRoleDto;
import com.learn.auth.service.UaaGroupRoleService;
import com.learn.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 组-角色信息 前端控制器
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Slf4j
@Api(value = "组-角色信息 接口")
@RestController
@RequestMapping("/api/v1/uaa-group-roles")
public class UaaGroupRoleController {

    @Autowired
    private UaaGroupRoleService uaaGroupRoleService;

    @GetMapping
    @ApiOperation(value = "组-角色信息 分页查询")
    @Validated
    public ResponseResult list(UaaGroupRoleDto uaaGroupRoleDto, Page<UaaGroupRole> page) {
        QueryWrapper<UaaGroupRole> queryWrapper = new QueryWrapper<>();

        IPage<UaaGroupRole> pageResult = uaaGroupRoleService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "组-角色信息 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaGroupRoleService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "组-角色信息 创建")
    public ResponseResult create(@RequestBody UaaGroupRoleDto uaaGroupRoleDto) {
        return ResponseResult.success(uaaGroupRoleService.save(uaaGroupRoleDto));
    }

    @PutMapping
    @ApiOperation(value = "组-角色信息 更新")
    public ResponseResult update(@RequestBody UaaGroupRoleDto uaaGroupRoleDto) {
        return ResponseResult.success(uaaGroupRoleService.update(uaaGroupRoleDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "组-角色信息 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaGroupRoleService.removeById(id));
    }

}
