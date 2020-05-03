package com.learn.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaOperate;
import com.learn.auth.dto.UaaOperateDto;
import com.learn.auth.service.UaaOperateService;
import com.learn.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 操作信息 前端控制器
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Slf4j
@Api(value = "操作信息 接口")
@RestController
@RequestMapping("/api/v1/uaa-operates")
public class UaaOperateController {

    @Autowired
    private UaaOperateService uaaOperateService;

    @GetMapping
    @ApiOperation(value = "操作信息 分页查询")
    @Validated
    public ResponseResult list(UaaOperateDto uaaOperateDto, Page<UaaOperate> page) {
        QueryWrapper<UaaOperate> queryWrapper = new QueryWrapper<>();

        IPage<UaaOperate> pageResult = uaaOperateService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "操作信息 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaOperateService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "操作信息 创建")
    public ResponseResult create(@RequestBody UaaOperateDto uaaOperateDto) {
        return ResponseResult.success(uaaOperateService.save(uaaOperateDto));
    }

    @PutMapping
    @ApiOperation(value = "操作信息 更新")
    public ResponseResult update(@RequestBody UaaOperateDto uaaOperateDto) {
        return ResponseResult.success(uaaOperateService.update(uaaOperateDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "操作信息 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaOperateService.removeById(id));
    }

}
