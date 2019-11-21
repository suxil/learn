package com.learn.auth.web.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaGroupUser;
import com.learn.auth.service.IUaaGroupUserService;
import com.learn.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 组-用户信息 前端控制器
 * </p>
 *
 * @author generate
 * @since 2019-11-21
 */
@Api(value = "组-用户信息 接口")
@RestController
@RequestMapping("/api/v1/uaa-group-users")
public class UaaGroupUserController {

    @Autowired
    private IUaaGroupUserService uaaGroupUserService;

    @GetMapping
    @ApiOperation(value = "组-用户信息 分页查询")
    @Validated
    public ResponseResult list(UaaGroupUser uaaGroupUser, Page<UaaGroupUser> page) {
        QueryWrapper<UaaGroupUser> queryWrapper = new QueryWrapper<>();

        IPage<UaaGroupUser> pageResult = uaaGroupUserService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "组-用户信息 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaGroupUserService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "组-用户信息 创建")
    public ResponseResult create(@RequestBody UaaGroupUser uaaGroupUser) {
        uaaGroupUserService.saveOrUpdate(uaaGroupUser);
        return ResponseResult.success(uaaGroupUser);
    }

    @PutMapping
    @ApiOperation(value = "组-用户信息 更新")
    public ResponseResult update(@RequestBody UaaGroupUser uaaGroupUser) {
        uaaGroupUserService.saveOrUpdate(uaaGroupUser);
        return ResponseResult.success(uaaGroupUser);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "组-用户信息 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaGroupUserService.removeById(id));
    }

}
