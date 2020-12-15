package io.github.suxil.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.suxil.auth.domain.UaaGroup;
import io.github.suxil.auth.dto.UaaGroupDto;
import io.github.suxil.auth.service.UaaGroupService;
import io.github.suxil.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 组信息 前端控制器
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Slf4j
@Api(value = "组信息 接口")
@RestController
@RequestMapping("/api/v1/uaa-groups")
public class UaaGroupController {

    @Autowired
    private UaaGroupService uaaGroupService;

    @GetMapping
    @ApiOperation(value = "组信息 分页查询")
    @Validated
    public ResponseResult list(UaaGroupDto uaaGroupDto, Page<UaaGroup> page) {
        QueryWrapper<UaaGroup> queryWrapper = new QueryWrapper<>();

        IPage<UaaGroup> pageResult = uaaGroupService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "组信息 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaGroupService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "组信息 创建")
    public ResponseResult create(@RequestBody UaaGroupDto uaaGroupDto) {
        return ResponseResult.success(uaaGroupService.save(uaaGroupDto));
    }

    @PutMapping
    @ApiOperation(value = "组信息 更新")
    public ResponseResult update(@RequestBody UaaGroupDto uaaGroupDto) {
        return ResponseResult.success(uaaGroupService.update(uaaGroupDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "组信息 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaGroupService.removeById(id));
    }

}
