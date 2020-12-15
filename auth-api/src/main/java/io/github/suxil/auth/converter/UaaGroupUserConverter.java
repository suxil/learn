package io.github.suxil.auth.converter;

import io.github.suxil.auth.domain.UaaGroupUser;
import io.github.suxil.auth.dto.UaaGroupUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 组-用户信息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Mapper
public interface UaaGroupUserConverter {

    UaaGroupUserConverter INSTANCE = Mappers.getMapper(UaaGroupUserConverter.class);

    UaaGroupUser convert(UaaGroupUserDto item);

    UaaGroupUserDto convertDto(UaaGroupUser item);

    List<UaaGroupUser> convert(List<UaaGroupUserDto> list);

    List<UaaGroupUserDto> convertDto(List<UaaGroupUser> list);

}
