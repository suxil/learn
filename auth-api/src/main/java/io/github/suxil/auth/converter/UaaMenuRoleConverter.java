package io.github.suxil.auth.converter;

import io.github.suxil.auth.domain.UaaMenuRole;
import io.github.suxil.auth.dto.UaaMenuRoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 菜单-角色信息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Mapper
public interface UaaMenuRoleConverter {

    UaaMenuRoleConverter INSTANCE = Mappers.getMapper(UaaMenuRoleConverter.class);

    UaaMenuRole convert(UaaMenuRoleDto item);

    UaaMenuRoleDto convertDto(UaaMenuRole item);

    List<UaaMenuRole> convert(List<UaaMenuRoleDto> list);

    List<UaaMenuRoleDto> convertDto(List<UaaMenuRole> list);

}
