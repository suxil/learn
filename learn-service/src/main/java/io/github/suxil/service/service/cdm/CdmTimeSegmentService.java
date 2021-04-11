package io.github.suxil.service.service.cdm;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.suxil.core.common.PageResult;
import io.github.suxil.mybatis.service.BaseService;
import io.github.suxil.service.domain.cdm.CdmTimeSegment;
import io.github.suxil.service.dto.cdm.CdmTimeSegmentDto;

/**
 * <p>
 * 时间片段 服务类
 * </p>
 *
 * @author generate
 * @since 2021-04-10
 */
public interface CdmTimeSegmentService extends BaseService<CdmTimeSegment> {

    /**
     * 分页查询 时间片段
     */
    PageResult<CdmTimeSegmentDto> page(CdmTimeSegmentDto cdmTimeSegmentDto);

    /**
     * 加载 时间片段
     */
    CdmTimeSegmentDto getCdmTimeSegmentById(String id);

    /**
     * 保存 时间片段
     */
    CdmTimeSegmentDto save(CdmTimeSegmentDto cdmTimeSegmentDto);

    /**
     * 更新 时间片段
     */
    CdmTimeSegmentDto update(CdmTimeSegmentDto cdmTimeSegmentDto);

}
