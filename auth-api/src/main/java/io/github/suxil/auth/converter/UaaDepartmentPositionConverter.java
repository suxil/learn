package io.github.suxil.auth.converter;

import io.github.suxil.auth.domain.UaaDepartmentPosition;
import io.github.suxil.auth.dto.UaaDepartmentPositionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 部门-岗位信息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Mapper
public interface UaaDepartmentPositionConverter {

    UaaDepartmentPositionConverter INSTANCE = Mappers.getMapper(UaaDepartmentPositionConverter.class);

    UaaDepartmentPosition convert(UaaDepartmentPositionDto item);

    UaaDepartmentPositionDto convertDto(UaaDepartmentPosition item);

    List<UaaDepartmentPosition> convert(List<UaaDepartmentPositionDto> list);

    List<UaaDepartmentPositionDto> convertDto(List<UaaDepartmentPosition> list);

}
