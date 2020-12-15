package io.github.suxil.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.suxil.auth.domain.UaaUserPermission;
import io.github.suxil.auth.dto.UaaUserPermissionDto;
import io.github.suxil.auth.service.UaaUserPermissionService;
import io.github.suxil.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户-权限信息 前端控制器
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Slf4j
@Api(value = "用户-权限信息 接口")
@RestController
@RequestMapping("/api/v1/uaa-user-permissions")
public class UaaUserPermissionController {

    @Autowired
    private UaaUserPermissionService uaaUserPermissionService;

    @GetMapping
    @ApiOperation(value = "用户-权限信息 分页查询")
    @Validated
    public ResponseResult list(UaaUserPermissionDto uaaUserPermissionDto, Page<UaaUserPermission> page) {
        QueryWrapper<UaaUserPermission> queryWrapper = new QueryWrapper<>();

        IPage<UaaUserPermission> pageResult = uaaUserPermissionService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "用户-权限信息 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaUserPermissionService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "用户-权限信息 创建")
    public ResponseResult create(@RequestBody UaaUserPermissionDto uaaUserPermissionDto) {
        return ResponseResult.success(uaaUserPermissionService.save(uaaUserPermissionDto));
    }

    @PutMapping
    @ApiOperation(value = "用户-权限信息 更新")
    public ResponseResult update(@RequestBody UaaUserPermissionDto uaaUserPermissionDto) {
        return ResponseResult.success(uaaUserPermissionService.update(uaaUserPermissionDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "用户-权限信息 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaUserPermissionService.removeById(id));
    }

}
