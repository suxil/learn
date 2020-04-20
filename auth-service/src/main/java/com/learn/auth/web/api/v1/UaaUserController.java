package com.learn.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaUser;
import com.learn.auth.service.UaaUserService;
import com.learn.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author generate
 * @since 2020-04-20
 */
@Slf4j
@Api(value = "用户表 接口")
@RestController
@RequestMapping("/api/v1/uaa-users")
public class UaaUserController {

    @Autowired
    private UaaUserService uaaUserService;

    @GetMapping
    @ApiOperation(value = "用户表 分页查询")
    @Validated
    public ResponseResult list(UaaUser uaaUser, Page<UaaUser> page) {
        QueryWrapper<UaaUser> queryWrapper = new QueryWrapper<>();

        IPage<UaaUser> pageResult = uaaUserService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "用户表 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaUserService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "用户表 创建")
    public ResponseResult create(@RequestBody UaaUser uaaUser) {
        uaaUserService.saveOrUpdate(uaaUser);
        return ResponseResult.success(uaaUser);
    }

    @PutMapping
    @ApiOperation(value = "用户表 更新")
    public ResponseResult update(@RequestBody UaaUser uaaUser) {
        uaaUserService.saveOrUpdate(uaaUser);
        return ResponseResult.success(uaaUser);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "用户表 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaUserService.removeById(id));
    }

}
