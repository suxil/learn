package io.github.suxil.service.converter.cdm;

import io.github.suxil.service.domain.cdm.CdmDictCategory;
import io.github.suxil.service.dto.cdm.CdmDictCategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 数据字典类型
 * </p>
 *
 * @author generate
 * @since 2021-04-10
 */
@Mapper
public interface CdmDictCategoryConverter {

    CdmDictCategoryConverter INSTANCE = Mappers.getMapper(CdmDictCategoryConverter.class);

    CdmDictCategory convert(CdmDictCategoryDto item);

    CdmDictCategoryDto convertDto(CdmDictCategory item);

    List<CdmDictCategory> convert(List<CdmDictCategoryDto> list);

    List<CdmDictCategoryDto> convertDto(List<CdmDictCategory> list);

}
