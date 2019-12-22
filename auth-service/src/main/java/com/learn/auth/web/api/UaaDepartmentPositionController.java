package com.learn.auth.web.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaDepartmentPosition;
import com.learn.auth.service.UaaDepartmentPositionService;
import com.learn.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 部门-岗位信息 前端控制器
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@Api(value = "部门-岗位信息 接口")
@RestController
@RequestMapping("/api/v1/uaa-department-positions")
public class UaaDepartmentPositionController {

    @Autowired
    private UaaDepartmentPositionService uaaDepartmentPositionService;

    @GetMapping
    @ApiOperation(value = "部门-岗位信息 分页查询")
    @Validated
    public ResponseResult list(UaaDepartmentPosition uaaDepartmentPosition, Page<UaaDepartmentPosition> page) {
        QueryWrapper<UaaDepartmentPosition> queryWrapper = new QueryWrapper<>();

        IPage<UaaDepartmentPosition> pageResult = uaaDepartmentPositionService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "部门-岗位信息 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaDepartmentPositionService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "部门-岗位信息 创建")
    public ResponseResult create(@RequestBody UaaDepartmentPosition uaaDepartmentPosition) {
        uaaDepartmentPositionService.saveOrUpdate(uaaDepartmentPosition);
        return ResponseResult.success(uaaDepartmentPosition);
    }

    @PutMapping
    @ApiOperation(value = "部门-岗位信息 更新")
    public ResponseResult update(@RequestBody UaaDepartmentPosition uaaDepartmentPosition) {
        uaaDepartmentPositionService.saveOrUpdate(uaaDepartmentPosition);
        return ResponseResult.success(uaaDepartmentPosition);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "部门-岗位信息 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaDepartmentPositionService.removeById(id));
    }

}
