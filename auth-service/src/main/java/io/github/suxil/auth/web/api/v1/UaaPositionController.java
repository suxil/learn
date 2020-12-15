package io.github.suxil.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.suxil.auth.domain.UaaPosition;
import io.github.suxil.auth.dto.UaaPositionDto;
import io.github.suxil.auth.service.UaaPositionService;
import io.github.suxil.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 岗位信息 前端控制器
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Slf4j
@Api(value = "岗位信息 接口")
@RestController
@RequestMapping("/api/v1/uaa-positions")
public class UaaPositionController {

    @Autowired
    private UaaPositionService uaaPositionService;

    @GetMapping
    @ApiOperation(value = "岗位信息 分页查询")
    @Validated
    public ResponseResult list(UaaPositionDto uaaPositionDto, Page<UaaPosition> page) {
        QueryWrapper<UaaPosition> queryWrapper = new QueryWrapper<>();

        IPage<UaaPosition> pageResult = uaaPositionService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "岗位信息 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaPositionService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "岗位信息 创建")
    public ResponseResult create(@RequestBody UaaPositionDto uaaPositionDto) {
        return ResponseResult.success(uaaPositionService.save(uaaPositionDto));
    }

    @PutMapping
    @ApiOperation(value = "岗位信息 更新")
    public ResponseResult update(@RequestBody UaaPositionDto uaaPositionDto) {
        return ResponseResult.success(uaaPositionService.update(uaaPositionDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "岗位信息 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaPositionService.removeById(id));
    }

}
