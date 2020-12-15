package io.github.suxil.auth.converter;

import io.github.suxil.auth.domain.UaaUserLoginLog;
import io.github.suxil.auth.dto.UaaUserLoginLogDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 用户登录日志
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Mapper
public interface UaaUserLoginLogConverter {

    UaaUserLoginLogConverter INSTANCE = Mappers.getMapper(UaaUserLoginLogConverter.class);

    UaaUserLoginLog convert(UaaUserLoginLogDto item);

    UaaUserLoginLogDto convertDto(UaaUserLoginLog item);

    List<UaaUserLoginLog> convert(List<UaaUserLoginLogDto> list);

    List<UaaUserLoginLogDto> convertDto(List<UaaUserLoginLog> list);

}
