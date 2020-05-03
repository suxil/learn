package com.learn.auth.converter;

import com.learn.auth.domain.UaaUserPermission;
import com.learn.auth.dto.UaaUserPermissionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 用户-权限信息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Mapper
public interface UaaUserPermissionConverter {

    UaaUserPermissionConverter INSTANCE = Mappers.getMapper(UaaUserPermissionConverter.class);

    UaaUserPermission convert(UaaUserPermissionDto item);

    UaaUserPermissionDto convertDto(UaaUserPermission item);

    List<UaaUserPermission> convert(List<UaaUserPermissionDto> list);

    List<UaaUserPermissionDto> convertDto(List<UaaUserPermission> list);

}
