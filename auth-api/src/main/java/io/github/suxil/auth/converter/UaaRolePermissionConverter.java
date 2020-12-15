package io.github.suxil.auth.converter;

import io.github.suxil.auth.domain.UaaRolePermission;
import io.github.suxil.auth.dto.UaaRolePermissionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 角色-权限信息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Mapper
public interface UaaRolePermissionConverter {

    UaaRolePermissionConverter INSTANCE = Mappers.getMapper(UaaRolePermissionConverter.class);

    UaaRolePermission convert(UaaRolePermissionDto item);

    UaaRolePermissionDto convertDto(UaaRolePermission item);

    List<UaaRolePermission> convert(List<UaaRolePermissionDto> list);

    List<UaaRolePermissionDto> convertDto(List<UaaRolePermission> list);

}
