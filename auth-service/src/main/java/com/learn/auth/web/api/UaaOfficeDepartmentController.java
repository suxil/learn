package com.learn.auth.web.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaOfficeDepartment;
import com.learn.auth.service.UaaOfficeDepartmentService;
import com.learn.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 组织-部门信息 前端控制器
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@Api(value = "组织-部门信息 接口")
@RestController
@RequestMapping("/api/v1/uaa-office-departments")
public class UaaOfficeDepartmentController {

    @Autowired
    private UaaOfficeDepartmentService uaaOfficeDepartmentService;

    @GetMapping
    @ApiOperation(value = "组织-部门信息 分页查询")
    @Validated
    public ResponseResult list(UaaOfficeDepartment uaaOfficeDepartment, Page<UaaOfficeDepartment> page) {
        QueryWrapper<UaaOfficeDepartment> queryWrapper = new QueryWrapper<>();

        IPage<UaaOfficeDepartment> pageResult = uaaOfficeDepartmentService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "组织-部门信息 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaOfficeDepartmentService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "组织-部门信息 创建")
    public ResponseResult create(@RequestBody UaaOfficeDepartment uaaOfficeDepartment) {
        uaaOfficeDepartmentService.saveOrUpdate(uaaOfficeDepartment);
        return ResponseResult.success(uaaOfficeDepartment);
    }

    @PutMapping
    @ApiOperation(value = "组织-部门信息 更新")
    public ResponseResult update(@RequestBody UaaOfficeDepartment uaaOfficeDepartment) {
        uaaOfficeDepartmentService.saveOrUpdate(uaaOfficeDepartment);
        return ResponseResult.success(uaaOfficeDepartment);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "组织-部门信息 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaOfficeDepartmentService.removeById(id));
    }

}
