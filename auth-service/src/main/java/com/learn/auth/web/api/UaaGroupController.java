package com.learn.auth.web.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaGroup;
import com.learn.auth.service.IUaaGroupService;
import com.learn.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 组信息 前端控制器
 * </p>
 *
 * @author generate
 * @since 2019-11-21
 */
@Api(value = "组信息 接口")
@RestController
@RequestMapping("/api/v1/uaa-groups")
public class UaaGroupController {

    @Autowired
    private IUaaGroupService uaaGroupService;

    @GetMapping
    @ApiOperation(value = "组信息 分页查询")
    @Validated
    public ResponseResult list(UaaGroup uaaGroup, Page<UaaGroup> page) {
        QueryWrapper<UaaGroup> queryWrapper = new QueryWrapper<>();

        IPage<UaaGroup> pageResult = uaaGroupService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "组信息 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaGroupService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "组信息 创建")
    public ResponseResult create(@RequestBody UaaGroup uaaGroup) {
        uaaGroupService.saveOrUpdate(uaaGroup);
        return ResponseResult.success(uaaGroup);
    }

    @PutMapping
    @ApiOperation(value = "组信息 更新")
    public ResponseResult update(@RequestBody UaaGroup uaaGroup) {
        uaaGroupService.saveOrUpdate(uaaGroup);
        return ResponseResult.success(uaaGroup);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "组信息 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaGroupService.removeById(id));
    }

}
