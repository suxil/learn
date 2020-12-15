package io.github.suxil.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.suxil.auth.domain.UaaRolePermission;
import io.github.suxil.auth.dto.UaaRolePermissionDto;
import io.github.suxil.auth.service.UaaRolePermissionService;
import io.github.suxil.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 角色-权限信息 前端控制器
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Slf4j
@Api(value = "角色-权限信息 接口")
@RestController
@RequestMapping("/api/v1/uaa-role-permissions")
public class UaaRolePermissionController {

    @Autowired
    private UaaRolePermissionService uaaRolePermissionService;

    @GetMapping
    @ApiOperation(value = "角色-权限信息 分页查询")
    @Validated
    public ResponseResult list(UaaRolePermissionDto uaaRolePermissionDto, Page<UaaRolePermission> page) {
        QueryWrapper<UaaRolePermission> queryWrapper = new QueryWrapper<>();

        IPage<UaaRolePermission> pageResult = uaaRolePermissionService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "角色-权限信息 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaRolePermissionService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "角色-权限信息 创建")
    public ResponseResult create(@RequestBody UaaRolePermissionDto uaaRolePermissionDto) {
        return ResponseResult.success(uaaRolePermissionService.save(uaaRolePermissionDto));
    }

    @PutMapping
    @ApiOperation(value = "角色-权限信息 更新")
    public ResponseResult update(@RequestBody UaaRolePermissionDto uaaRolePermissionDto) {
        return ResponseResult.success(uaaRolePermissionService.update(uaaRolePermissionDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "角色-权限信息 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaRolePermissionService.removeById(id));
    }

}
