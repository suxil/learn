package io.github.suxil.auth.converter;

import io.github.suxil.auth.domain.UaaOperate;
import io.github.suxil.auth.dto.UaaOperateDto;
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
