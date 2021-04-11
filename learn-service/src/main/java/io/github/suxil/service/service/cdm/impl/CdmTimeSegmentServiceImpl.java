package io.github.suxil.service.service.cdm.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.github.suxil.core.common.PageResult;
import io.github.suxil.core.util.PageUtils;
import io.github.suxil.service.converter.cdm.CdmTimeSegmentConverter;
import io.github.suxil.service.domain.cdm.CdmTimeSegment;
import io.github.suxil.service.dto.cdm.CdmTimeSegmentDto;
import io.github.suxil.service.mapper.cdm.CdmTimeSegmentMapper;
import io.github.suxil.service.service.cdm.CdmTimeSegmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 时间片段 服务实现类
 * </p>
 *
 * @author generate
 * @since 2021-04-10
 */
@Service
@Slf4j
public class CdmTimeSegmentServiceImpl extends ServiceImpl<CdmTimeSegmentMapper, CdmTimeSegment> implements CdmTimeSegmentService {

    @Override
    public PageResult<CdmTimeSegmentDto> page(CdmTimeSegmentDto cdmTimeSegmentDto) {
        QueryWrapper<CdmTimeSegment> queryWrapper = new QueryWrapper<>();

        PageInfo<CdmTimeSegment> pageInfo = PageHelper.startPage(cdmTimeSegmentDto.getPage().intValue(), cdmTimeSegmentDto.getSize().intValue())
            .doSelectPageInfo(() -> list(queryWrapper));

        PageResult<CdmTimeSegmentDto> pageResult = PageUtils.pageInfoToPageResult(pageInfo);
        pageResult.setList(CdmTimeSegmentConverter.INSTANCE.convertDto(pageInfo.getList()));

        return pageResult;
    }

    @Override
    public CdmTimeSegmentDto getCdmTimeSegmentById(String id) {
        CdmTimeSegment cdmTimeSegment = getById(id);

        return CdmTimeSegmentConverter.INSTANCE.convertDto(cdmTimeSegment);
    }

    @Override
    public CdmTimeSegmentDto save(CdmTimeSegmentDto cdmTimeSegmentDto) {
        CdmTimeSegment cdmTimeSegment = CdmTimeSegmentConverter.INSTANCE.convert(cdmTimeSegmentDto);

        save(cdmTimeSegment);

        return CdmTimeSegmentConverter.INSTANCE.convertDto(cdmTimeSegment);
    }

    @Override
    public CdmTimeSegmentDto update(CdmTimeSegmentDto cdmTimeSegmentDto) {
        CdmTimeSegment cdmTimeSegment = CdmTimeSegmentConverter.INSTANCE.convert(cdmTimeSegmentDto);

        updateById(cdmTimeSegment);

        return CdmTimeSegmentConverter.INSTANCE.convertDto(cdmTimeSegment);
    }

}
