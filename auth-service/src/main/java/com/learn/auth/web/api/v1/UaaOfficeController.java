package com.learn.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaOffice;
import com.learn.auth.service.UaaOfficeService;
import com.learn.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 组织表 前端控制器
 * </p>
 *
 * @author generate
 * @since 2020-04-20
 */
@Slf4j
@Api(value = "组织表 接口")
@RestController
@RequestMapping("/api/v1/uaa-offices")
public class UaaOfficeController {

    @Autowired
    private UaaOfficeService uaaOfficeService;

    @GetMapping
    @ApiOperation(value = "组织表 分页查询")
    @Validated
    public ResponseResult list(UaaOffice uaaOffice, Page<UaaOffice> page) {
        QueryWrapper<UaaOffice> queryWrapper = new QueryWrapper<>();

        IPage<UaaOffice> pageResult = uaaOfficeService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "组织表 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaOfficeService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "组织表 创建")
    public ResponseResult create(@RequestBody UaaOffice uaaOffice) {
        uaaOfficeService.saveOrUpdate(uaaOffice);
        return ResponseResult.success(uaaOffice);
    }

    @PutMapping
    @ApiOperation(value = "组织表 更新")
    public ResponseResult update(@RequestBody UaaOffice uaaOffice) {
        uaaOfficeService.saveOrUpdate(uaaOffice);
        return ResponseResult.success(uaaOffice);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "组织表 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaOfficeService.removeById(id));
    }

}
