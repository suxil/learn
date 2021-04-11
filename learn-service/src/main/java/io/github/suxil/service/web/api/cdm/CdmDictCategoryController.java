package io.github.suxil.service.web.api.cdm;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.suxil.core.common.ResponseResult;
import io.github.suxil.core.common.PageResult;
import io.github.suxil.service.dto.cdm.CdmDictCategoryDto;
import io.github.suxil.service.service.cdm.CdmDictCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 数据字典类型 前端控制器
 * </p>
 *
 * @author generate
 * @since 2021-04-10
 */
@Slf4j
@Api(value = "数据字典类型 接口")
@RestController
@RequestMapping("/api/v1/cdm-dict-categorys")
public class CdmDictCategoryController {

    @Autowired
    private CdmDictCategoryService cdmDictCategoryService;

    @GetMapping
    @ApiOperation(value = "数据字典类型 分页查询")
    public ResponseResult<PageResult<CdmDictCategoryDto>> list(CdmDictCategoryDto cdmDictCategoryDto) {
        PageResult<CdmDictCategoryDto> pageResult = cdmDictCategoryService.page(cdmDictCategoryDto);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/tree")
    @ApiOperation(value = "数据字典类型 数据字典类型树")
    public ResponseResult<List<CdmDictCategoryDto>> treeList() {
        List<CdmDictCategoryDto> treeList = cdmDictCategoryService.getTreeList();
        return ResponseResult.success(treeList);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "数据字典类型 详情")
    public ResponseResult<CdmDictCategoryDto> load(@PathVariable String id) {
        return ResponseResult.success(cdmDictCategoryService.getCdmDictCategoryById(id));
    }

    @PostMapping
    @ApiOperation(value = "数据字典类型 创建")
    public ResponseResult<CdmDictCategoryDto> create(@RequestBody CdmDictCategoryDto cdmDictCategoryDto) {
        return ResponseResult.success(cdmDictCategoryService.save(cdmDictCategoryDto));
    }

    @PutMapping
    @ApiOperation(value = "数据字典类型 更新")
    public ResponseResult<CdmDictCategoryDto> update(@RequestBody CdmDictCategoryDto cdmDictCategoryDto) {
        return ResponseResult.success(cdmDictCategoryService.update(cdmDictCategoryDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "数据字典类型 删除")
    public ResponseResult<Boolean> delete(@PathVariable String id) {
        return ResponseResult.success(cdmDictCategoryService.removeById(id));
    }

}
