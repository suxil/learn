package com.learn.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaDepartmentPosition;
import com.learn.auth.service.UaaDepartmentPositionService;
import com.learn.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 部门-岗位表 前端控制器
 * </p>
 *
 * @author generate
 * @since 2020-04-20
 */
@Slf4j
@Api(value = "部门-岗位表 接口")
@RestController
@RequestMapping("/api/v1/uaa-department-positions")
public class UaaDepartmentPositionController {

    @Autowired
    private UaaDepartmentPositionService uaaDepartmentPositionService;

    @GetMapping
    @ApiOperation(value = "部门-岗位表 分页查询")
    @Validated
    public ResponseResult list(UaaDepartmentPosition uaaDepartmentPosition, Page<UaaDepartmentPosition> page) {
        QueryWrapper<UaaDepartmentPosition> queryWrapper = new QueryWrapper<>();

        IPage<UaaDepartmentPosition> pageResult = uaaDepartmentPositionService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "部门-岗位表 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaDepartmentPositionService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "部门-岗位表 创建")
    public ResponseResult create(@RequestBody UaaDepartmentPosition uaaDepartmentPosition) {
        uaaDepartmentPositionService.saveOrUpdate(uaaDepartmentPosition);
        return ResponseResult.success(uaaDepartmentPosition);
    }

    @PutMapping
    @ApiOperation(value = "部门-岗位表 更新")
    public ResponseResult update(@RequestBody UaaDepartmentPosition uaaDepartmentPosition) {
        uaaDepartmentPositionService.saveOrUpdate(uaaDepartmentPosition);
        return ResponseResult.success(uaaDepartmentPosition);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "部门-岗位表 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaDepartmentPositionService.removeById(id));
    }

}
