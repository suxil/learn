package io.github.suxil.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.suxil.auth.domain.UaaOffice;
import io.github.suxil.auth.dto.UaaOfficeDto;
import io.github.suxil.auth.service.UaaOfficeService;
import io.github.suxil.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 组织信息 前端控制器
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Slf4j
@Api(value = "组织信息 接口")
@RestController
@RequestMapping("/api/v1/uaa-offices")
public class UaaOfficeController {

    @Autowired
    private UaaOfficeService uaaOfficeService;

    @GetMapping
    @ApiOperation(value = "组织信息 分页查询")
    @Validated
    public ResponseResult list(UaaOfficeDto uaaOfficeDto, Page<UaaOffice> page) {
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
    public ResponseResult create(@RequestBody UaaOfficeDto uaaOfficeDto) {
        return ResponseResult.success(uaaOfficeService.save(uaaOfficeDto));
    }

    @PutMapping
    @ApiOperation(value = "组织信息 更新")
    public ResponseResult update(@RequestBody UaaOfficeDto uaaOfficeDto) {
        return ResponseResult.success(uaaOfficeService.update(uaaOfficeDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "组织信息 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaOfficeService.removeById(id));
    }

}
