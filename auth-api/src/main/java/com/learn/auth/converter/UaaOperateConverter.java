package com.learn.auth.converter;

import com.learn.auth.domain.UaaOperate;
import com.learn.auth.dto.UaaOperateDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 操作信息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Mapper
public interface UaaOperateConverter {

    UaaOperateConverter INSTANCE = Mappers.getMapper(UaaOperateConverter.class);

    UaaOperate convert(UaaOperateDto item);

    UaaOperateDto convertDto(UaaOperate item);

    List<UaaOperate> convert(List<UaaOperateDto> list);

    List<UaaOperateDto> convertDto(List<UaaOperate> list);

}
