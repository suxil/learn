package io.github.suxil.service.web.api.cdm;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.suxil.core.common.ResponseResult;
import io.github.suxil.core.common.PageResult;
import io.github.suxil.service.dto.cdm.CdmTimeSegmentDto;
import io.github.suxil.service.service.cdm.CdmTimeSegmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 时间片段 前端控制器
 * </p>
 *
 * @author generate
 * @since 2021-04-10
 */
@Slf4j
@Api(value = "时间片段 接口")
@RestController
@RequestMapping("/api/v1/cdm-time-segments")
public class CdmTimeSegmentController {

    @Autowired
    private CdmTimeSegmentService cdmTimeSegmentService;

    @GetMapping
    @ApiOperation(value = "时间片段 分页查询")
    public ResponseResult<PageResult<CdmTimeSegmentDto>> list(CdmTimeSegmentDto cdmTimeSegmentDto) {
        PageResult<CdmTimeSegmentDto> pageResult = cdmTimeSegmentService.page(cdmTimeSegmentDto);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "时间片段 详情")
    public ResponseResult<CdmTimeSegmentDto> load(@PathVariable String id) {
        return ResponseResult.success(cdmTimeSegmentService.getCdmTimeSegmentById(id));
    }

    @PostMapping
    @ApiOperation(value = "时间片段 创建")
    public ResponseResult<CdmTimeSegmentDto> create(@RequestBody CdmTimeSegmentDto cdmTimeSegmentDto) {
        return ResponseResult.success(cdmTimeSegmentService.save(cdmTimeSegmentDto));
    }

    @PutMapping
    @ApiOperation(value = "时间片段 更新")
    public ResponseResult<CdmTimeSegmentDto> update(@RequestBody CdmTimeSegmentDto cdmTimeSegmentDto) {
        return ResponseResult.success(cdmTimeSegmentService.update(cdmTimeSegmentDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "时间片段 删除")
    public ResponseResult<Boolean> delete(@PathVariable String id) {
        return ResponseResult.success(cdmTimeSegmentService.removeById(id));
    }

}
