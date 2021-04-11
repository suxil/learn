package io.github.suxil.service.web.api.cdm;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.suxil.core.common.ResponseResult;
import io.github.suxil.core.common.PageResult;
import io.github.suxil.service.dto.cdm.CdmDictDto;
import io.github.suxil.service.service.cdm.CdmDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 数据字典 前端控制器
 * </p>
 *
 * @author generate
 * @since 2021-04-10
 */
@Slf4j
@Api(value = "数据字典 接口")
@RestController
@RequestMapping("/api/v1/cdm-dicts")
public class CdmDictController {

    @Autowired
    private CdmDictService cdmDictService;

    @GetMapping
    @ApiOperation(value = "数据字典 分页查询")
    public ResponseResult<PageResult<CdmDictDto>> list(CdmDictDto cdmDictDto) {
        PageResult<CdmDictDto> pageResult = cdmDictService.page(cdmDictDto);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "数据字典 详情")
    public ResponseResult<CdmDictDto> load(@PathVariable String id) {
        return ResponseResult.success(cdmDictService.getCdmDictById(id));
    }

    @PostMapping
    @ApiOperation(value = "数据字典 创建")
    public ResponseResult<CdmDictDto> create(@RequestBody CdmDictDto cdmDictDto) {
        return ResponseResult.success(cdmDictService.save(cdmDictDto));
    }

    @PutMapping
    @ApiOperation(value = "数据字典 更新")
    public ResponseResult<CdmDictDto> update(@RequestBody CdmDictDto cdmDictDto) {
        return ResponseResult.success(cdmDictService.update(cdmDictDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "数据字典 删除")
    public ResponseResult<Boolean> delete(@PathVariable String id) {
        return ResponseResult.success(cdmDictService.removeById(id));
    }

}
