package io.github.suxil.service.converter.cdm;

import io.github.suxil.service.domain.cdm.CdmTimeSegment;
import io.github.suxil.service.dto.cdm.CdmTimeSegmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 时间片段
 * </p>
 *
 * @author generate
 * @since 2021-04-10
 */
@Mapper
public interface CdmTimeSegmentConverter {

    CdmTimeSegmentConverter INSTANCE = Mappers.getMapper(CdmTimeSegmentConverter.class);

    CdmTimeSegment convert(CdmTimeSegmentDto item);

    CdmTimeSegmentDto convertDto(CdmTimeSegment item);

    List<CdmTimeSegment> convert(List<CdmTimeSegmentDto> list);

    List<CdmTimeSegmentDto> convertDto(List<CdmTimeSegment> list);

}
