package com.learn.auth.converter;

import com.learn.auth.domain.UaaUserPosition;
import com.learn.auth.dto.UaaUserPositionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 用户-岗位信息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Mapper
public interface UaaUserPositionConverter {

    UaaUserPositionConverter INSTANCE = Mappers.getMapper(UaaUserPositionConverter.class);

    UaaUserPosition convert(UaaUserPositionDto item);

    UaaUserPositionDto convertDto(UaaUserPosition item);

    List<UaaUserPosition> convert(List<UaaUserPositionDto> list);

    List<UaaUserPositionDto> convertDto(List<UaaUserPosition> list);

}
