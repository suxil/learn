package io.github.suxil.auth.converter;

import io.github.suxil.auth.domain.UaaUserPermission;
import io.github.suxil.auth.dto.UaaUserPermissionDto;
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
