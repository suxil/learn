package com.learn.auth.web.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaPageElement;
import com.learn.auth.service.UaaPageElementService;
import com.learn.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 页面元素信息 前端控制器
 * </p>
 *
 * @author generate
 * @since 2019-11-24
 */
@Api(value = "页面元素信息 接口")
@RestController
@RequestMapping("/api/v1/uaa-page-elements")
public class UaaPageElementController {

    @Autowired
    private UaaPageElementService uaaPageElementService;

    @GetMapping
    @ApiOperation(value = "页面元素信息 分页查询")
    @Validated
    public ResponseResult list(UaaPageElement uaaPageElement, Page<UaaPageElement> page) {
        QueryWrapper<UaaPageElement> queryWrapper = new QueryWrapper<>();

        IPage<UaaPageElement> pageResult = uaaPageElementService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "页面元素信息 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaPageElementService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "页面元素信息 创建")
    public ResponseResult create(@RequestBody UaaPageElement uaaPageElement) {
        uaaPageElementService.saveOrUpdate(uaaPageElement);
        return ResponseResult.success(uaaPageElement);
    }

    @PutMapping
    @ApiOperation(value = "页面元素信息 更新")
    public ResponseResult update(@RequestBody UaaPageElement uaaPageElement) {
        uaaPageElementService.saveOrUpdate(uaaPageElement);
        return ResponseResult.success(uaaPageElement);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "页面元素信息 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaPageElementService.removeById(id));
    }

}
