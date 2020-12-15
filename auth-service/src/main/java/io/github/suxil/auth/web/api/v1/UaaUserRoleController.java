package io.github.suxil.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.suxil.auth.domain.UaaUserRole;
import io.github.suxil.auth.dto.UaaUserRoleDto;
import io.github.suxil.auth.service.UaaUserRoleService;
import io.github.suxil.core.common.ResponseResult;
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
@RequestMapping("/api/v1/uaa-user-roles")
public class UaaUserRoleController {

    @Autowired
    private UaaUserRoleService uaaUserRoleService;

    @GetMapping
    @ApiOperation(value = "角色信息 分页查询")
    @Validated
    public ResponseResult list(UaaUserRoleDto uaaUserRoleDto, Page<UaaUserRole> page) {
        QueryWrapper<UaaUserRole> queryWrapper = new QueryWrapper<>();

        IPage<UaaUserRole> pageResult = uaaUserRoleService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "角色信息 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaUserRoleService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "角色信息 创建")
    public ResponseResult create(@RequestBody UaaUserRoleDto uaaUserRoleDto) {
        return ResponseResult.success(uaaUserRoleService.save(uaaUserRoleDto));
    }

    @PutMapping
    @ApiOperation(value = "角色信息 更新")
    public ResponseResult update(@RequestBody UaaUserRoleDto uaaUserRoleDto) {
        return ResponseResult.success(uaaUserRoleService.update(uaaUserRoleDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "角色信息 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaUserRoleService.removeById(id));
    }

}
