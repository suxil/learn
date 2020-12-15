package io.github.suxil.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.suxil.auth.domain.UaaMenuElementRole;
import io.github.suxil.auth.dto.UaaMenuElementRoleDto;
import io.github.suxil.auth.service.UaaMenuElementRoleService;
import io.github.suxil.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 菜单菜单页面元素-角色息 前端控制器
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Slf4j
@Api(value = "菜单菜单页面元素-角色息 接口")
@RestController
@RequestMapping("/api/v1/uaa-menu-element-roles")
public class UaaMenuElementRoleController {

    @Autowired
    private UaaMenuElementRoleService uaaMenuElementRoleService;

    @GetMapping
    @ApiOperation(value = "菜单菜单页面元素-角色息 分页查询")
    @Validated
    public ResponseResult list(UaaMenuElementRoleDto uaaMenuElementRoleDto, Page<UaaMenuElementRole> page) {
        QueryWrapper<UaaMenuElementRole> queryWrapper = new QueryWrapper<>();

        IPage<UaaMenuElementRole> pageResult = uaaMenuElementRoleService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "菜单菜单页面元素-角色息 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaMenuElementRoleService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "菜单菜单页面元素-角色息 创建")
    public ResponseResult create(@RequestBody UaaMenuElementRoleDto uaaMenuElementRoleDto) {
        return ResponseResult.success(uaaMenuElementRoleService.save(uaaMenuElementRoleDto));
    }

    @PutMapping
    @ApiOperation(value = "菜单菜单页面元素-角色息 更新")
    public ResponseResult update(@RequestBody UaaMenuElementRoleDto uaaMenuElementRoleDto) {
        return ResponseResult.success(uaaMenuElementRoleService.update(uaaMenuElementRoleDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "菜单菜单页面元素-角色息 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaMenuElementRoleService.removeById(id));
    }

}
