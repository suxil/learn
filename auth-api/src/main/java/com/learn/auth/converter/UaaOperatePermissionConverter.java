package com.learn.auth.converter;

import com.learn.auth.domain.UaaOperatePermission;
import com.learn.auth.dto.UaaOperatePermissionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 操作-权限息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Mapper
public interface UaaOperatePermissionConverter {

    UaaOperatePermissionConverter INSTANCE = Mappers.getMapper(UaaOperatePermissionConverter.class);

    UaaOperatePermission convert(UaaOperatePermissionDto item);

    UaaOperatePermissionDto convertDto(UaaOperatePermission item);

    List<UaaOperatePermission> convert(List<UaaOperatePermissionDto> list);

    List<UaaOperatePermissionDto> convertDto(List<UaaOperatePermission> list);

}
