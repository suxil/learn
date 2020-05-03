package com.learn.auth.converter;

import com.learn.auth.domain.UaaGroupPermission;
import com.learn.auth.dto.UaaGroupPermissionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 组-权限信息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Mapper
public interface UaaGroupPermissionConverter {

    UaaGroupPermissionConverter INSTANCE = Mappers.getMapper(UaaGroupPermissionConverter.class);

    UaaGroupPermission convert(UaaGroupPermissionDto item);

    UaaGroupPermissionDto convertDto(UaaGroupPermission item);

    List<UaaGroupPermission> convert(List<UaaGroupPermissionDto> list);

    List<UaaGroupPermissionDto> convertDto(List<UaaGroupPermission> list);

}
