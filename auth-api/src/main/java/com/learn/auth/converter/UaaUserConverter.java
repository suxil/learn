package com.learn.auth.converter;

import com.learn.auth.domain.UaaUser;
import com.learn.auth.dto.UaaUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Mapper
public interface UaaUserConverter {

    UaaUserConverter INSTANCE = Mappers.getMapper(UaaUserConverter.class);

    UaaUser convert(UaaUserDto item);

    UaaUserDto convertDto(UaaUser item);

    List<UaaUser> convert(List<UaaUserDto> list);

    List<UaaUserDto> convertDto(List<UaaUser> list);

}
