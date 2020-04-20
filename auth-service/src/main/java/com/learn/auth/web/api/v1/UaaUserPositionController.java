package com.learn.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaUserPosition;
import com.learn.auth.service.UaaUserPositionService;
import com.learn.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户-岗位表 前端控制器
 * </p>
 *
 * @author generate
 * @since 2020-04-20
 */
@Slf4j
@Api(value = "用户-岗位表 接口")
@RestController
@RequestMapping("/api/v1/uaa-user-positions")
public class UaaUserPositionController {

    @Autowired
    private UaaUserPositionService uaaUserPositionService;

    @GetMapping
    @ApiOperation(value = "用户-岗位表 分页查询")
    @Validated
    public ResponseResult list(UaaUserPosition uaaUserPosition, Page<UaaUserPosition> page) {
        QueryWrapper<UaaUserPosition> queryWrapper = new QueryWrapper<>();

        IPage<UaaUserPosition> pageResult = uaaUserPositionService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "用户-岗位表 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaUserPositionService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "用户-岗位表 创建")
    public ResponseResult create(@RequestBody UaaUserPosition uaaUserPosition) {
        uaaUserPositionService.saveOrUpdate(uaaUserPosition);
        return ResponseResult.success(uaaUserPosition);
    }

    @PutMapping
    @ApiOperation(value = "用户-岗位表 更新")
    public ResponseResult update(@RequestBody UaaUserPosition uaaUserPosition) {
        uaaUserPositionService.saveOrUpdate(uaaUserPosition);
        return ResponseResult.success(uaaUserPosition);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "用户-岗位表 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaUserPositionService.removeById(id));
    }

}
