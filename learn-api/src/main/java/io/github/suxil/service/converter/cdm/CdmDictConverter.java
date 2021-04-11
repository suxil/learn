package io.github.suxil.service.converter.cdm;

import io.github.suxil.service.domain.cdm.CdmDict;
import io.github.suxil.service.dto.cdm.CdmDictDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 数据字典
 * </p>
 *
 * @author generate
 * @since 2021-04-10
 */
@Mapper
public interface CdmDictConverter {

    CdmDictConverter INSTANCE = Mappers.getMapper(CdmDictConverter.class);

    CdmDict convert(CdmDictDto item);

    CdmDictDto convertDto(CdmDict item);

    List<CdmDict> convert(List<CdmDictDto> list);

    List<CdmDictDto> convertDto(List<CdmDict> list);

}
