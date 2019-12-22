package com.learn.auth.web.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaOffice;
import com.learn.auth.service.UaaOfficeService;
import com.learn.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 组织信息 前端控制器
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@Api(value = "组织信息 接口")
@RestController
@RequestMapping("/api/v1/uaa-offices")
public class UaaOfficeController {

    @Autowired
    private UaaOfficeService uaaOfficeService;

    @GetMapping
    @ApiOperation(value = "组织信息 分页查询")
    @Validated
    public ResponseResult list(UaaOffice uaaOffice, Page<UaaOffice> page) {
        QueryWrapper<UaaOffice> queryWrapper = new QueryWrapper<>();

        IPage<UaaOffice> pageResult = uaaOfficeService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "组织信息 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaOfficeService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "组织信息 创建")
    public ResponseResult create(@RequestBody UaaOffice uaaOffice) {
        uaaOfficeService.saveOrUpdate(uaaOffice);
        return ResponseResult.success(uaaOffice);
    }

    @PutMapping
    @ApiOperation(value = "组织信息 更新")
    public ResponseResult update(@RequestBody UaaOffice uaaOffice) {
        uaaOfficeService.saveOrUpdate(uaaOffice);
        return ResponseResult.success(uaaOffice);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "组织信息 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaOfficeService.removeById(id));
    }

}
