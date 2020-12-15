package io.github.suxil.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.suxil.auth.domain.UaaMenu;
import io.github.suxil.auth.dto.UaaMenuDto;
import io.github.suxil.auth.service.UaaMenuService;
import io.github.suxil.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 菜单信息 前端控制器
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Slf4j
@Api(value = "菜单信息 接口")
@RestController
@RequestMapping("/api/v1/uaa-menus")
public class UaaMenuController {

    @Autowired
    private UaaMenuService uaaMenuService;

    @GetMapping
    @ApiOperation(value = "菜单信息 分页查询")
    @Validated
    public ResponseResult list(UaaMenuDto uaaMenuDto, Page<UaaMenu> page) {
        QueryWrapper<UaaMenu> queryWrapper = new QueryWrapper<>();

        IPage<UaaMenu> pageResult = uaaMenuService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "菜单信息 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaMenuService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "菜单信息 创建")
    public ResponseResult create(@RequestBody UaaMenuDto uaaMenuDto) {
        return ResponseResult.success(uaaMenuService.save(uaaMenuDto));
    }

    @PutMapping
    @ApiOperation(value = "菜单信息 更新")
    public ResponseResult update(@RequestBody UaaMenuDto uaaMenuDto) {
        return ResponseResult.success(uaaMenuService.update(uaaMenuDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "菜单信息 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaMenuService.removeById(id));
    }

}
