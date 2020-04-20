package com.learn.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaGroupUser;
import com.learn.auth.service.UaaGroupUserService;
import com.learn.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 组-用户表 前端控制器
 * </p>
 *
 * @author generate
 * @since 2020-04-20
 */
@Slf4j
@Api(value = "组-用户表 接口")
@RestController
@RequestMapping("/api/v1/uaa-group-users")
public class UaaGroupUserController {

    @Autowired
    private UaaGroupUserService uaaGroupUserService;

    @GetMapping
    @ApiOperation(value = "组-用户表 分页查询")
    @Validated
    public ResponseResult list(UaaGroupUser uaaGroupUser, Page<UaaGroupUser> page) {
        QueryWrapper<UaaGroupUser> queryWrapper = new QueryWrapper<>();

        IPage<UaaGroupUser> pageResult = uaaGroupUserService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "组-用户表 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaGroupUserService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "组-用户表 创建")
    public ResponseResult create(@RequestBody UaaGroupUser uaaGroupUser) {
        uaaGroupUserService.saveOrUpdate(uaaGroupUser);
        return ResponseResult.success(uaaGroupUser);
    }

    @PutMapping
    @ApiOperation(value = "组-用户表 更新")
    public ResponseResult update(@RequestBody UaaGroupUser uaaGroupUser) {
        uaaGroupUserService.saveOrUpdate(uaaGroupUser);
        return ResponseResult.success(uaaGroupUser);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "组-用户表 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaGroupUserService.removeById(id));
    }

}
