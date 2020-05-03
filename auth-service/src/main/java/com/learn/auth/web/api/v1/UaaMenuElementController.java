package com.learn.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaMenuElement;
import com.learn.auth.dto.UaaMenuElementDto;
import com.learn.auth.service.UaaMenuElementService;
import com.learn.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 菜单页面元素信息 前端控制器
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Slf4j
@Api(value = "菜单页面元素信息 接口")
@RestController
@RequestMapping("/api/v1/uaa-menu-elements")
public class UaaMenuElementController {

    @Autowired
    private UaaMenuElementService uaaMenuElementService;

    @GetMapping
    @ApiOperation(value = "菜单页面元素信息 分页查询")
    @Validated
    public ResponseResult list(UaaMenuElementDto uaaMenuElementDto, Page<UaaMenuElement> page) {
        QueryWrapper<UaaMenuElement> queryWrapper = new QueryWrapper<>();

        IPage<UaaMenuElement> pageResult = uaaMenuElementService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "菜单页面元素信息 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaMenuElementService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "菜单页面元素信息 创建")
    public ResponseResult create(@RequestBody UaaMenuElementDto uaaMenuElementDto) {
        return ResponseResult.success(uaaMenuElementService.save(uaaMenuElementDto));
    }

    @PutMapping
    @ApiOperation(value = "菜单页面元素信息 更新")
    public ResponseResult update(@RequestBody UaaMenuElementDto uaaMenuElementDto) {
        return ResponseResult.success(uaaMenuElementService.update(uaaMenuElementDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "菜单页面元素信息 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaMenuElementService.removeById(id));
    }

}
