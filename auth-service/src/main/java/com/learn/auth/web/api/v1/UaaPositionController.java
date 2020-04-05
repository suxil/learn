package com.learn.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaPosition;
import com.learn.auth.service.UaaPositionService;
import com.learn.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 岗位信息 前端控制器
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@Api(value = "部门信息 接口")
@RestController
@RequestMapping("/api/v1/uaa-positions")
public class UaaPositionController {

    @Autowired
    private UaaPositionService uaaPositionService;

    @GetMapping
    @ApiOperation(value = "部门信息 分页查询")
    @Validated
    public ResponseResult list(UaaPosition uaaPosition, Page<UaaPosition> page) {
        QueryWrapper<UaaPosition> queryWrapper = new QueryWrapper<>();

        IPage<UaaPosition> pageResult = uaaPositionService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "部门信息 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaPositionService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "部门信息 创建")
    public ResponseResult create(@RequestBody UaaPosition uaaPosition) {
        uaaPositionService.saveOrUpdate(uaaPosition);
        return ResponseResult.success(uaaPosition);
    }

    @PutMapping
    @ApiOperation(value = "部门信息 更新")
    public ResponseResult update(@RequestBody UaaPosition uaaPosition) {
        uaaPositionService.saveOrUpdate(uaaPosition);
        return ResponseResult.success(uaaPosition);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "部门信息 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaPositionService.removeById(id));
    }

}
